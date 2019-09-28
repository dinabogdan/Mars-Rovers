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
    public Rover execute(Rover rover, Plateau plateau) {
        System.out.println("Start execution for command " + COMMAND_NAME + "!");
        Point futurePosition;
        switch (rover.getCurrentOrientation()) {
            case N:
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX())
                        .withY(rover.getCurrentPosition().getY() + 1)
                        .build();
                System.out.println("Command " + COMMAND_NAME + " to N, executed!");
                break;
            case E:
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX() + 1)
                        .withY(rover.getCurrentPosition().getY())
                        .build();
                System.out.println("Command " + COMMAND_NAME + " to E, executed!");
                break;
            case S:
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX())
                        .withY(rover.getCurrentPosition().getY() - 1)
                        .build();
                System.out.println("Command " + COMMAND_NAME + " to S, executed!");
                break;
            case W:
                futurePosition = Point.PointBuilder.aPoint()
                        .withX(rover.getCurrentPosition().getX() - 1)
                        .withY(rover.getCurrentPosition().getY())
                        .build();
                System.out.println("Command " + COMMAND_NAME + " to W, executed!");
                break;
            default:
                throw new IllegalArgumentException();
        }

        if (isInsideThePlateau(plateau, futurePosition)) {
            return Rover.RoverBuilder.aRover()
                    .withCurrentOrientation(rover.getCurrentOrientation())
                    .withToBeExecutedCommands(rover.getToBeExecutedCommands().subList(1, rover.getToBeExecutedCommands().size()))
                    .withCurrentPosition(futurePosition)
                    .build();
        }
        return Rover.RoverBuilder.aRover()
                .withCurrentOrientation(rover.getCurrentOrientation())
                .withCurrentPosition(rover.getCurrentPosition())
                .withToBeExecutedCommands(rover.getToBeExecutedCommands().subList(1, rover.getToBeExecutedCommands().size()))
                .build();
    }

    private boolean isInsideThePlateau(Plateau plateau, Point futurePosition) {
        final String warnMessage = "WARN! The rover should move to: " + futurePosition.toString() + " which is out of the plateau: " + plateau.toString();
        if (!(futurePosition.getX() >= plateau.getBottomLeft().getX() && futurePosition.getX() <= plateau.getUpperRight().getX())) {
            System.out.println(warnMessage);
            return false;
        }
        if (!(futurePosition.getY() >= plateau.getBottomLeft().getY() && futurePosition.getY() <= plateau.getUpperRight().getY())) {
            System.out.println(warnMessage);
            return false;
        }
        return true;
    }
}
