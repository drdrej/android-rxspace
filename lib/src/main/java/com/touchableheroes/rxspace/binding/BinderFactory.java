package com.touchableheroes.rxspace.binding;

import android.support.v4.app.Fragment;

import com.touchableheroes.rxspace.Scope;

/**
 * Created by asiebert on 04.05.16.
 */
public class BinderFactory {

    private Scope scope;

    public BinderFactory(final Scope scope) {
        this.scope = scope;
    }

    public static BinderFactory bind(final Scope scope) {
        return new BinderFactory(scope);
    }

    public static ScopeBinder toUi(final Fragment fragment, final Class<? extends Enum> bindings) {
        return new UIScopeBinder(bindings, fragment, null);
    }


}
