package com.touchableheroes.rxspace.lang;

import android.view.View;

import com.touchableheroes.rxspace.Scope;
import com.touchableheroes.rxspace.binding.UIBinder;

/**
 * Created by asiebert on 04.05.16.
 */
public class UIBindingInstance {
    private int scopeId;
    private int viewId;

    private UIBinder binder;
    private View view;

    public UIBindingInstance(final UIBindind definition,
                             final View view) {
        scopeId = definition.scopeId();
        viewId = definition.viewId();

        binder = initValueBinder(definition);
        this.view = view;
    }

    private UIBinder initValueBinder(final UIBindind definition) {
        try {
            return definition.valueBinder().newInstance();
        } catch (final Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public void update(final Scope scope) {
        binder.update(view, scope);
    }

    public void release() {
        scopeId = 0;
        viewId = 0;
        binder = null;
        view = null;
    }


    public View getView() {
        return view;
    }
}
