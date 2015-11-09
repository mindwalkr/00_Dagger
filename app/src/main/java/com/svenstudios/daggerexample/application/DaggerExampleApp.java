package com.svenstudios.daggerexample.application;


import android.app.Application;
import android.support.annotation.NonNull;

import com.svenstudios.daggerexample.injections.Graph;


public class DaggerExampleApp extends Application {
    private final String LOG_TAG = DaggerExampleApp.class.getSimpleName();

    private static DaggerExampleApp instance;
    private Graph mGraph;


    @Override
    public void onCreate() {
        DaggerExampleAppStrictModeWrapper.init(getApplicationContext());
        super.onCreate();
        instance = this;


        mGraph = Graph.Initializer.init(this);
        getGraph().inject(this);


    }

    /**
     * @return Application instance
     */
    @NonNull
    public static DaggerExampleApp getInstance() {
        return instance;
    }


    @NonNull
    public Graph getGraph() {
        return mGraph;
    }
}
