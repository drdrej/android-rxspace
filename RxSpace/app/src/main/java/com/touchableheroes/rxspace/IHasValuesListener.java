package com.touchableheroes.rxspace;

/**
 * Created by asiebert on 13.04.16.
 */
public interface IHasValuesListener<T> extends IHasScope {

    public void exists(final Object... values);

}
