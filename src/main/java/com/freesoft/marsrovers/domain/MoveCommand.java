package com.freesoft.marsrovers.domain;

public final class MoveCommand extends Command {

    private static final String COMMAND_NAME = "MOVE";

    private MoveCommand(String name) {
        super(name);
    }

    public static MoveCommand aCommand() {
        return new MoveCommand(COMMAND_NAME);
    }

    @Override
    Rover execute(Rover rover) {
        System.out.println("Start execution for command " + COMMAND_NAME + "!");
        Point futurePosition;
        switch (rover.getCurrentOrientation()) {
            case N:
                System.out.println("Command " + COMMAND_NAME + " to N, executed!");
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX())
                        .withY(rover.getCurrentPosition().getY() + 1)
                        .build();
                break;
            case E:
                System.out.println("Command " + COMMAND_NAME + " to E, executed!");
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX() + 1)
                        .withY(rover.getCurrentPosition().getY())
                        .build();
                break;
            case S:
                System.out.println("Command " + COMMAND_NAME + " to S, executed!");
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX())
                        .withY(rover.getCurrentPosition().getY() - 1)
                        .build();
                break;
            case W:
                System.out.println("Command " + COMMAND_NAME + " to W, executed!");
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX() - 1)
                        .withY(rover.getCurrentPosition().getY())
                        .build();
                break;
            default:
                throw new IllegalArgumentException();
        }

        return Rover.RoverBuilder.aRover()
                .withCurrentOrientation(rover.getCurrentOrientation())
                .withToBeExecutedCommands(rover.getToBeExecutedCommands().subList(1, rover.getToBeExecutedCommands().size() + 1))
                .withCurrentPosition(futurePosition)
                .build();
    }
}
