package com.touchableheroes.drafts.tools;

import android.app.Activity;
import android.app.Application;
import com.touchableheroes.rxspace.IHasScope;
import com.touchableheroes.rxspace.Scope;

/**
 * Created by asiebert on 05.03.16.
 */
public class AppTool {

    public static final AppWrapper withActivity( final Activity activity ) {
        return new AppWrapper(activity);
    }


    public static class AppWrapper  {

        private final Activity src;

        private Scope appScope;

        private AppWrapper(Activity src) {
            this.src = src;
        }

        public <R extends Application> R getApp(final Class<R> type) {
            return (R) src.getApplication();
        }

        public Scope getAppScope() {
            Application app = src.getApplication();

            if( app instanceof IHasScope) {
                return ((IHasScope) app).getScope();
            }

            throw new IllegalStateException( "Couldn't get scope. app-class should implement IHasScope.class interface" );
        }

        public <T extends Activity> T as(final Class<T> type) {
            if( type.isAssignableFrom(this.src.getClass()) ) {
                return (T) this.src;
            } else {
                throw new UnsupportedOperationException( " activity: " + this.src + " / passed type = " + type );
            }
        }

    }

}
