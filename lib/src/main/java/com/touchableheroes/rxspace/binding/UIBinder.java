package com.touchableheroes.rxspace.binding;

import android.view.View;

import com.touchableheroes.rxspace.Scope;

/**
 * Created by asiebert on 04.05.16.
 */
public interface UIBinder {

    public void update(final View view, Scope scope);

}
