package com.freesoft.marsrovers.application;

import com.freesoft.marsrovers.domain.Plateau;

public enum RoverManager {
    INSTANCE;
    private static Plateau plateau;
    private static RoverMap roverMap;

    RoverManager() {

    }

    public RoverManager init(Plateau plateau, RoverMap roverMap) {
        RoverManager.plateau = plateau;
        RoverManager.roverMap = roverMap;
        return this;
    }

    public void startRovers() {
        roverMap.getRovers().forEach((id, rover) -> {
            rover.executeCommands(plateau);
            roverMap.getRovers().remove(id);
        });
    }
}
