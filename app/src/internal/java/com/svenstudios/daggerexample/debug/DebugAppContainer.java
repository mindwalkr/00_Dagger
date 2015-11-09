package com.svenstudios.daggerexample.debug;


import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;


import com.svenstudios.daggerexample.R;
import com.svenstudios.daggerexample.injections.AppContainer;

import javax.inject.Inject;
import javax.inject.Singleton;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * An {@link AppContainer} for debug builds which wrap the content view with a sliding drawer on
 * the right that holds all of the debug information and settings.
 */
@Singleton
public final class DebugAppContainer implements AppContainer {

    @Inject
    public DebugAppContainer() {

    }

    /*
    DrawerLayout contains
     - debugDrawer
     - content screen (normal activity content)
     */
    static class ViewHolder {
        @Bind(R.id.debug_drawer_layout) DrawerLayout drawerLayout;
        @Bind(R.id.debug_drawer) ScrollView debugDrawer;
        @Bind(R.id.content_frame) FrameLayout content;
    }

    /*
    Sets the contentView for the activity, and returns the view that will contain
    content that the activity will see displayed (normal content)
     */
    @Override public ViewGroup bind(final Activity activity) {
        activity.setContentView(R.layout.debug_activity_frame);

        final ViewHolder viewHolder = new ViewHolder();
        ButterKnife.bind(viewHolder, activity);

        final Context drawerContext = new ContextThemeWrapper(activity, R.style.Base_Theme_AppCompat);
        final DebugView debugView = new DebugView(drawerContext);
        viewHolder.debugDrawer.addView(debugView);

        return viewHolder.content;
    }

}
