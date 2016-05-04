package com.touchableheroes.rxspace.values;

import com.touchableheroes.rxspace.IHasScope;

/**
 * Created by asiebert on 08.12.15.
 */
public interface IChangeValueListener<T> extends IHasScope {

    public void change(final T newValue);

}
