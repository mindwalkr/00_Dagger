package com.svenstudios.daggerexample.injections;


import android.app.Application;

import com.svenstudios.daggerexample.application.DaggerExampleApp;
import com.svenstudios.daggerexample.ui.UiModule;
import com.svenstudios.daggerexample.ui.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                UiModule.class
        }
)
public interface Graph {

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
