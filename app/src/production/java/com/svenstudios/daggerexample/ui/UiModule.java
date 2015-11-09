package com.svenstudios.daggerexample.ui;

import com.svenstudios.daggerexample.injections.AppContainer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public final class UiModule {

    @Provides
    @Singleton
    AppContainer provideAppContainer() {
        return AppContainer.DEFAULT;
    }

}
