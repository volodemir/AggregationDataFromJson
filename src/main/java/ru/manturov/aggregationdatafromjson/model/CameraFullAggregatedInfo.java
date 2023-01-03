package ru.manturov.aggregationdatafromjson.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class CameraFullAggregatedInfo {
    private long id;
    private UrlType urlType;
    private String videoUrl;
    private String value;
    private long ttl;
}