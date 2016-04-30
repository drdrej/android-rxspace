package com.touchableheroes.rxspace;

/**
 * Created by asiebert on 08.12.15.
 */
public interface PathResolver {

    // exists
    public boolean exists(final String path);

    // get
    public int resolve(final String path);

    // add
    public int register(final String path);

    // remove
    public int unregister(final String path);

}
