package com.touchableheroes.rxspace.vars;

import android.util.SparseArray;
import com.touchableheroes.rxspace.values.IChangeValueListener;


/**
 * Created by asiebert on 08.12.15.
 */
public class Var {

    private Object val;

    private SparseArray<IChangeValueListener> byIds = new SparseArray<IChangeValueListener>();

    // private final ArrayList<IChangeValueListener> listeners = new ArrayList<IChangeValueListener>(5);

    public Var(final Object val) {
        this.val = val;
    }

    public int addListener( final int uniqueId, final IChangeValueListener listener ) {
        byIds.put(uniqueId, listener);

        // this.listeners.add(listener);

        return uniqueId;
    }


    public void set(Object val) {
        this.val = val;
    }

    public Object get() {
        return val;
    }

    public void removeListener( final int id) {
        byIds.delete(id);
    }

    /**
     * Wird nach der Änderung des Werts durch einen ListenerManager/Scope aufgerufen.
     */
    public void notifyChange() {
        /*
        for (final IChangeValueListener listener: byIds) {
             System.out.println( "NOTIFY CHANGE in VAL:" + listener);
             listener.change(val);
        }
        */

        for(int i = 0; i < byIds.size(); i++) {
            final int key = byIds.keyAt(i);
            final IChangeValueListener listener = (IChangeValueListener) byIds.get(key);

            System.out.println( "NOTIFY CHANGE in VAL:" + listener);
            listener.change(val);
        }
    }
}
