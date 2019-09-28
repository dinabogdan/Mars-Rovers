package com.freesoft.marsrovers.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Rover {

    private final int id;
    private final Point currentPosition;
    private final CardinalPoint currentOrientation;
    private final List<Command> toBeExecutedCommands;

    Function<Point, Boolean> isNotHittingAnotherRover = (futurePosition) -> {
        List<Rover> rovers = RoverMap.INSTANCE.getRovers()
                .values()
                .stream()
                .filter(r -> r.getId() != this.getId())
                .filter(r -> r.getCurrentPosition().equals(futurePosition))
                .collect(Collectors.toList());
        return rovers.isEmpty();
    };

    private Rover(int id,
                  Point currentPosition,
                  CardinalPoint currentOrientation,
                  List<Command> toBeExecutedCommands) {
        this.id = id;
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
        if (toBeExecutedCommands != null) {
            return Collections.unmodifiableList(this.toBeExecutedCommands);
        }
        return Collections.emptyList();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "id=" + id +
                ", currentPosition=" + currentPosition +
                ", currentOrientation=" + currentOrientation +
                ", toBeExecutedCommands=" + toBeExecutedCommands +
                '}';
    }

    public static final class RoverBuilder {
        private int id;
        private Point currentPosition;
        private CardinalPoint currentOrientation;
        private List<Command> toBeExecutedCommands;

        private RoverBuilder() {
        }

        public static RoverBuilder aRover() {
            return new RoverBuilder();
        }

        public RoverBuilder withId(int roverId) {
            this.id = roverId;
            return this;
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
            return new Rover(id, currentPosition, currentOrientation, toBeExecutedCommands);
        }
    }
}
