package com.mithe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TimeStampTest {
        
    @Test
    void testDefaultConstructor() {
        TimeStamp time = new TimeStamp();
        assertEquals(0, time.getHours());
        assertEquals(0, time.getMinutes());
        assertEquals(0, time.getSeconds());
    }

    @Test
    void testConstructorWithHours() {
        TimeStamp time = new TimeStamp(14);
        assertEquals(14, time.getHours());
        assertEquals(0, time.getMinutes());
        assertEquals(0, time.getSeconds());
    }

    @Test
    void testConstructorWithHoursAndMinutes() {
        TimeStamp time = new TimeStamp(12, 43);
        assertEquals(12, time.getHours());
        assertEquals(43, time.getMinutes());
        assertEquals(0, time.getSeconds());
    }

    @Test
    void testConstructorWithAllValues() {
        TimeStamp time = new TimeStamp(22, 32, 43);
        assertEquals(22, time.getHours());
        assertEquals(32, time.getMinutes());
        assertEquals(43, time.getSeconds());
    }

    @Test
    void testSetHours() {
        TimeStamp time = new TimeStamp();
        time.setHours(4);
        assertEquals(4, time.getHours());
    }

    @Test
    void testSetMinutes() {
        TimeStamp time = new TimeStamp();
        time.setMinutes(52);
        assertEquals(52, time.getMinutes());
    }

    @Test
    void testSetSeconds() {
        TimeStamp time = new TimeStamp();
        time.setSeconds(41);
        assertEquals(41, time.getSeconds());
    }

    @Test
    void testValidTime() {
        assertTrue(TimeStamp.valid(10,30,40));
        assertFalse(TimeStamp.valid(25, 31, 22));
        assertFalse(TimeStamp.valid(21, 61, 31));
        assertFalse(TimeStamp.valid(13, 32, 61));
    }

    @Test
    void testSkipHours() {
        TimeStamp time = new TimeStamp(23, 30, 45);
        time.skipHour();
        assertEquals(0, time.getHours());
    }

    @Test
    void testSkipMinutes() {
        TimeStamp time = new TimeStamp(22, 59, 12);
        time.skipMinute();
        assertEquals(23, time.getHours());
        assertEquals(0, time.getMinutes());
    }

    @Test
    void testSkipSeconds() {
        TimeStamp time = new TimeStamp(14, 22, 59);
        time.skipSecond();
        assertEquals(23, time.getMinutes());
        assertEquals(0, time.getSeconds());
    }

    @Test
    void testTimeSkipTime() {
        TimeStamp time1 = new TimeStamp(10, 30, 45);
        TimeStamp time2 = new TimeStamp(5, 45, 30);
        // 75, 75, 15
        // 15, 15 ,15

        time1.skipTime(time2);

        // 45 + 30 = 75, 75 / 60 = 1 minute, 15 seconds
        assertEquals(15, time1.getSeconds());
        // 30 + 45 = 75, 75 / 60 = 1 hour, 15 minutes
        assertEquals(16, time1.getMinutes());
        // 10 + 5 = 15, 15 hours
        assertEquals(16, time1.getHours());
    }

    @Test
    void testClones() {
        TimeStamp time  = new TimeStamp(10, 30, 45);
        TimeStamp timeCloned = time.clone();
        
        assertNotSame(time, timeCloned);
        assertEquals(time.getHours(), timeCloned.getHours());
        assertEquals(time.getMinutes(), timeCloned.getMinutes());
        assertEquals(time.getSeconds(), timeCloned.getSeconds());
    }

    @Test
    void testToString() {
        TimeStamp time = new TimeStamp(9, 5, 3);
        assertEquals("09:05:03", time.toString());
    }

    @Test
    void testInalidHours() {
        TimeStamp time = new TimeStamp();
        assertThrows(AssertionError.class, 
            () -> { time.setHours(25); });
        assertThrows(AssertionError.class, 
            () -> { new TimeStamp(25); });
    }

    @Test
    void testInalidMinutes() {
        TimeStamp time = new TimeStamp();
        assertThrows(AssertionError.class, 
            () -> { time.setMinutes(60); });
        assertThrows(AssertionError.class, 
            () -> { new TimeStamp(10, 60); });
    }

    @Test
    void testInalidSeconds() {
        TimeStamp time = new TimeStamp();
        assertThrows(AssertionError.class, 
            () -> { time.setSeconds(60);});
        assertThrows(AssertionError.class, 
            () -> { new TimeStamp(12, 31, 60); });
    }
}
