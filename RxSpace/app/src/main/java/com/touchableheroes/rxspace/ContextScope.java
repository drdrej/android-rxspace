package com.touchableheroes.rxspace;

import android.content.Context;
import android.util.SparseArray;

import com.touchableheroes.rxspace.ids.IdFactory;
import com.touchableheroes.rxspace.vars.Var;

/**
 * Created by asiebert on 08.12.15.
 */
public class ContextScope implements Scope {

    private final Context ctx;

    private SparseArray<Var> values = new SparseArray<Var>(10);

    private final PathResolver pathResolver;




    // TODO: path validieren vor dem setzen

    private final ChangeValueListenerManager listeners = new ChangeValueListenerManager() {

        private SparseArray<Var> listenerIDs = new SparseArray<Var>();

        private IdFactory idFactory = IdFactory.create();

        @Override
        public int register(final String path,
                            final IChangeValueListener listener) {

            if (path == null) {
                throw new IllegalArgumentException("path is NULL");
            }

            if (listener == null) {
                throw new IllegalArgumentException("listener is NULL");
            }

            if (!exists(path)) {
                set(path, null);
            }

            final Var found = findByPath(path);
            final int id = idFactory.uniqueInt();

            found.addListener(id, listener);

            listenerIDs.put(id, found);

            return id;
        }


        @Override
        public void notifyChange(final String path,
                                 final Object value) {
            final Var found = findByPath(path);
            found.notifyChange();
        }

        @Override
        public void remove(final int id) {
            final Var var = listenerIDs.get(id);
            var.removeListener(id);

            listenerIDs.delete(id);
        }

    };


    public ContextScope(final Context ctx) {
        this.ctx = ctx;
        pathResolver = new PathResolverImpl1();
    }


    @Override
    public void set(final String path, final Object value) {
        _set(path, value);

        // TODO: check value compatibility
        // TODO: notify change listeners
        listeners.notifyChange(path, value);
    }

    private void _set(String path, Object value) {
        if (!pathResolver.exists(path)) {
            int key = pathResolver.register(path);
            values.put(key, new Var(value));

            return;
        }

        final Integer key = pathResolver.resolve(path);
        final Var saved = values.get(key);

        saved.set(value);
    }

    @Override
    public void init(final String path,
                     final Object value) {
        _set(path, value);
    }

    @Override
    public boolean exists(final String path) {
        return pathResolver.exists(path);
    }

    private Var findByPath(final String path) {
        final Integer key = pathResolver.resolve(path);
        return values.get(key);
    }

    @Override
    public <T> T get(final String path) {
        final Var found = findByPath(path);

        if (found != null) {
            return (T) found.get();
        }

        return null;
    }

    @Override
    public int register(final String path,
                        final IChangeValueListener listener) {
        return listeners.register(path, listener);
    }

    @Override
    public void notifyChange(final String path,
                             final Object value) {
        this.listeners.notifyChange(path, value);
    }

    @Override
    public void remove(int id) {
        listeners.remove(id);
    }

    // TODO: einfache impl eines tupels
    @Override
    public <T> void register(final String[] keys,
                             final HasValuesListener<T> handler) {
        if (keys.length < 1) {
            throw new IllegalArgumentException("couldn't handle keys, because keys.length < 1");
        }

        final ChangeValueListener<T> changeVals = new ChangeValueListener<T>(this) {

            @Override
            public void change(final T newValue) {
                final Object[] values
                        = new Object[keys.length];

                boolean isValid = true;

                for (int i = 0; i < keys.length; i++) {
                    values[i] = getScope().get(keys[i]);

                    isValid |= (values[i] == null);
                }

                if (isValid)
                    handler.exists(values);
            }
        };

        for (final String key : keys) {
            listeners.register(key, changeVals);
        }
    }

    @Override
    public ScopeBinder create() {
        return new ScopeBinder(this);
    }


}
