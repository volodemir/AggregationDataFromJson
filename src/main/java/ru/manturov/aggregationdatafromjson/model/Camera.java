package ru.manturov.aggregationdatafromjson.model;

import lombok.Getter;

@Getter
public class Camera {
    private long id;
    private String sourceDataUrl;
    private String tokenDataUrl;
}