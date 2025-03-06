package com.mithe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class DateTest {

    @Test
    void testDefaultConstructor() {
        Date date = new Date(2042, 12, 6);
        assertEquals(2042, date.getYear());
        assertEquals(12, date.getMonth());
        assertEquals(6, date.getDay());
        assertEquals(0, date.getHours());
        assertEquals(0, date.getMinutes());
        assertEquals(0, date.getSeconds());
    }

    @Test
    void testConstructorWithTime() {
        Date date = new Date(2001, 9, 11, 9, 3, 2);
        assertEquals(2001, date.getYear());
        assertEquals(9, date.getMonth());
        assertEquals(11, date.getDay());
        assertEquals(9, date.getHours());
        assertEquals(3, date.getMinutes());
        assertEquals(2, date.getSeconds());
    }

    @Test
    void testSetYear() {
        Date date = new Date(1984, 1, 4);
        date.setYear(2003);
        assertEquals(2003, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(4, date.getDay());
    }

    @Test
    void testSetMonth() {
        Date date = new Date(2002, 3, 22);
        date.setMonth(5);
        assertEquals(2002, date.getYear());
        assertEquals(5, date.getMonth());
        assertEquals(22, date.getDay());
    }

    @Test
    void testSetDay() {
        Date date = new Date(1822, 11, 11);
        date.setDay(16);
        assertEquals(1822, date.getYear());
        assertEquals(11, date.getMonth());
        assertEquals(16, date.getDay());
    }

    @Test
    void testSkipYear() {
        Date date = new Date(2, 12, 30);
        date.skipYear();
        assertEquals(3, date.getYear());
        assertEquals(12, date.getMonth());
        assertEquals(30, date.getDay());
    }
 
    @Test
    void testSkipMonth() {
        Date date = new Date(1, 12, 30);
        date.skipMonth();
        assertEquals(2, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(30, date.getDay());
    }

    @Test
    void testSkipDay() {
        Date date = new Date(211, 12, 31);
        date.skipDay();
        assertEquals(212, date.getYear());
        assertEquals(1, date.getMonth());
        assertEquals(1, date.getDay());
    }
}
