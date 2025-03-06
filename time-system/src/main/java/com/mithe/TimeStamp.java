package com.mithe;

/**
 * The {@code TimeStamp} class represents a time in hours, minutes, and seconds.
 * It provides various methods to set, get, and manipulate time values.
 * The time values are validated to ensure they are within the valid range for hours (0-23), minutes (0-59), and seconds (0-59).
 * 
 * <p>This class provides functionality to:
 * <ul>
 *   <li>Set and get hours, minutes, and seconds</li>
 *   <li>Skip time (increment seconds, minutes, or hours)</li>
 *   <li>Validate a given time</li>
 *   <li>Clone the TimeStamp</li>
 *   <li>Generate a string representation of the time</li>
 * </ul>
 */
public class TimeStamp 
    implements Time {

    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Default constructor that initializes the time to 00:00:00.
     */
    public TimeStamp() {
        this(0,0,0);
    }

    /**
     * Constructor that initializes the time with the specified hours, setting minutes and seconds to 00:00.
     * 
     * @param hours The hour value (0-23).
     * @throws AssertionError if hours is not between 0 and 23.
     */
    public TimeStamp(int hours) {
        assert hours < 24;

        this.hours = hours;
        minutes = 0;
        seconds = 0;
    }

    /**
     * Constructor that initializes the time with the specified hours and minutes, setting seconds to 00.
     * 
     * @param hours   The hour value (0-23).
     * @param minutes The minute value (0-59).
     * @throws AssertionError if hours is not between 0 and 23 or if minutes is not between 0 and 59.
     */
    public TimeStamp(int hours, int minutes) {
        assert hours < 24;
        assert minutes < 60;

        this.hours = hours;
        this.minutes = minutes;
        seconds = 0;
    }

    /**
     * Constructor that initializes the time with the specified hours, minutes, and seconds.
     * 
     * @param hours   The hour value (0-23).
     * @param minutes The minute value (0-59).
     * @param seconds The second value (0-59).
     * @throws AssertionError if hours is not between 0 and 23, minutes is not between 0 and 59, or seconds is not between 0 and 59.
     */
    public TimeStamp(int hours, int minutes, int seconds) {
        assert hours < 24;
        assert minutes < 60;
        assert seconds < 60;

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Sets the hours for the time.
     * 
     * @param hours The hour value (0-23).
     * @throws AssertionError if hours is not between 0 and 23.
     */
    public void setHours(int hours) {
        assert hours < 24;
        this.hours = hours;
    }

    /**
     * Sets the minutes for the time.
     * 
     * @param minutes The minute value (0-59).
     * @throws AssertionError if minutes is not between 0 and 59.
     */
    public void setMinutes(int minutes) {
        assert minutes < 60;
        this.minutes = minutes;
    }

    /**
     * Sets the seconds for the time.
     * 
     * @param seconds The second value (0-59).
     * @throws AssertionError if seconds is not between 0 and 59.
     */
    public void setSeconds(int seconds) {
        assert seconds < 60;
        this.seconds = seconds;
    }

    /**
     * Gets the hours of the time.
     * 
     * @return The hour value (0-23).
     */
    public int getHours() {
        return hours;
    }

    /**
     * Gets the minutes of the time.
     * 
     * @return The minute value (0-59).
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Gets the seconds of the time.
     * 
     * @return The second value (0-59).
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Validates whether the given time values are valid (hours between 0-23, minutes and seconds between 0-59).
     * 
     * @param hours   The hour value to validate.
     * @param minutes The minute value to validate.
     * @param seconds The second value to validate.
     * @return {@code true} if the time is valid, {@code false} otherwise.
     */
    public static boolean valid(int hours, int minutes, int seconds) {
        return (hours >= 0 && hours < 24 
            && minutes >= 0 && minutes < 60
            && seconds >= 0 && seconds < 60);
    }

    /**
     * Increments the hours by one. If hours reach 23, they are reset to 0.
     */
    public void skipHour() {
        if (hours == 23) {
            hours = 0;
        } else {
            hours++;
        }
    }

     /**
     * Increments the minutes by one. If minutes reach 59, they are reset to 0 and the hours are incremented.
     */
    public void skipMinute() {
        if (minutes == 59) {
            minutes = 0;
            skipHour();
        } else {
            minutes++;
        }
    }

    /**
     * Increments the seconds by one. If seconds reach 59, they are reset to 0 and the minutes are incremented.
     */
    public void skipSecond() {
        if (seconds == 59) {
            seconds = 0;
            skipMinute();
        } else {
            seconds++;
        }
    }

    /**
     * Adds the time of another {@code TimeStamp} to this one.
     * The time values are normalized (e.g., minutes above 60 will be added to hours).
     * 
     * @param time The {@code TimeStamp} to add.
     */
    public void skipTime(TimeStamp time) {
        // Adds the time values
        hours = hours + time.hours;
        minutes = minutes + time.minutes;
        seconds = seconds + time.seconds;

        // Normalize time values
        if (seconds >= 60) { minutes++; }
        if (minutes >= 60) { hours++; }

        minutes = minutes % 60;
        seconds = seconds % 60;
        hours = hours % 24;
    }

    /**
     * Creates a copy of this {@code TimeStamp}.
     * 
     * @return A new {@code TimeStamp} with the same hours, minutes, and seconds.
     */
    public TimeStamp clone() {
        return new TimeStamp(hours, minutes, seconds);
    }

    /**
     * Returns a string representation of this {@code TimeStamp} in the format "HH:MM:SS".
     * If any of the values are less than 10, they are padded with a leading zero.
     * 
     * @return A string representing the time in "HH:MM:SS" format.
     */
    public String toString() {
        String strHours, strMinutes, strSeconds;

        if (hours < 10) {
            strHours = "0"+hours;
        } else {
            strHours = Integer.toString(hours);
        }
        if (minutes < 10) {
            strMinutes = "0"+minutes;
        } else {
            strMinutes = Integer.toString(minutes);
        }
        if (seconds < 10) {
            strSeconds = "0"+seconds;
        } else {
            strSeconds = Integer.toString(seconds);
        }

        return strHours + ":" + strMinutes + ":" + strSeconds;
    }
}
