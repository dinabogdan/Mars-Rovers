package com.freesoft.marsrovers.domain;

public enum CardinalPoint {
    N("North"), S("South"), E("East"), W("West");

    private final String value;

    CardinalPoint(String value) {
        this.value = value;
    }
}
