package com.freesoft.marsrovers.domain;

public final class Point {

    private final double x;
    private final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static final class PointBuilder {
        private double x;
        private double y;

        private PointBuilder() {
        }

        public static PointBuilder aPoint() {
            return new PointBuilder();
        }

        public PointBuilder withX(double x) {
            this.x = x;
            return this;
        }

        public PointBuilder withY(double y) {
            this.y = y;
            return this;
        }

        public Point build() {
            return new Point(x, y);
        }
    }
}
