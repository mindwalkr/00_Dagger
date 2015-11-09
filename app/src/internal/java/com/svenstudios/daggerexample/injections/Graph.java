package com.svenstudios.daggerexample.injections;

import android.app.Application;

import com.svenstudios.daggerexample.application.DaggerExampleApp;
import com.svenstudios.daggerexample.debug.DebugModule;
import com.svenstudios.daggerexample.ui.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Richard on 9/13/2015.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,

                // debug
                DebugModule.class
        }
)
public interface Graph {

    // Fragments

    // Activities
    void inject(MainActivity activityMain);

    // Application
    void inject(DaggerExampleApp daggerExampleApp);

    final class Initializer {

        public static Graph init(Application application) {
            return DaggerGraph.builder()
                    .applicationModule(new ApplicationModule(application))
                    .build();
        }
    }


}
