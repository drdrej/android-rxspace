package com.touchableheroes.rxspace.lang;

import com.touchableheroes.rxspace.binding.UIBinder;

/**
 * Created by asiebert on 04.05.16.
 */
public @interface UIBindind {

    int scopeId();

    int viewId();

    Class<? extends UIBinder> valueBinder();
}
