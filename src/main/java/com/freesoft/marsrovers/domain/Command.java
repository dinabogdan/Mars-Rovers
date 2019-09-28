package com.freesoft.marsrovers.domain;

public abstract class Command {

    private final String name;

    Command(String name) {
        this.name = name;
    }

    public abstract Rover execute(Rover rover, Plateau plateau);
}
