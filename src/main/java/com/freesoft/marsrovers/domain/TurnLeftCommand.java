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
    public Rover execute(Rover rover, Plateau plateau) {
        System.out.println("Start execution for command " + COMMAND_NAME + "!");
        CardinalPoint futureOrientation;
        switch (rover.getCurrentOrientation()) {
            case N:
                futureOrientation = CardinalPoint.W;
                System.out.println("Command " + COMMAND_NAME + " executed!");
                break;
            case E:
                futureOrientation = CardinalPoint.S;
                System.out.println("Command " + COMMAND_NAME + " executed!");
                break;
            case S:
                futureOrientation = CardinalPoint.E;
                System.out.println("Command " + COMMAND_NAME + " executed!");
                break;
            case W:
                futureOrientation = CardinalPoint.N;
                System.out.println("Command " + COMMAND_NAME + " executed!");
                break;
            default:
                throw new IllegalArgumentException();
        }

        return Rover.RoverBuilder.aRover()
                .withCurrentPosition(rover.getCurrentPosition())
                .withCurrentOrientation(futureOrientation)
                .withToBeExecutedCommands(rover.getToBeExecutedCommands().subList(1, rover.getToBeExecutedCommands().size()))
                .build();

    }

}
