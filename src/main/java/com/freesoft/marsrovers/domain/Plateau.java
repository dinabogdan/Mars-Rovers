package com.freesoft.marsrovers.domain;

import java.util.function.Function;

public final class Plateau {
    private final Point bottomLeft;
    private final Point upperRight;

    Function<Point, Boolean> containsPoint = (futurePosition) -> {
        final String warnMessage = "WARN! The rover should move to: " + futurePosition.toString() + " which is out of the plateau: " + this.toString();
        if (!(futurePosition.getX() >= this.getBottomLeft().getX() && futurePosition.getX() <= this.getUpperRight().getX())) {
            System.out.println(warnMessage);
            return false;
        }
        if (!(futurePosition.getY() >= this.getBottomLeft().getY() && futurePosition.getY() <= this.getUpperRight().getY())) {
            System.out.println(warnMessage);
            return false;
        }
        return true;
    };

    private Plateau(Point bottomLeft, Point upperRight) {
        this.bottomLeft = bottomLeft;
        this.upperRight = upperRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getUpperRight() {
        return upperRight;
    }

    public static final class PlateauBuilder {
        private Point bottomLeft;
        private Point upperRight;

        private PlateauBuilder() {
        }

        public static PlateauBuilder aPlateau() {
            return new PlateauBuilder();
        }

        public PlateauBuilder withBottomLeft(Point bottomLeft) {
            this.bottomLeft = bottomLeft;
            return this;
        }

        public PlateauBuilder withUpperRight(Point upperRight) {
            this.upperRight = upperRight;
            return this;
        }

        public Plateau build() {
            return new Plateau(bottomLeft, upperRight);
        }
    }
}
