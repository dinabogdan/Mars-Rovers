package com.freesoft.marsrovers.application;

import com.freesoft.marsrovers.domain.Plateau;
import com.freesoft.marsrovers.domain.Rover;

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
            executeCommands(id, plateau);
        });
    }

    void executeCommands(Integer roverId, Plateau plateau) {
        Rover rover = roverMap.getRovers().get(roverId);
        rover.getToBeExecutedCommands().forEach(command -> {
            Rover newRover = command.execute(roverMap.getRovers().get(roverId), plateau);
            roverMap.getRovers().put(roverId, newRover);
        });
    }
}
