package com.touchableheroes.drafts.tools;

/**
 * Created by asiebert on 11.04.16.
 */
public class CalendarDiff {
    private final int hours;
    private final int mins;
    private final int secs;
    private final int ms;

    public CalendarDiff(int hours, int mins, int secs, int milliseconds) {
        this.hours = hours;
        this.mins = mins;
        this.secs = secs;
        this.ms = milliseconds;
    }

    @Override
    public String toString() {
        return (mins + ":" + secs);
    }
}
