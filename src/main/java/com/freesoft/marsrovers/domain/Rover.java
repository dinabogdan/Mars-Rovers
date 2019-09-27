package com.freesoft.marsrovers.domain;

import java.util.Collections;
import java.util.List;

public final class Rover {

    private final Point currentPosition;
    private final CardinalPoint currentOrientation;
    private final List<Command> toBeExecutedCommands;

    private Rover(Point currentPosition, CardinalPoint currentOrientation, List<Command> toBeExecutedCommands) {
        this.currentPosition = currentPosition;
        this.currentOrientation = currentOrientation;
        this.toBeExecutedCommands = toBeExecutedCommands;
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public CardinalPoint getCurrentOrientation() {
        return currentOrientation;
    }

    public List<Command> getToBeExecutedCommands() {
        return Collections.unmodifiableList(this.toBeExecutedCommands);
    }

    public Point executeCommands(Plateau plateau) {
        toBeExecutedCommands.stream()
                .forEach(command -> {
                });
        return null;
    }

    public static final class RoverBuilder {
        private Point currentPosition;
        private CardinalPoint currentOrientation;
        private List<Command> toBeExecutedCommands;

        private RoverBuilder() {
        }

        public static RoverBuilder aRover() {
            return new RoverBuilder();
        }

        public RoverBuilder withCurrentPosition(Point currentPosition) {
            this.currentPosition = currentPosition;
            return this;
        }

        public RoverBuilder withCurrentOrientation(CardinalPoint currentOrientation) {
            this.currentOrientation = currentOrientation;
            return this;
        }

        public RoverBuilder withToBeExecutedCommands(List<Command> toBeExecutedCommands) {
            this.toBeExecutedCommands = toBeExecutedCommands;
            return this;
        }

        public Rover build() {
            return new Rover(currentPosition, currentOrientation, toBeExecutedCommands);
        }
    }
}
