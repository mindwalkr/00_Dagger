package com.svenstudios.daggerexample.debug;

import com.svenstudios.daggerexample.injections.AppContainer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Richard on 9/12/2015.
 */

@Module
public class DebugModule {
    @Provides
    @Singleton
    AppContainer provideAppContainer(DebugAppContainer debugAppContainer) {
        return debugAppContainer;
    }

}
