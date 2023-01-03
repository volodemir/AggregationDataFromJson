package ru.manturov.aggregationdatafromjson.model;

import lombok.Getter;

@Getter
public class TokenData {
    private String value;
    private long ttl;
}