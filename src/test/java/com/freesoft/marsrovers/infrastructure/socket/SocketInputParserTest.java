package com.freesoft.marsrovers.infrastructure.socket;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SocketInputParserTest {

    @Test
    public void GIVENAnInputWHENParsingItTHENReturnTheExpectedResult() {
        String[] input = SocketInputParser.INSTANCE.splitInput("5 5 1 2 N LMLMLMLMM");
        assertEquals("5", input[0]);
        assertEquals("5", input[1]);
        assertEquals("1", input[2]);
        assertEquals("2", input[3]);
        assertEquals("N", input[4]);
        assertEquals("LMLMLMLMM", input[5]);

    }

}
