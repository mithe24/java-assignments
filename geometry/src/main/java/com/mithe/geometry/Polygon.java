package com.mithe.geometry;

/**
 * The {@code Polygon} class represents a polygon, which is a closed shape formed by
 * connecting a series of {@link Point2D} vertices in a two-dimensional plane. The class
 * provides methods for various geometric operations and properties, such as calculating
 * the perimeter, finding the nearest vertex to the origin, determining the longest side,
 * moving the polygon, and checking if the polygon is a triangle or rectangle.
 *
 * <p>Key functionality includes:
 * <ul>
 *   <li>Calculating the perimeter of the polygon</li>
 *   <li>Finding the vertex closest to the origin</li>
 *   <li>Determining the longest side of the polygon</li>
 *   <li>Moving the polygon by specified distances along the x and y axes</li>
 *   <li>Checking if the polygon is a triangle or rectangle</li>
 *   <li>Cloning the polygon</li>
 *   <li>Generating a string representation of the polygon</li>
 * </ul>
 */
public class Polygon{
    
    private static int numberOfInstances = 0;
    private Point2D[] polygon;
    private int id;

    /**
     * Constructs a new {@code Polygon} instance with the specified vertices.
     *
     * @param vertices the vertices of the polygon, given as {@link Point2D} instances
     */
    public Polygon(Point2D... vertices) {
        polygon = vertices;
        id = ++numberOfInstances;
    }

    /**
     * Retrieves the vertex at the specified index in the polygon.
     *
     * @param index The index of the vertex to retrieve. It must be within the valid range of the polygon's vertices.
     * @return The {@link Point2D} object representing the vertex at the specified index.
     * @throws AssertionError If the index is out of bounds of the polygon's vertices array.
     */
    public Point2D getVertex(int index) {
        assert index < polygon.length;
        return polygon[index];
    }

    /**
     * Sets the vertex at the specified index in the polygon to the provided {@link Point2D}.
     *
     * @param point The {@link Point2D} object to set at the specified index.
     * @param index The index at which the vertex should be set. It must be within the valid range of the polygon's vertices.
     * @throws AssertionError If the index is out of bounds of the polygon's vertices array.
     */
    public void setVertex(Point2D point, int index) {
        assert index < polygon.length;
        polygon[index] = point;
    }

    /**
     * Calculates the perimeter of the polygon by summing the distances between consecutive vertices.
     *
     * @return the perimeter of the polygon
     */
    public double parimeter() {
        double parimeter = 0;
        for (int i = 1; i < polygon.length; i++) {
            parimeter += polygon[i-1].distanceTo(polygon[i]);
        }

        return parimeter;
    }

    /**
     * Finds the vertex in the polygon that is closest to the origin (0, 0).
     *
     * @return the {@link Point2D} vertex that is nearest to the origin
     */
    public Point2D nearest() {
        double distance;
        double shortestDistance = polygon[0].distanceToOrigin();
        Point2D nearest = polygon[0];

        for (Point2D vertex : polygon) {
            distance = vertex.distanceToOrigin();
            if (distance < shortestDistance) { nearest = vertex; }
        }

        return nearest;
    }

    /**
     * Finds the length of the longest side of the polygon.
     *
     * @return the length of the longest side of the polygon
     */
    public double longestSide() {
        double side;
        double longestSide = polygon[0].distanceTo(polygon[1]);

        for (int i = 2; i < polygon.length; i++) {
            side = polygon[i-1].distanceTo(polygon[i]);
            if (side > longestSide) { longestSide = side; }
        }

        return longestSide;
    }

    /**
     * Moves the polygon by the specified {@code deltaX} and {@code deltaY} values,
     * which are added to the {@code x} and {@code y} coordinates of each vertex.
     *
     * @param deltaX the amount to move the polygon along the {@code x}-axis
     * @param deltaY the amount to move the polygon along the {@code y}-axis
     */
    public void move(double deltaX, double deltaY) {
        for (Point2D vertex : polygon) {
            vertex.move(deltaX, deltaY);
        }
    }

    /**
     * Determines whether the polygon is a triangle. A triangle has exactly three non-collinear vertices.
     *
     * @return {@code true} if the polygon is a triangle, {@code false} otherwise
     */
    public boolean isTriangle() {
        int corners = 0;
        for (int i = 0; i < polygon.length - 2; i++) {
            if (!isCollinear(polygon[i], polygon[i+1], polygon[i+2])) {
                corners++;
            }
        }

        return corners == 3;
    }

    /**
     * Determines whether the polygon is a rectangle. A rectangle has exactly four vertices,
     * and each corner should have a right angle.
     *
     * @return {@code true} if the polygon is a rectangle, {@code false} otherwise
     */
    public boolean isRectangle() {
        int corners = 0;
        for (int i = 0; i < polygon.length - 2; i++) {
            if (!isCollinear(polygon[i], polygon[i+1], polygon[i+2])) {
                corners++;
            }
        }

        return corners == 4;
    }

    /**
     * Gets the unique ID of this polygon.
     *
     * @return the unique ID of this polygon
     */
    public int getId() {
        return id;
    }

    public int size() {
        return polygon.length;
    }

    /**
     * Creates and returns a new {@code Polygon} instance that is a copy of this polygon,
     * with the same vertices.
     *
     * @return a new {@code Polygon} instance with the same vertices as this polygon
     */
    public Polygon clone() {
        return new Polygon(polygon.clone());
    }

    /**
     * Returns a string representation of the polygon, listing its vertices in the format
     * {@code {(x1, y1); (x2, y2); ... }}.
     *
     * @return a string representing the polygon's vertices
     */
    public String toString() {
        String res = "{";
        for (int i = 0; i < polygon.length; i++) {
            if (i == polygon.length - 1) { 
                res += polygon[i].toString();
            } else {
                res += polygon[i].toString() + "; ";
            }
        }
        res += "}";

        return res;
    }

    /**
     * Determines if three given points are collinear, i.e., if they lie on the same straight line.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @return {@code true} if the points are collinear, {@code false} otherwise
     */
    private static boolean isCollinear(Point2D p1, Point2D p2, Point2D p3) {
        return (p1.getX() * (p2.getY() - p3.getY()) 
            + p2.getX() * (p3.getY() - p1.getY()) 
            + p3.getX() * (p1.getY() - p2.getY()) == 0);
    }
}
