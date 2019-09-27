package com.freesoft.marsrovers.domain;

public final class TurnLeftCommand extends Command {

    private static final String COMMAND_NAME = "TURN_LEFT";

    private TurnLeftCommand(String name) {
        super(name);
    }

    public static TurnLeftCommand aCommand() {
        return new TurnLeftCommand(COMMAND_NAME);
    }

    @Override
    Rover execute(Rover rover) {
        return null;
//        return Rover.RoverBuilder.aRover()
//                .withCurrentPosition(rover.getCurrentPosition())
//                .with
//                .build();
    }

}
