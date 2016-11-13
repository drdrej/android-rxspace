package com.touchableheroes.rxspace;

import android.app.Application;

/**
 * Created by asiebert on 04.08.16.
 */
public class BasicApp
                extends Application
                implements IHasScope {

    private ContextScope root;


    @Override
    public void onCreate() {
        super.onCreate();

        createScope();
    }

    private void createScope() {
        this.root = new ContextScope(getApplicationContext());
    }

    @Override
    public Scope getScope() {
        return root;
    }

}
