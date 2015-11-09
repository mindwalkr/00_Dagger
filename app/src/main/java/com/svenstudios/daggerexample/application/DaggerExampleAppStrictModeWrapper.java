package com.svenstudios.daggerexample.application;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.StrictMode;


public class DaggerExampleAppStrictModeWrapper {
    public static void init(Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 9 && context != null) {
            int appFlags = context.getApplicationInfo().flags;
            if ((appFlags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().build());
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().build());
            }
        }
    }
}
