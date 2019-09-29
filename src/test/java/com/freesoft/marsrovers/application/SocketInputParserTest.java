package com.freesoft.marsrovers.application;

import com.freesoft.marsrovers.domain.CardinalPoint;
import com.freesoft.marsrovers.domain.Rover;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SocketInputParserTest {

    @Test
    public void GIVENAnInputWHENParsingItTHENReturnTheExpectedResult() {
        List<String> input = InputParser.INSTANCE.splitInput("5 5 1 2 N LMLMLMLMM");
        assertEquals("5", input.get(0));
        assertEquals("5", input.get(1));
        assertEquals("1", input.get(2));
        assertEquals("2", input.get(3));
        assertEquals("N", input.get(4));
        assertEquals("LMLMLMLMM", input.get(5));
    }

    @Test
    public void GIVENAStringListWithRoversDetailsWHENParsingItTHENCreateAListOfRovers() {
        List<String> input = Arrays.asList(
                "1",
                "2",
                "N",
                "LMLMLMLMM",
                "3",
                "3",
                "E",
                "MMRMMRMRRM"
        );

        List<Rover> rovers = InputParser.INSTANCE.createRovers(input);
        assertNotNull(rovers);
        assertEquals(2, rovers.size());
        assertEquals(1, rovers.get(0).getCurrentPosition().getX(), 0);
        assertEquals(2, rovers.get(0).getCurrentPosition().getY(), 0);
        assertEquals(CardinalPoint.N, rovers.get(0).getCurrentOrientation());
        assertEquals(9, rovers.get(0).getToBeExecutedCommands().size());
    }
}
