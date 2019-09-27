package com.freesoft.marsrovers.domain;

public final class Plateau {
    private final Point bottomLeft;
    private final Point upperRight;

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
