package ru.manturov.aggregationdatafromjson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.manturov.aggregationdatafromjson.model.Camera;
import ru.manturov.aggregationdatafromjson.model.CameraFullAggregatedInfo;
import ru.manturov.aggregationdatafromjson.model.SourceData;
import ru.manturov.aggregationdatafromjson.model.TokenData;

@Service
@RequiredArgsConstructor
public class JsonAggregatorService {
    private final WebClient webClient;

    public Flux<CameraFullAggregatedInfo> getAllCameraInfo() {
        return webClient
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Camera.class)
                .flatMap(cam -> {
                    Mono<SourceData> sourceDataMono = webClient
                            .get()
                            .uri(cam.getSourceDataUrl())
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToMono(SourceData.class);

                    Mono<TokenData> tokenDataMono = webClient
                            .get()
                            .uri(cam.getTokenDataUrl())
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToMono(TokenData.class);

                    return Mono.zip(sourceDataMono, tokenDataMono)
                            .map(result ->
                                    new CameraFullAggregatedInfo()
                                            .setId(cam.getId())
                                            .setUrlType(result.getT1().getUrlType())
                                            .setVideoUrl(result.getT1().getVideoUrl())
                                            .setValue(result.getT2().getValue())
                                            .setTtl(result.getT2().getTtl())
                            );
                });
    }
}