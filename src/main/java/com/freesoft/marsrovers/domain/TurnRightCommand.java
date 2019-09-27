package com.freesoft.marsrovers.domain;

public final class TurnRightCommand extends Command {

    private static final String COMMAND_NAME = "TURN_RIGHT";

    private TurnRightCommand(String name) {
        super(name);
    }

    @Override
    Rover execute(Rover rover) {
        return null;
    }

    public static TurnRightCommand aCommand() {
        return new TurnRightCommand(COMMAND_NAME);
    }
}
