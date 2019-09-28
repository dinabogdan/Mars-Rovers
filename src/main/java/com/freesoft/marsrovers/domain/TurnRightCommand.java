package com.freesoft.marsrovers.domain;

public final class TurnRightCommand extends Command {

    private static final String COMMAND_NAME = "TURN RIGHT";

    private TurnRightCommand(String name) {
        super(name);
    }

    public static TurnRightCommand aCommand() {
        return new TurnRightCommand(COMMAND_NAME);
    }

    @Override
    public Rover execute(Rover rover, Plateau plateau) {
        System.out.println("Start execution for command " + COMMAND_NAME + "!");
        CardinalPoint futureOrientation;
        switch (rover.getCurrentOrientation()) {
            case N:
                futureOrientation = CardinalPoint.E;
                System.out.println("Command " + COMMAND_NAME + " executed!");
                break;
            case E:
                futureOrientation = CardinalPoint.S;
                System.out.println("Command " + COMMAND_NAME + " executed!");
                break;
            case S:
                futureOrientation = CardinalPoint.W;
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
                .withCurrentOrientation(futureOrientation)
                .withCurrentPosition(rover.getCurrentPosition())
                .withToBeExecutedCommands(rover.getToBeExecutedCommands().subList(1, rover.getToBeExecutedCommands().size()))
                .build();

    }
}
