package com.freesoft.marsrovers.infrastructure.socket;


import com.freesoft.marsrovers.domain.RoverMap;

public enum SocketOutputParser {
    INSTANCE;

    String buildOutput(RoverMap roverMap) {
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
