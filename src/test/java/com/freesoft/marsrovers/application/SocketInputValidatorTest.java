package com.freesoft.marsrovers.application;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SocketInputValidatorTest {

    @Test
    public void GIVENAValidInputSequenceWHENCheckIfHasNotAValidStructureTHENReturnFalse() {
        final String[] input = new String[]{"5", "5", "1", "2", "N", "LMLML", "3", "3", "E", "MRMRMRMR"};
        boolean validationResult = InputValidator.INSTANCE.hasNotValidStructure(input);
        assertFalse(validationResult);
    }

    @Test
    public void GIVENAnInvalidInputSequenceWHENCheckIfHasNotAValidStructureTHENReturnTrue() {
        final String[] input = new String[]{"5", "5", "1", "2", "N", "LMLML", "3", "3", "E"};
        boolean validationResult = InputValidator.INSTANCE.hasNotValidStructure(input);
        assertTrue(validationResult);
    }

    @Test
    public void GIVENANullInputSequenceWHENValidateItTHENReturnTrue() {
        final String input = null;
        boolean result = InputValidator.INSTANCE.isNullOrEmpty(input);
        assertTrue(result);
    }

    @Test
    public void GIVENANotEmptyInputSequenceWHENValidateItTHENReturnFalse() {
        final String input = "something";
        boolean result = InputValidator.INSTANCE.isNullOrEmpty(input);
        assertFalse(result);
    }

    @Test
    public void GIVENAnEmptyInputSequenceWHENValidateItTHENReturnTrue() {
        final String input = "                   ";
        boolean result = InputValidator.INSTANCE.isNullOrEmpty(input);
        assertTrue(result);
    }

    @Test
    public void GIVENANumberWHENCheckIfIsNotANumberTHENReturnFalse() {
        String number = "5";
        assertFalse(InputValidator.INSTANCE.isNotNumber(number));
    }

    @Test
    public void GIVENAnInvalidNumberWHENCheckIfItsNotANumberTHENReturnTrue() {
        String invalidNumber = "3a";
        assertTrue(InputValidator.INSTANCE.isNotNumber(invalidNumber));
    }
}
