package com.mithe;

/**
 * The {@code Date} class represents a specific date, extending the {@link TimeStamp} class to include time information
 * such as hours, minutes, and seconds.
 *
 * <p>
 * This class allows for the manipulation of date values, including the ability to skip days, months, and years,
 * as well as modifying specific date components like the year, month, and day.
 * It also supports validation of date values and conversion of the date to a string representation.
 * </p>
 */
public class Date 
    extends TimeStamp {

    private int year;
    private int month;
    private int day;

    /**
     * Constructs a {@code Date} object with the specified year, month, and day.
     * The provided values are validated to ensure the date is correct.
     *
     * @param year the year of the date (e.g., 2025)
     * @param month the month of the date (1-12)
     * @param day the day of the month (1-31, depending on the month and year)
     * @throws AssertionError if the date is invalid
     */
    public Date(int year, int month, int day) {
        super(0,0,0);
        assert valid(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Constructs a {@code Date} object with the specified year, month, day, hours, minutes, and seconds.
     * The provided values are validated to ensure the date is correct.
     * This constructor also calls the {@link TimeStamp} constructor to initialize time-related fields.
     *
     * @param year the year of the date
     * @param month the month of the date (1-12)
     * @param day the day of the month (1-31)
     * @param hours the hours (0-23)
     * @param minutes the minutes (0-59)
     * @param seconds the seconds (0-59)
     * @throws AssertionError if the date is invalid
     */
    public Date(int year, int month, int day, int hours, int minutes, int seconds) {
        super(hours, minutes, seconds);
        assert valid(year, month, day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Skips one day forward. This method accounts for the number of days in a month and handles month and year rollovers.
     */
    public void skipDay() {
        // Default number of days in a month
        int daysInMonth = getDaysInMonth(year, month);

        if (day == daysInMonth) {
            day = 1;
            skipMonth();
        } else {
            day++;
        }
    }

    /**
     * Increments the current month by one. If the month is December (12), it rolls over to January (1)
     * and increments the year by one by calling the `skipYear` method.
     * After updating the month, it ensures that the current day is still valid in the new month.
     * If the current day is greater than the number of days in the new month, it adjusts the day
     * to the last valid day of that month.
     */
    public void skipMonth() {
        if (month == 12) {
            month = 1;
            skipYear();
        } else {
            month++;
        }

        // Ensure the day is still valid
        int daysInMonth = getDaysInMonth(year, month);
        if (day > daysInMonth) { day = daysInMonth; };
    }

    /**
     * Skips one year forward.
     */
    public void skipYear() {
        year++;
    }

    /**
     * Skips one hour forward, and it advances the day if needed by calling {@code skipDay()}.
     */
    @Override
    public void skipHour() {
        super.skipHour();

        // If hours is 0, then a day has passed
        if (super.getHours() == 0) { skipDay(); };
    }

    /**
     * Adds the specified time (in hours, minutes, and seconds) to the current time.
     * The method normalizes the time by adjusting the seconds, minutes, and hours, 
     * and if a full day has passed (24 hours or more), it advances the date by one day.
     *
     * <p>
     * This method ensures that the time values (hours, minutes, and seconds) are 
     * kept within their valid ranges (0-59 for minutes and seconds, 0-23 for hours). 
     * If a full day has passed, the {@code skipDay()} method is called to advance 
     * the day by one.
     * </p>
     *
     * @param time the {@link TimeStamp} object representing the time to be added.
     *             This object contains the hours, minutes, and seconds to be added.
     */
    @Override
    public void skipTime(TimeStamp time) {
        int newHours, newMinutes, newSeconds;

        // Adds the time values
        newHours = super.getHours() + time.getHours();
        newMinutes = super.getMinutes() + time.getMinutes();
        newSeconds = super.getSeconds() + time.getSeconds();

        // Normalize time  values
        if (newSeconds >= 60) {
            newMinutes += newSeconds / 60;
            newSeconds = newSeconds % 60;
        }

        if (newSeconds >= 60) {
            newHours += newMinutes / 60;
            newMinutes = newMinutes % 60;
        }

        // if a full day has passed
        if (newHours >= 24) {
            newHours = newHours % 24;
            skipDay();
        }

        // Setting new time values
        super.setHours(newHours);
        super.setMinutes(newMinutes);
        super.setSeconds(newSeconds);
    }

    /**
     * Sets the year of this date.
     *
     * @param year the new year value
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Sets the month of this date.
     * The provided date will be validated to ensure the new date is correct.
     *
     * @param month the new month value (1-12)
     * @throws AssertionError if the month results in an invalid date
     */
    public void setMonth(int month) {
        assert valid(year, month, day);
        this.month = month;
    }

    /**
     * Sets the day of this date.
     * The provided date will be validated to ensure the new date is correct.
     *
     * @param day the new day value (1-31)
     * @throws AssertionError if the day results in an invalid date
     */
    public void setDay(int day) {
        assert valid(year, month, day);
        this.day = day;
    }

    /**
     * Returns the year of this date.
     *
     * @return the year value
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Returns the month of this date.
     *
     * @return the month value (1-12)
     */
    public int getMonth() {
        return month;
    }

    /**
     * Returns the day of this date.
     *
     * @return the day value (1-31)
     */
    public int getDay() {
        return day;
    }

    /**
     * Creates a new {@code Date} object that is a copy of the current one.
     *
     * @return a new {@code Date} object with the same year, month, and day
     */
    public Date clone() {
        return new Date(year, month, month);
    }

    /**
     * Returns a string representation of this {@code Date} object in the format: 
     * {@code "YYYY-MM-DD HH:MM:SS"}.
     *
     * @return a string representation of the date and time
     */
    public String toString() {
        String strMonth, strDay;

        if (day < 10) { strDay = "0" + day; }
        else { strDay = Integer.toString(day); }

        if (month < 10) { strMonth = "0" + month; }
        else { strMonth = Integer.toString(month); }

        return year + "-" + strMonth + "-" + strDay + " " + super.toString();
    }

    /**
     * Validates whether the given date (year, month, day) is a valid date.
     *
     * @param year the year value
     * @param month the month value (1-12)
     * @param day the day value (1-31)
     * @return {@code true} if the date is valid, {@code false} otherwise
     */
    public static boolean valid(int year, int month, int day) {
        assert day > 0; 
        assert month > 0 && month <= 12;

        int daysInMonth = getDaysInMonth(year, month);
        return day >= 1 && day <= daysInMonth;
    }

    /**
     * Returns the number of days in a given month of a specific year.
     * This method takes into account the different number of days in each month
     * and checks for leap years when calculating the days in February.
     * 
     * @param year The year for which the number of days in the month is being calculated.
     * @param month The month (1-12) for which the number of days is being determined.
     * @return The number of days in the given month of the given year.
     * @throws AssertionError If the month is not between 1 and 12 (inclusive).
     */
    private static int getDaysInMonth(int year, int month) {
        assert month >= 1 && month <= 12;

        int daysInMonth = 31;
        switch (month) {
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;

            case 2:
                // check if it's a leap year for February
                if (isLeapYear(year)) { daysInMonth = 29; } 
                else { daysInMonth = 28; }
                break;
        }

        return daysInMonth;
    }

    /**
     * Determines whether the specified year is a leap year.
     *
     * @param year the year to check
     * @return {@code true} if the year is a leap year, {@code false} otherwise
     */
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0)
            || year % 400 == 0);
    }


}
