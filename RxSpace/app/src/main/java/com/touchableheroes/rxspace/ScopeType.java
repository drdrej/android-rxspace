package com.touchableheroes.rxspace;

import com.touchableheroes.drafts.tools.CalendarTool;

import java.util.Date;

/**
 * Created by asiebert on 13.04.16.
 */
public class ScopeType {

    public static Long asLong(final Object val) {
        if( val instanceof Long ) {
            return (Long) val;
        } else if( val instanceof String ) {
            return Long.parseLong( (String) val);
        }

        throw new UnsupportedOperationException();
    }

    public static Date asDate(final Object val) {
        if( val instanceof Long ) {
            return CalendarTool.asDate( (Long) val);
        } else if( val instanceof Date ) {
            return (Date) val;
        } else if( val == null ) {
            return null;
        }

        /*
        else if( val instanceof String ) {
            return Long.parseLong( (String) val);
        }
        */

        throw new UnsupportedOperationException( "Value: " + val );
    }

    public static <T> T as(final Object val,
                           final Class<T> type) {
        if(val == null ) return null;
        if( /* type.isAssignableFrom(val.getClass()) */
            val.getClass().isAssignableFrom(type)) {
            return (T) val;
        }

        throw new IllegalArgumentException();
    }

}
