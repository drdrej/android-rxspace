package com.touchableheroes.rxspace.vars;

/**
 * Created by asiebert on 08.12.15.
 */
public class VarPath {

    private final String path;
    private int id;

    public VarPath( final String path ) {
        this.path = path;
        this.id = System.identityHashCode( this );
    }


    public int getId() {
        return this.id;
    }
}
