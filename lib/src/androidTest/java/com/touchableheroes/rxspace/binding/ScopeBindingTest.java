package com.touchableheroes.rxspace.binding;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.touchableheroes.drafts.tools.AppTool;
import com.touchableheroes.rxspace.ApplicationTest;
import com.touchableheroes.rxspace.BasicApp;
import com.touchableheroes.rxspace.Scope;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by asiebert on 04.08.16.
 */
public class ScopeBindingTest extends
        ActivityInstrumentationTestCase2<ScopeBindingActivity> {

   public ScopeBindingTest() {
    super(ScopeBindingActivity.class);
   }

   public void testScopeAfterOnCreate() {
          ScopeBindingActivity app = getActivity();

          final Scope scope = ScopeBinder.Factory.from(app);

       ScopeBinder scopeBinder = AppTool.withActivity(getActivity()).getAppScope().create();
       Assert.assertNotNull(scopeBinder);

       // Activity activity = AppTool.withActivity(getActivity()).as(Activity.class);


       //       Assert.assertNotNull(app.getScope());
   //       Assert.assertSame(app.getScope(), app.getScope());
  }

            
}
