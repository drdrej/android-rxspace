package com.touchableheroes.rxspace.example;

import com.touchableheroes.rxspace.binding.BasicUIBinder;
import com.touchableheroes.rxspace.binding.UIBinder;
import com.touchableheroes.rxspace.lang.UIBindind;

/**
 * Created by asiebert on 04.05.16.
 */
public enum FragmentBinding {

     @UIBindind(
             scopeId=1,
             viewId=1,
             valueBinder = BasicUIBinder.class
     )
     UI_ELEMENT_X

}
