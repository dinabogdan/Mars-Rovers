package com.freesoft.marsrovers.domain;

import java.util.Objects;

public final class Point {

    private final double x;
    private final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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
