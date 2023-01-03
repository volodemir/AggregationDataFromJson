package ru.manturov.aggregationdatafromjson.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import ru.manturov.aggregationdatafromjson.model.CameraFullAggregatedInfo;

import java.util.List;
import java.util.Objects;

@SpringBootTest
@RunWith(SpringRunner.class)
class JsonAggregatorServiceTest {

    @Autowired
    private JsonAggregatorService subj;

    @Test
    void getAllCameraInfo() {
        List<CameraFullAggregatedInfo> list = subj.getAllCameraInfo().collectList().block();

        assertFalse(list.isEmpty());
        assertEquals(4, list.size());
        assertTrue(list.stream().noneMatch(Objects::isNull));
    }
}