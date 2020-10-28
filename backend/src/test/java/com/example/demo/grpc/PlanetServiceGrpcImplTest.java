package com.example.demo.grpc;

import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.demo.BaseGrpcIntegrationTest;
import com.example.demo.domain.planet.PlanetService;
import com.example.demo.grpc.planet.DeleteAllEvent;
import com.example.demo.grpc.planet.DeleteOneEvent;
import com.example.demo.protobuf.PlanetGrpcServiceGrpc.PlanetGrpcServiceBlockingStub;
import com.example.demo.protobuf.PlanetProto;
import com.example.demo.protobuf.PlanetProto.PlanetDTO;
import com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.event.TransactionalEventListener;

class PlanetServiceGrpcImplTest extends BaseGrpcIntegrationTest {

    private static final int PLANET_AMOUNT = 1;

    @Autowired private PlanetService planetService;

    @MockBean private PlanetEventListenerMock consumer;

    @GrpcClient("inProcess")
    private PlanetGrpcServiceBlockingStub planetServiceBlockingStub;

    @BeforeEach
    public void init() {
        planetService.initPlanets(PLANET_AMOUNT);
    }

    @AfterEach
    public void clean() {
        planetService.removeAllPlanets();
        await().until(() -> planetService.findAllPlanets().isEmpty());
    }

    @Test
    public void getAllPlanets() {
        PlanetResearchResponse planetResearchResponse =
                planetServiceBlockingStub.findAll(Empty.newBuilder().build());
        Assert.assertNotNull(planetResearchResponse);
        Assert.assertEquals(PLANET_AMOUNT, planetResearchResponse.getPlanetsCount());
    }

    @Test
    public void deleteAllPlanets() {
        PlanetResearchResponse planetResearchResponse =
                planetServiceBlockingStub.findAll(Empty.newBuilder().build());
        Assert.assertNotNull(planetResearchResponse);
        Assert.assertEquals(PLANET_AMOUNT, planetResearchResponse.getPlanetsCount());

        Empty emptyRequest = Empty.newBuilder().build();
        planetServiceBlockingStub.removeAllPlanets(emptyRequest);

        waitForDeleteAllEventBeforeContinuing();

        PlanetResearchResponse afterDeletionResearchResponse =
                planetServiceBlockingStub.findAll(emptyRequest);
        Assert.assertNotNull(afterDeletionResearchResponse);
        Assert.assertEquals(0, afterDeletionResearchResponse.getPlanetsCount());
    }

    private void waitForDeleteAllEventBeforeContinuing() {
        await().until(() -> Mockito.mockingDetails(consumer).getInvocations().size() == 1);
        verify(consumer, times(1)).listenToDeleteAll(any(DeleteAllEvent.class));
    }

    @Test
    public void deleteOnePlanet() {
        Empty request = Empty.newBuilder().build();
        PlanetDTO Planet = planetServiceBlockingStub.findAll(request).getPlanets(0);

        PlanetRemoveRequest planetRemoveRequest =
                PlanetProto.PlanetRemoveRequest.newBuilder().setName(Planet.getName()).build();
        planetServiceBlockingStub.removePlanet(planetRemoveRequest);

        waitForDeleteOneEventBeforeContinuing();

        PlanetResearchResponse planetResearchResponse = planetServiceBlockingStub.findAll(request);
        Assert.assertNotNull(planetResearchResponse);
        Assert.assertEquals(PLANET_AMOUNT - 1, planetResearchResponse.getPlanetsCount());
    }

    private void waitForDeleteOneEventBeforeContinuing() {
        await().until(() -> Mockito.mockingDetails(consumer).getInvocations().size() == 1);
        verify(consumer, times(1)).listenToDeleteOne(any(DeleteOneEvent.class));
    }

    @TestComponent
    private static class PlanetEventListenerMock {

        @TransactionalEventListener
        public void listenToDeleteAll(DeleteAllEvent deleteAllEvent) {}

        @TransactionalEventListener
        public void listenToDeleteOne(DeleteOneEvent deleteOneEvent) {}
    }
}
