package com.freesoft.marsrovers.application;


import com.freesoft.marsrovers.domain.RoverMap;

public enum OutputBuilder {
    INSTANCE;

    public String buildOutput(RoverMap roverMap) {
        StringBuilder stringBuilder = new StringBuilder();
        roverMap.getRovers()
                .values()
                .forEach(rover -> {
                    stringBuilder.append(rover.getCurrentPosition().getX());
                    stringBuilder.append(" ");
                    stringBuilder.append(rover.getCurrentPosition().getY());
                    stringBuilder.append(" ");
                    stringBuilder.append(rover.getCurrentOrientation().name());
                    stringBuilder.append(" ");
                });
        return stringBuilder.toString();
    }
}
