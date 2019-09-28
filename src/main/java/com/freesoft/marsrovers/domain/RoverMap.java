package com.freesoft.marsrovers.domain;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public enum RoverMap {
    INSTANCE(new ConcurrentHashMap<>());

    private static AtomicInteger roverIdCounter = new AtomicInteger(0);
    private final ConcurrentHashMap<Integer, Rover> rovers;

    RoverMap(ConcurrentHashMap<Integer, Rover> rovers) {
        this.rovers = rovers;
    }

    public RoverMap addRover(Rover rover) {
        int roverId = roverIdCounter.incrementAndGet();
        Rover newRover = Rover.RoverBuilder.aRover()
                .withToBeExecutedCommands(rover.getToBeExecutedCommands())
                .withCurrentPosition(rover.getCurrentPosition())
                .withCurrentOrientation(rover.getCurrentOrientation())
                .withId(roverId)
                .build();
        rovers.put(roverId, newRover);
        return this;
    }

    public ConcurrentHashMap<Integer, Rover> getRovers() {
        return rovers;
    }
}
