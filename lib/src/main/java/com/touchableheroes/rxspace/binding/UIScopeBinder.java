package com.touchableheroes.rxspace.binding;

import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.tools.EnumTool;
import com.touchableheroes.rxspace.Scope;
import com.touchableheroes.rxspace.lang.UIBindind;
import com.touchableheroes.rxspace.lang.UIBindingInstance;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiebert on 04.05.16.
 */
public class UIScopeBinder extends ScopeBinder {

    private List<UIBindingInstance> binders = new ArrayList<>(10);

    public UIScopeBinder(final Class<? extends Enum> bindings,
                         final Fragment fragment,
                         final Scope src) {
        super(src);

        for (final Field field : bindings.getFields()) {
            final UIBindind bindind = field.getAnnotation(UIBindind.class);

            if(bindind == null) {
                continue;
            }

            final View view = fragment.getView().findViewById(bindind.viewId());
            if( view == null ) {
                continue;
            }

            binders.add(new UIBindingInstance(bindind, view));
        }
    }

    

    @Override
    public ScopeBinder create() {
        return super.create();
    }

    @Override
    public void notifyChange(final String path,
                             final Object value) {
        synchronized (this) {
            super.notifyChange(path, value);
        }

        updateUI();
    }

    public void updateUI() {
        for (final UIBindingInstance binder : binders) {
            binder.update(getScope());
        }
    }

    @Override
    public void release() {
        super.release();
        this.binders = null;
    }
}
