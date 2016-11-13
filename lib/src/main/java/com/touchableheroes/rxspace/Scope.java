package com.touchableheroes.rxspace;

import com.touchableheroes.rxspace.binding.ScopeBinder;
import com.touchableheroes.rxspace.values.ChangeValueListenerManager;
import com.touchableheroes.rxspace.values.HasValuesListener;

/**
 * Created by asiebert on 08.12.15.
 */
public interface Scope
       extends ChangeValueListenerManager {

    public void set(final String path, final Object value);

    public void init(final String path, final Object defautValue);

    public boolean exists(final String path);

    public <T> T get(final String path);


    /**
     * Wird auf tupels ausgeführt
     *
     * @param keys
     * @param handler
     *
     * @return ListenerID
     */
    public <T> void register(final String[] keys,
                             final HasValuesListener<T> handler);


    public ScopeBinder create();

    /**
     * Erstellen eines Scopes aus einer Instanz.
     */
    public class Factory {

        public static Scope from(final Object src) {
            if (src instanceof IHasScope) {
                return ((IHasScope) src).getScope();
            } else if (src instanceof Scope) {
                return (Scope) src;
            } else {
                // TODO: return findByReflection(src);
                throw new UnsupportedOperationException( "by reflection is not implemented yet." );
            }
        }
    }


    public class Keys {
        public static String[] keys(final String... keys) {
            return keys;
        }
    }

    // hasParent()
    // getParent:Scope
    // public void commit()
    // public void save()
}
