package com.touchableheroes.rxspace;

/**
 * Created by asiebert on 08.12.15.
 */
public interface ChangeValueListenerManager {

    public int register(final String path,
                        final IChangeValueListener listener);

    public void notifyChange(final String path, final Object value);


    public void remove(final int id);
}
