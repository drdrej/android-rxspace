package com.touchableheroes.drafts.tools;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by asiebert on 11.04.16.
 */
public class CalendarTool {


    public static CalendarDiff diff( Calendar c1, Calendar c2 ) {
        long diff = c1.getTimeInMillis() - c2.getTimeInMillis();

        int secs = (int) (diff / 1000);
        int mins = secs / 60;
        secs = secs % 60;

        int milliseconds = (int) (diff % 1000);

        int hours = 0;

        return new CalendarDiff( hours, mins, secs, milliseconds );
    }


    public static Calendar now() {
        // TODO: was, wenn ich Timezones überquere?
        final Calendar cal = Calendar.getInstance();

        final long now = System.currentTimeMillis();
        cal.setTimeInMillis(now);

        return cal;
    }

    public static String formatDate( final Calendar calendar ) {
        return DateFormat.format("dd-MM-yyyy", calendar).toString();
    }

    public static String formatTime( final Calendar calendar ) {
        return DateFormat.format("HH:mm", calendar).toString();
    }

    public static Date asDate(final Long val) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(val);

        return null;
    }
}
