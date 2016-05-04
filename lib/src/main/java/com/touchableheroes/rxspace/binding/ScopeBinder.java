package com.touchableheroes.rxspace.binding;

import com.touchableheroes.rxspace.Scope;
import com.touchableheroes.rxspace.values.HasValuesListener;
import com.touchableheroes.rxspace.values.IChangeValueListener;

import java.util.ArrayList;

/**
 * Created by asiebert on 19.04.16.
 */
public class ScopeBinder implements Scope {

    private Scope src;
    private ArrayList<Integer> ids = new ArrayList<>(10);

    public ScopeBinder(final Scope src) {
        this.src = src;
    }

    @Override
    public void set(final String path,
                    final Object value) {
        src.set(path, value);
    }

    @Override
    public void init(final String path,
                     final Object defautValue) {
        src.init(path, defautValue);
    }

    @Override
    public boolean exists(String path) {
        return src.exists(path);
    }

    @Override
    public <T> T get(String path) {
        return (T) src.get(path);
    }

    public <T> void register(final String[] keys,
                             final HasValuesListener<T> handler) {
        src.register(keys, handler);
    }

    @Override
    public ScopeBinder create()  {
        return new ScopeBinder(this);
    }

    @Override
    public int register(final String path,
                        final IChangeValueListener listener) {
        final int newId = src.register(path, listener);
        this.ids.add(newId);

        return newId;
    }

    @Override
    public void notifyChange(final String path,
                             final Object value) {
        src.notifyChange(path, value);
    }

    @Override
    public void remove(final int id) {
        System.out.println( "--> Resolve Listener by ID: " + id  );
        src.remove(id);
    }

    public void release() {
        for (int id : ids) {
             remove(id);
        }

        this.src = null;
    }

    public Scope getScope() {
        return src;
    }
}
