package com.freesoft.marsrovers.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class InitializationServiceParameterizedTest {

    @Parameterized.Parameter
    public String input;
    @Parameterized.Parameter(1)
    public String output;

    @Parameterized.Parameters
    public static List<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {
                        "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM",
                        "1 3 N 5 1 E "
                }
        });
    }

    @Test
    public void GIVENASetOfInputStringsWHENCallingExecuteMethodTHENReturnTheExpectedOutput() {
        String result = InitializationService.INSTANCE.execute.apply(input);
        assertEquals(output, result);
    }

}
