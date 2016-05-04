package com.touchableheroes.rxspace.values;

import com.touchableheroes.rxspace.Scope;

/**
 * Created by asiebert on 26.02.16.
 */
public abstract class ChangeValueListener<T> implements IChangeValueListener<T> {

    private final Scope scope;

    public ChangeValueListener(final Scope scope) {
        this.scope = scope;
    }

    @Override
    public Scope getScope() {
        return scope;
    }
}
