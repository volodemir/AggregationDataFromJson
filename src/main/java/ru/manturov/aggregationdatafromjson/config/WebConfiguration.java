package ru.manturov.aggregationdatafromjson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.create("http://www.mocky.io/v2/5c51b9dd3400003252129fb5");
    }
}