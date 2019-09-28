package com.freesoft.marsrovers.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AvoidRoverClashingTest {

    private Rover firstRover;
    private Rover secondRover;
    private Rover thirdRover;

    private RoverMap roverMap = RoverMap.INSTANCE;

    @Before
    public void setUp() {
        firstRover = Rover.RoverBuilder.aRover()
                .withCurrentOrientation(CardinalPoint.N)
                .withToBeExecutedCommands(Collections.emptyList())
                .withCurrentPosition(Point.PointBuilder.aPoint()
                        .withX(3)
                        .withY(3)
                        .build())
                .build();
        secondRover = Rover.RoverBuilder.aRover()
                .withCurrentOrientation(CardinalPoint.E)
                .withCurrentPosition(Point.PointBuilder.aPoint()
                        .withX(1)
                        .withY(2)
                        .build())
                .withToBeExecutedCommands(Collections.emptyList())
                .build();
        thirdRover = Rover.RoverBuilder.aRover()
                .withCurrentPosition(Point.PointBuilder.aPoint()
                        .withX(2)
                        .withY(2)
                        .build())
                .withCurrentOrientation(CardinalPoint.S)
                .withToBeExecutedCommands(Collections.emptyList())
                .build();
        roverMap.addRover(firstRover).addRover(secondRover).addRover(thirdRover);
    }

    @Test
    public void GIVENARoverThatShouldMoveToAPointThatIsOccupiedByAnotherOneWHENCheckIfItWillNotHitAnotherRoverTHENReturnFalse() {
        assertFalse(firstRover.isNotHittingAnotherRover.apply(
                Point.PointBuilder
                        .aPoint()
                        .withX(secondRover.getCurrentPosition().getX())
                        .withY(secondRover.getCurrentPosition().getY())
                        .build()
                )
        );
    }

    @Test
    public void GIVENARoverThatShouldMoveToAPointThatIsNotOccupiedByAnotherOneWHENCheckIfItWillNotHitAnotherRoverTHENReturnTrue() {
        assertTrue(firstRover.isNotHittingAnotherRover.apply(
                Point.PointBuilder
                        .aPoint()
                        .withX(4)
                        .withY(4)
                        .build()
                )
        );
    }
}
