package com.mithe.geometry;

/**
 * The {@code Point2D} class represents a point in a 2D Cartesian coordinate system
 * with an {@code x} (horizontal) and {@code y} (vertical) value. It provides methods
 * for manipulating and querying the point, including operations such as calculating
 * distances, moving the point, and cloning it.
 *
 * <p>Key functionality includes:
 * <ul>
 *   <li>Setting and getting the {@code x} and {@code y} coordinates</li>
 *   <li>Calculating the distance to the origin (0, 0) or another point</li>
 *   <li>Moving the point by specified amounts along the {@code x} and {@code y} axes</li>
 *   <li>Creating a clone of the point</li>
 *   <li>Generating a string representation of the point</li>
 * </ul>
 */
public class Point2D {
    
    private double x;
    private double y;

    /**
     * Constructs a {@code Point2D} instance with the specified {@code x} and {@code y}
     * coordinates.
     *
     * @param x the horizontal coordinate of the point
     * @param y the vertical coordinate of the point
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Determines whether this point is the origin (0, 0).
     *
     * @return {@code true} if the point is the origin, {@code false} otherwise
     */
    public boolean isOrigin() {
        return x == 0 && y == 0;
    }

    /**
     * Moves the point by the specified {@code deltaX} and {@code deltaY}.
     * This method adds {@code deltaX} to the {@code x} coordinate and {@code deltaY}
     * to the {@code y} coordinate, effectively shifting the point's position.
     *
     * @param deltaX the amount to move the point along the {@code x}-axis
     * @param deltaY the amount to move the point along the {@code y}-axis
     */
    public void move(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }

    /**
     * Calculates the distance from this point to the origin (0, 0).
     *
     * @return the distance from this point to the origin
     */
    public double distanceToOrigin() {
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Calculates the distance from this point to another {@code Point2D}.
     *
     * @param point the point to which the distance is to be calculated
     * @return the distance from this point to the specified {@code point}
     */
    public double distanceTo(Point2D point) {
        double px = point.x;
        double py = point.y;
        return Math.sqrt((x-px)*(x-px) + (y-py)*(y-py));
    }

    /**
     * Sets the {@code x} coordinate of this point.
     *
     * @param x the new horizontal coordinate for the point
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the {@code y} coordinate of this point.
     *
     * @param y the new vertical coordinate for the point
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the {@code x} coordinate of this point.
     *
     * @return the horizontal coordinate of the point
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the {@code y} coordinate of this point.
     *
     * @return the vertical coordinate of the point
     */
    public double getY() {
        return y;
    }

    /**
     * Creates and returns a new {@code Point2D} instance that is a copy of this point.
     * The new point has the same {@code x} and {@code y} coordinates as the current one.
     *
     * @return a new {@code Point2D} instance with the same coordinates as this point
     */
    public Point2D clone() {
        return new Point2D(x, y);
    }

    /**
     * Returns a string representation of this point in the format {@code (x, y)}.
     *
     * @return a string representing the point, e.g., {@code (1.0, 2.0)}
     */
    public String toString() {
        return "(" + x  + ", " + y + ")";
    }
}
