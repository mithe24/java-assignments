package com.mithe;

/**
 * Interface time
 */
public interface Time {

    /**
     * Skips time forward by one hour.
     */
    void skipHour();

    /**
     * Skips time forward by one minute.
     */
    void skipMinute();

    /**
     * Skips time forward by one second.
     */
    void skipSecond();

    /**
     * Skips time forward by a given time.
     */
    void skipTime(TimeStamp time);

    /**
     * Returns time in a string format.
     */
    String toString();
}
