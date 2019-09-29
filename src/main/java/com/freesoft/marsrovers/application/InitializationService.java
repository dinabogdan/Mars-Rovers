package com.freesoft.marsrovers.application;

import com.freesoft.marsrovers.domain.Plateau;
import com.freesoft.marsrovers.domain.Rover;
import com.freesoft.marsrovers.domain.RoverMap;

import java.util.List;
import java.util.function.Function;

public enum InitializationService {
    INSTANCE;

    public Function<String, String> execute = (input) -> {
        InputParser inputParser = InputParser.INSTANCE;
        List<String> inputComponents = inputParser.splitInput(input);
        Plateau plateau = inputParser.createPlateau(inputComponents.get(0), inputComponents.get(1));
        List<Rover> rovers = inputParser.createRovers(inputComponents.subList(2, inputComponents.size()));
        rovers.forEach(RoverMap.INSTANCE::addRover);
        RoverManager.INSTANCE.init(plateau, RoverMap.INSTANCE).startRovers();
        return OutputBuilder.INSTANCE.buildOutput(RoverMap.INSTANCE);
    };
}
