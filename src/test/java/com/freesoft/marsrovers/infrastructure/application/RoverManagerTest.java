package com.freesoft.marsrovers.infrastructure.application;

import com.freesoft.marsrovers.application.RoverManager;
import com.freesoft.marsrovers.application.RoverMap;
import com.freesoft.marsrovers.domain.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class RoverManagerTest {

    private Plateau plateau;
    private RoverMap roverMap;

    @Before
    public void setUp() {
        Plateau plateau = Plateau.PlateauBuilder.aPlateau()
                .withBottomLeft(Point.PointBuilder.aPoint()
                        .withX(0)
                        .withY(0)
                        .build())
                .withUpperRight(Point.PointBuilder.aPoint()
                        .withX(5)
                        .withY(5)
                        .build())
                .build();

        roverMap = RoverMap.INSTANCE;

        Rover firstRover = Rover.RoverBuilder.aRover()
                .withCurrentPosition(Point.PointBuilder.aPoint()
                        .withX(1)
                        .withY(1)
                        .build())
                .withCurrentOrientation(CardinalPoint.N)
                .withToBeExecutedCommands(Arrays.asList(
                        TurnLeftCommand.aCommand(),
                        MoveCommand.aCommand(),
                        TurnLeftCommand.aCommand(),
                        MoveCommand.aCommand(),
                        TurnLeftCommand.aCommand(),
                        MoveCommand.aCommand(),
                        TurnLeftCommand.aCommand(),
                        MoveCommand.aCommand(),
                        MoveCommand.aCommand()
                ))
                .build();

        Rover secondRover = Rover.RoverBuilder.aRover()
                .withCurrentPosition(Point.PointBuilder.aPoint()
                        .withX(3)
                        .withY(3)
                        .build())
                .withCurrentOrientation(CardinalPoint.E)
                .withToBeExecutedCommands(Arrays.asList(
                        MoveCommand.aCommand(),
                        MoveCommand.aCommand(),
                        TurnRightCommand.aCommand(),
                        MoveCommand.aCommand(),
                        MoveCommand.aCommand(),
                        TurnRightCommand.aCommand(),
                        MoveCommand.aCommand(),
                        TurnRightCommand.aCommand(),
                        TurnRightCommand.aCommand(),
                        MoveCommand.aCommand()
                ))
                .build();
        roverMap.addRover(firstRover);
//        roverMap.addRover(secondRover);
    }

    @Test
    public void ceva() {
        RoverManager.INSTANCE.init(plateau, roverMap).startRovers();
        roverMap.getRovers().forEach((id, rover) -> System.out.println("Id: " + id + " & rover: " + rover));
    }
}
