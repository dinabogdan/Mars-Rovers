package com.freesoft.marsrovers.application;

import com.freesoft.marsrovers.application.exception.InvalidInputException;
import com.freesoft.marsrovers.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum InputParser {
    INSTANCE;

    private Function<String, Command> stringToCommandFunction = c -> {
        switch (c) {
            case "M":
                return MoveCommand.aCommand();
            case "L":
                return TurnLeftCommand.aCommand();
            case "R":
                return TurnRightCommand.aCommand();
            default:
                throw new InvalidInputException("One of the commands was not valid!");

        }
    };

    InputParser() {

    }

    public List<String> splitInput(String input) {
        final String WHITE_SPACE = " ";
        InputValidator.INSTANCE.validateIfNullOrEmpty(input);
        String[] inputComponents = input.split(WHITE_SPACE);
        InputValidator.INSTANCE.validateLength(inputComponents);
        return Arrays.asList(inputComponents);
    }

    public Plateau createPlateau(String firstInputElement, String secondInputElement) {
        InputValidator.INSTANCE.validateIfNumbers(Arrays.asList(firstInputElement, secondInputElement));
        return Plateau.PlateauBuilder.aPlateau()
                .withBottomLeft(Point.PointBuilder
                        .aPoint()
                        .withX(0)
                        .withY(0)
                        .build())
                .withUpperRight(Point.PointBuilder
                        .aPoint()
                        .withX(Long.parseLong(firstInputElement))
                        .withY(Long.parseLong(secondInputElement))
                        .build())
                .build();
    }

    public List<Rover> createRovers(List<String> roversInput) {
        List<List<String>> roversInputSplitted = new ArrayList<>();
        for (int i = 0; i < roversInput.size(); i += 4) {
            roversInputSplitted.add(roversInput.subList(i, i + 4));
        }
        return roversInputSplitted.stream()
                .map(this::createRover)
                .collect(Collectors.toList());
    }

    private Rover createRover(List<String> roverInput) {
        InputValidator.INSTANCE.validateIfNumbers(Collections.singletonList(roverInput.get(0)));
        Point currentPosition = parsePositionDetails(roverInput);
        CardinalPoint currentOrientation = CardinalPoint.valueOf(roverInput.get(2));
        List<Command> toBeExecutedCommands = parseToBeExecutedCommands(roverInput);

        return Rover.RoverBuilder.aRover()
                .withCurrentOrientation(currentOrientation)
                .withCurrentPosition(currentPosition)
                .withToBeExecutedCommands(toBeExecutedCommands)
                .build();

    }

    private Point parsePositionDetails(List<String> roverInput) {
        return Point.PointBuilder
                .aPoint()
                .withX(Double.parseDouble(roverInput.get(0)))
                .withY(Double.parseDouble(roverInput.get(1)))
                .build();
    }

    private List<Command> parseToBeExecutedCommands(List<String> roverInput) {
        return roverInput.get(3).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList())
                .stream()
                .map(String::valueOf)
                .map(stringToCommandFunction)
                .collect(Collectors.toList());
    }


}
