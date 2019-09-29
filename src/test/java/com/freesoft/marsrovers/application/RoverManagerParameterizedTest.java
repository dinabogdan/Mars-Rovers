package com.freesoft.marsrovers.application;

import com.freesoft.marsrovers.domain.RoverMap;
import com.freesoft.marsrovers.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class RoverManagerParameterizedTest {

    private static Point initialPosition = Point.PointBuilder.aPoint()
            .withX(1)
            .withY(2)
            .build();
    private static Plateau plateau = Plateau.PlateauBuilder.aPlateau()
            .withUpperRight(Point.PointBuilder.aPoint()
                    .withX(5)
                    .withY(5)
                    .build())
            .withBottomLeft(Point.PointBuilder.aPoint()
                    .withX(0)
                    .withY(0)
                    .build())
            .build();

    @Parameter
    public int index;
    @Parameter(1)
    public Rover inputRover;
    @Parameter(2)
    public Rover expectedRover;
    private RoverManager roverManager;

    @Parameters
    public static List<Object[]> rovers() {

        return Arrays.asList(new Object[][]{
                {
                        1,
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(initialPosition)
                                .withCurrentOrientation(CardinalPoint.N)
                                .withToBeExecutedCommands(Arrays.asList(
                                        TurnLeftCommand.aCommand(),
                                        MoveCommand.aCommand()
                                        )
                                )
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.W)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(initialPosition.getX() - 1)
                                        .withY(initialPosition.getY())
                                        .build()
                                )
                                .withToBeExecutedCommands(Collections.emptyList())
                                .build()
                },
                {
                        2,
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(initialPosition)
                                .withCurrentOrientation(CardinalPoint.N)
                                .withToBeExecutedCommands(Arrays.asList(
                                        TurnRightCommand.aCommand(),
                                        MoveCommand.aCommand()
                                        )
                                )
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.E)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(initialPosition.getX() + 1)
                                        .withY(initialPosition.getY())
                                        .build()
                                )
                                .withToBeExecutedCommands(Collections.emptyList())
                                .build()
                },
                {
                        3,
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(initialPosition)
                                .withCurrentOrientation(CardinalPoint.E)
                                .withToBeExecutedCommands(Arrays.asList(
                                        TurnRightCommand.aCommand(),
                                        MoveCommand.aCommand()
                                        )
                                )
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.S)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(initialPosition.getX())
                                        .withY(initialPosition.getY() - 1)
                                        .build()
                                )
                                .build()
                },
                {
                        4,
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(initialPosition)
                                .withCurrentOrientation(CardinalPoint.E)
                                .withToBeExecutedCommands(Arrays.asList(
                                        TurnLeftCommand.aCommand(),
                                        MoveCommand.aCommand()
                                        )
                                )
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.N)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(initialPosition.getX())
                                        .withY(initialPosition.getY() + 1)
                                        .build()
                                )
                                .build()
                },
                {
                        5,
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(initialPosition)
                                .withCurrentOrientation(CardinalPoint.S)
                                .withToBeExecutedCommands(Arrays.asList(
                                        TurnLeftCommand.aCommand(),
                                        MoveCommand.aCommand()
                                        )
                                )
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.E)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(initialPosition.getX() + 1)
                                        .withY(initialPosition.getY())
                                        .build()
                                )
                                .build()
                },
                {
                        6,
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(initialPosition)
                                .withCurrentOrientation(CardinalPoint.S)
                                .withToBeExecutedCommands(Arrays.asList(
                                        TurnRightCommand.aCommand(),
                                        MoveCommand.aCommand()
                                        )
                                )
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.W)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(initialPosition.getX() - 1)
                                        .withY(initialPosition.getY())
                                        .build()
                                )
                                .withToBeExecutedCommands(Collections.emptyList())
                                .build()
                },
                {
                        7,
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(initialPosition)
                                .withCurrentOrientation(CardinalPoint.W)
                                .withToBeExecutedCommands(Arrays.asList(
                                        MoveCommand.aCommand(),
                                        MoveCommand.aCommand(),
                                        TurnLeftCommand.aCommand(),
                                        MoveCommand.aCommand(),
                                        MoveCommand.aCommand(),
                                        MoveCommand.aCommand(),
                                        TurnLeftCommand.aCommand(),
                                        MoveCommand.aCommand()
                                        )
                                )
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.E)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(1)
                                        .withY(0)
                                        .build()
                                )
                                .withToBeExecutedCommands(Collections.emptyList())
                                .build()
                },
                {
                        8,
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.N)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(1)
                                        .withY(2)
                                        .build()
                                )
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
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(1)
                                        .withY(3)
                                        .build()
                                )
                                .withCurrentOrientation(CardinalPoint.N)
                                .withToBeExecutedCommands(Collections.emptyList())
                                .build()
                },
                {
                        9,
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.E)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(3)
                                        .withY(3)
                                        .build()
                                )
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
                                .build(),
                        Rover.RoverBuilder.aRover()
                                .withCurrentOrientation(CardinalPoint.E)
                                .withCurrentPosition(Point.PointBuilder.aPoint()
                                        .withX(5)
                                        .withY(1)
                                        .build()
                                )
                                .withToBeExecutedCommands(Collections.emptyList())
                                .build()
                }

        });
    }

    @Before
    public void setUp() {
        roverManager = RoverManager.INSTANCE.init(plateau, RoverMap.INSTANCE);
    }

    @Test
    public void GIVENASetOfParametersWHENStartingTheRoversTHENReturnAllTheDesiredRoverStates() {
        RoverMap.INSTANCE.addRover(inputRover);
        roverManager.startRovers();
        Rover resultedRover = RoverMap.INSTANCE.getRovers().get(index);

        assertNotNull(resultedRover);
        assertEquals(expectedRover.getCurrentOrientation(), resultedRover.getCurrentOrientation());
        assertEquals(expectedRover.getToBeExecutedCommands(), resultedRover.getToBeExecutedCommands());
        assertEquals(expectedRover.getCurrentPosition(), resultedRover.getCurrentPosition());
    }
}
