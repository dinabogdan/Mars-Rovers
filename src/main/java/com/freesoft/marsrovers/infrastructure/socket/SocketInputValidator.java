package com.freesoft.marsrovers.infrastructure.socket;

import com.freesoft.marsrovers.application.exception.InvalidInputException;

import java.util.List;

public enum SocketInputValidator {
    INSTANCE;

    SocketInputValidator() {
    }

    boolean isNullOrEmpty(String input) {
        return (null == input || input.trim().length() == 0);
    }

    boolean hasNotValidStructure(String[] input) {
        return (input.length - 2) % 4 == 0;
    }

    boolean isNotNumber(String inputElement) {
        String regex = "[0-9]+";
        return inputElement.matches(regex);
    }

    void validateIfNumbers(List<String> input) {
        input.forEach(s -> rejectOnTrue(
                isNotNumber(s), new InvalidInputException("The plateau dimensions are not valid")
                )
        );
    }

    void validateLength(String[] inputComponents) {
        rejectOnTrue(
                hasNotValidStructure(inputComponents),
                new InvalidInputException("The input is not valid! It should contains a no. of elements divisible by 4!")
        );
    }

    void validateIfNullOrEmpty(String input) {
        rejectOnTrue(
                isNullOrEmpty(input),
                new InvalidInputException("The input is empty!")
        );
    }

    void rejectOnTrue(boolean condition, RuntimeException ex) {
        if (condition) throw ex;
    }
}
