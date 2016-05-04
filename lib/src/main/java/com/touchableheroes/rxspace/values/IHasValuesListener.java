package com.touchableheroes.rxspace.values;

import com.touchableheroes.rxspace.IHasScope;

/**
 * Created by asiebert on 13.04.16.
 */
public interface IHasValuesListener<T> extends IHasScope {

    public void exists(final Object... values);

}
