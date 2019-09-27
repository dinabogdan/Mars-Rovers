package com.freesoft.marsrovers.application;

import com.freesoft.marsrovers.domain.Rover;

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
        rovers.put(roverIdCounter.incrementAndGet(), rover);
        return this;
    }

    public ConcurrentHashMap<Integer, Rover> getRovers() {
        return rovers;
    }
}
