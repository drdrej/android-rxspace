package com.touchableheroes.rxspace.binding;

import com.touchableheroes.rxspace.IHasScope;
import com.touchableheroes.rxspace.Scope;

/**
 * Created by asiebert on 04.03.16.
 */
public class AbstractScopeBind implements IHasScope {

    public ScopeBinder scopeBinder;

    protected AbstractScopeBind(final Scope scope) {
        this.scopeBinder = scope.create();
    }

    public <T extends AbstractScopeBind> T bind() {
        return (T) this;
    }

    public <T extends AbstractScopeBind> T unbind() {
        return (T) this;
    }

    @Override
    public Scope getScope() {
        return this.scopeBinder.getScope();
    }

    public ScopeBinder getScopeBinder() {
        return this.scopeBinder;
    }

    public void release() {
        this.getScopeBinder().release();
    }
}
