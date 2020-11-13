package com.example.demo.controller.planet;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.BaseRestIntegrationTest;
import com.example.demo.IntegrationTestUtils.PlanetUrlEnum;
import com.example.demo.protobuf.PlanetProto.PlanetDTO;
import com.example.demo.protobuf.PlanetProto.PlanetInitRequest;
import com.example.demo.protobuf.PlanetProto.PlanetRemoveRequest;
import com.example.demo.protobuf.PlanetProto.PlanetResearchResponse;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

class PlanetControllerTest extends BaseRestIntegrationTest {

    private static int PLANET_AMOUNT = 5;

    @Autowired private PlanetController controller;

    @Autowired private TestRestTemplate restTemplate;

    @BeforeEach
    public void init() {
        doPostInitPlanets(PLANET_AMOUNT);
    }

    @AfterEach
    void clean() {
        doPostDeleteAllPlanets();
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getAllPlanets() {
        PlanetResearchResponse response = doGetAllPlanets();
        Assert.assertNotNull(response);
        Assert.assertEquals(PLANET_AMOUNT, response.getPlanetsCount());
    }

    private void doPostInitPlanets(int amount) {
        String initUrl = PlanetUrlEnum.toUrl(PlanetUrlEnum.INIT, getPort());
        PlanetInitRequest initRequest = PlanetInitRequest.newBuilder().setAmount(amount).build();

        restTemplate.postForObject(initUrl, initRequest, Void.class);
    }

    private PlanetResearchResponse doGetAllPlanets() {
        String findAllUrl = PlanetUrlEnum.toUrl(PlanetUrlEnum.FIND_ALL, getPort());

        return restTemplate.getForObject(findAllUrl, PlanetResearchResponse.class);
    }

    @Test
    public void deleteAllPlanets() {
        doPostDeleteAllPlanets();
        PlanetResearchResponse response = doGetAllPlanets();
        Assert.assertNull(response);
    }

    private void doPostDeleteAllPlanets() {
        String deleteAllUrl = PlanetUrlEnum.toUrl(PlanetUrlEnum.REMOVE_ALL, getPort());

        restTemplate.postForObject(deleteAllUrl, null, Void.class);
    }

    @Test
    public void deleteOnePlanet() {
        PlanetDTO Planet = doGetAllPlanets().getPlanets(0);

        doPostDeleteOnePlanet(Planet.getName());

        PlanetResearchResponse response = doGetAllPlanets();
        Assert.assertNotNull(response);
        Assert.assertEquals(PLANET_AMOUNT - 1, response.getPlanetsCount());
    }

    private void doPostDeleteOnePlanet(String name) {
        String deleteOneUrl = PlanetUrlEnum.toUrl(PlanetUrlEnum.REMOVE_SINGLE, getPort());
        PlanetRemoveRequest deleteRequest = PlanetRemoveRequest.newBuilder().setName(name).build();

        restTemplate.postForObject(deleteOneUrl, deleteRequest, Void.class);
    }
}
