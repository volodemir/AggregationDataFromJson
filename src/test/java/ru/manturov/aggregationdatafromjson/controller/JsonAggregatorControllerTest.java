package ru.manturov.aggregationdatafromjson.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import ru.manturov.aggregationdatafromjson.service.JsonAggregatorService;


@WebFluxTest(JsonAggregatorController.class)
@RunWith(SpringRunner.class)
class JsonAggregatorControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    JsonAggregatorService jsonAggregatorService;

    @Test
    public void getAllCameraInfo(){
        webTestClient
                .get()
                .uri("/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}