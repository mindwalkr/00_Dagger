package com.svenstudios.daggerexample.injections;


import android.app.Activity;
import android.view.ViewGroup;

import static butterknife.ButterKnife.findById;

/** An indirection which allows controlling the root container used for each activity. */
public interface AppContainer {
    /** The root {@link ViewGroup} into which the activity should place its contents. */
    ViewGroup bind(Activity activity);

    /** An {@link AppContainer} which returns the normal activity content view. */
    AppContainer DEFAULT = new AppContainer() {
        @Override public ViewGroup bind(Activity activity) {
            ViewGroup v = findById(activity, android.R.id.content);
            return v;
        }
    };
}