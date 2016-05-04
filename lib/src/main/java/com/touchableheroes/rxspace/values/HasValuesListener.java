package com.touchableheroes.rxspace.values;

import com.touchableheroes.rxspace.Scope;

/**
 * Created by asiebert on 13.04.16.
 */
public abstract class HasValuesListener<T> implements IHasValuesListener<T>{

    private final Scope scope;

    public HasValuesListener(final Scope scope) {
        this.scope = scope;
    }

    @Override
    public Scope getScope() {
        return scope;
    }
}




