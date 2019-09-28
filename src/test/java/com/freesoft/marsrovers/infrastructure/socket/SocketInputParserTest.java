package com.freesoft.marsrovers.infrastructure.socket;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SocketInputParserTest {

    @Test
    public void GIVENAnInputWHENParsingItTHENReturnTheExpectedResult() {
        List<String> input = SocketInputParser.INSTANCE.splitInput("5 5 1 2 N LMLMLMLMM");
        assertEquals("5", input.get(0));
        assertEquals("5", input.get(1));
        assertEquals("1", input.get(2));
        assertEquals("2", input.get(3));
        assertEquals("N", input.get(4));
        assertEquals("LMLMLMLMM", input.get(5));

    }

}
