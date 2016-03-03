/*
 * AP CS MOOC
 * Term 2 - Assignment 1: Time
 * A class which represents the time of day in hours and seconds.
 */

public class Time {
    private int hour, minute;
     
     /* Complete required constructors and methods here */

    /*
     *Default constructor that sets time to 1200.
     */
    public Time() {
        hour = 12;
        minute = 00;
    }

    /*
     * If h is between 1 and 23 inclusive, set the hour to h.
     * Otherwise, set the hour to 0. If m is between 0 and 59 inclusive,
     * set the minutes to m. Otherwise, set the minutes to 0.
     */
    public Time(int h, int m) {
        if (h <= 23 && h >= 1) {
            hour = h;
        }
        else {
            hour = 00;
        }

        if (m <= 59 && m >= 0) {
            minute = m;
        }
        else {
            minute = 00;
        }
    }

    /* Returns the time as a String of length 4 in the format: 0819.
     * Notice that if the hour or minute is one digit, it should
     * print a zero first. For example, 6 should print as 06.
    */
    public String toString() {
        String time = "";
        if (hour < 10) {
            time = "0";
        }

        time = time + hour;

        if (minute < 10) {
            time = time + "0";
        }
        time = time + minute;
        return time;
    }

    /*
     * Returns the time as a String converted from military time
     * to standard time. For example, 0545 becomes 5:45 am and
     * 1306 becomes 1:06 pm.
     */
    public String convert() {
        String friendlyHour, friendlyMinute, pmOrAm;
        if (hour == 0) {
            // yeah...
            friendlyHour = "12";
            pmOrAm = "am";
        }
        else if (hour < 12) {
            // This is AM
            friendlyHour = Integer.toString(hour);
            pmOrAm = "am";
        }
        else if (hour == 12) {
            // yeah...
            friendlyHour = "12";
            pmOrAm = "pm";
        }
        else {
            friendlyHour = Integer.toString(hour-12);
            pmOrAm = "pm";
        }

        if (minute == 0) {
            friendlyMinute = "00";
        }
        else if (minute < 10) {
            friendlyMinute = "0" + Integer.toString(minute);
        }
        else {
            friendlyMinute = Integer.toString(minute);
        }

        return String.format("%s:%s %s", friendlyHour, friendlyMinute, pmOrAm);
    }

    /*
     * Advances the time by one minute. 
     * Remember that 60 minutes = 1 hour. 
     * Therefore, if your time was 0359, and you add one minute, 
     * it becomes 0400. 2359 should increment to 0000.
     */
    public void increment() {
        if((minute + 1) == 60) {
            minute = 00;
            incrementHour();
        }
        else {
            minute++;
        }
    }

    private void incrementHour() {
        if((hour + 1) == 24) {
            hour = 00;
        }
        else {
            hour++;
        }
    }

}