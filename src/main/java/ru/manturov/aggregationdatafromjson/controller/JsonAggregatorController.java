package ru.manturov.aggregationdatafromjson.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ru.manturov.aggregationdatafromjson.model.CameraFullAggregatedInfo;
import ru.manturov.aggregationdatafromjson.service.JsonAggregatorService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class JsonAggregatorController {
    private final JsonAggregatorService jsonAggregatorService;

    @GetMapping()
    public Flux<CameraFullAggregatedInfo> getAllCameraInfo() {
        return jsonAggregatorService.getAllCameraInfo();
    }
}