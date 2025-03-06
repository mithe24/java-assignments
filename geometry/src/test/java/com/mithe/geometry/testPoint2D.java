package com.mithe.geometry;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class testPoint2D {

    @Test
    void testPoint2DConstructor() {
        Point2D point = new Point2D(2, 3);
        assertEquals(2, point.getX());
        assertEquals(3, point.getY());
    }

    @Test
    void testSetX() {
        Point2D point = new Point2D(12,234);
        point.setX(14);
        assertEquals(14, point.getX());
    }

    @Test
    void testSetY() {
        Point2D point = new Point2D(23,211);
        point.setY(42);
        assertEquals(42, point.getY());
    }

    @Test
    void testIsOrigin() {
        Point2D point1 = new Point2D(0,0);
        Point2D point2 = new Point2D(22, 23);
        assertTrue(point1.isOrigin());
        assertFalse(point2.isOrigin());
    }
}
