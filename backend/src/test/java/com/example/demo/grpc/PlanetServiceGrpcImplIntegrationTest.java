package com.example.demo.grpc;

import com.example.demo.BaseIntegrationTest;
import com.example.demo.domain.planet.PlanetService;
import com.example.demo.grpc.game.planet.DeleteAllEvent;
import com.example.demo.grpc.game.planet.DeleteOneEvent;
import com.example.demo.protobuf.PlanetProto;
import com.example.demo.protobuf.PlanetProto.PlanetDTO;
import com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import com.example.demo.protobuf.PlanetServiceGrpc.PlanetServiceBlockingStub;
import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class PlanetServiceGrpcImplIntegrationTest extends BaseIntegrationTest {

    private static final int PLANET_AMOUNT = 1;

    @Autowired private PlanetService planetService;

    @MockBean private PlanetEventListenerMock consumer;

    @GrpcClient("inProcess")
    private PlanetServiceBlockingStub planetServiceBlockingStub;

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
        final PlanetResearchResponse planetResearchResponse =
                planetServiceBlockingStub.findAll(Empty.newBuilder().build());

        Assertions.assertNotNull(planetResearchResponse);
        Assertions.assertEquals(PLANET_AMOUNT, planetResearchResponse.getPlanetsCount());
    }

    @Test
    public void deleteAllPlanets() {
        final PlanetResearchResponse planetResearchResponse =
                planetServiceBlockingStub.findAll(Empty.newBuilder().build());
        Assertions.assertNotNull(planetResearchResponse);
        Assertions.assertEquals(PLANET_AMOUNT, planetResearchResponse.getPlanetsCount());

        final Empty emptyRequest = Empty.newBuilder().build();
        planetServiceBlockingStub.removeAllPlanets(emptyRequest);

        waitForDeleteAllEventBeforeContinuing();

        final PlanetResearchResponse afterDeletionResearchResponse =
                planetServiceBlockingStub.findAll(emptyRequest);
        Assertions.assertNotNull(afterDeletionResearchResponse);
        Assertions.assertEquals(0, afterDeletionResearchResponse.getPlanetsCount());
    }

    private void waitForDeleteAllEventBeforeContinuing() {
        await().until(() -> Mockito.mockingDetails(consumer).getInvocations().size() == 1);
        verify(consumer, times(1)).listenToDeleteAll(any(DeleteAllEvent.class));
    }

    @Test
    public void deleteOnePlanet() {
        final Empty request = Empty.newBuilder().build();
        final PlanetDTO Planet = planetServiceBlockingStub.findAll(request).getPlanets(0);

        final PlanetRemoveRequest planetRemoveRequest =
                PlanetProto.PlanetRemoveRequest.newBuilder().setName(Planet.getName()).build();
        planetServiceBlockingStub.removePlanet(planetRemoveRequest);

        waitForDeleteOneEventBeforeContinuing();

        final PlanetResearchResponse planetResearchResponse =
                planetServiceBlockingStub.findAll(request);
        Assertions.assertNotNull(planetResearchResponse);
        Assertions.assertEquals(PLANET_AMOUNT - 1, planetResearchResponse.getPlanetsCount());
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
