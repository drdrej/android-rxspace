package com.touchableheroes.rxspace;

import com.touchableheroes.drafts.tools.AppTool;
import com.touchableheroes.rxspace.binding.ScopeBinder;

import junit.framework.Assert;

/**
 * Created by asiebert on 04.08.16.
 */
public class BasicAppTest extends ApplicationTest {

    public void testScopeAfterOnCreate() {
        BasicApp app = this.getApplication();

        Assert.assertNotNull(app.getScope());
        Assert.assertSame(app.getScope(), app.getScope());

        // ScopeBinder.Factory.from(null);

    }

}
