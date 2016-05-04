package com.touchableheroes.rxspace.path;

import com.touchableheroes.rxspace.vars.VarPath;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asiebert on 08.12.15.
 */
public class PathResolverImpl1 implements PathResolver {

    private Map<String, VarPath> hooks = new HashMap<String, VarPath>();


    public boolean exists(final String path) {
        final VarPath found = hooks.get(path);
        if( found == null ) {
             return false;
        }

        return true;
    }

    // get
    @Override
    public int resolve(final String path) {
        final VarPath found = hooks.get(path);
        return found.getId();
    }

    // add
    public int register(final String path) {
        final VarPath found = hooks.get(path);
        if( found != null ) {
            throw new IllegalStateException( "{ path : " + path + "} can not register, because already exists." );
        }

        final VarPath newPath = new VarPath(path);
        hooks.put( path, newPath );

        // TODO: ID muss UNIQUE sein!
        // int varId = varPath.getId();

        return newPath.getId();
    }

    // remove
    public int unregister(final String path) {
        final VarPath found = hooks.get(path);
        if( found == null ) {
            throw new IllegalStateException( "{ path : " + path + "} can not unregister, because path not exists." );
        }

        return found.getId();
    }



}
