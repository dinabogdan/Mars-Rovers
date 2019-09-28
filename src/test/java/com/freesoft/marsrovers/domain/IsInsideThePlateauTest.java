package com.freesoft.marsrovers.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsInsideThePlateauTest {

    @Parameter
    public Point input;
    @Parameter(1)
    public boolean expectedResult;
    private Plateau plateau;

    @Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {
                        Point.PointBuilder.aPoint()
                                .withX(1)
                                .withY(2)
                                .build(),
                        true
                },
                {
                        Point.PointBuilder.aPoint()
                                .withX(6)
                                .withY(2)
                                .build(),
                        false
                },
                {
                        Point.PointBuilder.aPoint()
                                .withX(2)
                                .withY(6)
                                .build(),
                        false
                },
                {
                        Point.PointBuilder.aPoint()
                                .withX(7)
                                .withY(6)
                                .build(),
                        false
                }
        });
    }

    @Before
    public void setUp() {
        plateau = Plateau.PlateauBuilder.aPlateau()
                .withBottomLeft(Point.PointBuilder.aPoint()
                        .withX(0)
                        .withY(0)
                        .build())
                .withUpperRight(Point.PointBuilder.aPoint()
                        .withX(5)
                        .withY(5)
                        .build())
                .build();
    }

    @Test
    public void GIVENAPlateauAndASetOfPointsWHENCheckIfPlateauContainsEachPointTHENReturnTheExpectedResults() {
        Boolean result = plateau.containsPoint.apply(input);
        assertEquals(expectedResult, result);
    }

}
