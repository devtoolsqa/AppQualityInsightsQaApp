package com.example.mylibrary;

import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import android.content.Context;

import java.util.Locale;


public class AndroidLibraryClass {
    public static Context context;
    public static void createCrashInAndroidLibrary()  {
        String deviceLocale2 = Locale.getDefault().getDisplayLanguage();

        CustomKeysAndValues keysAndValues = new CustomKeysAndValues.Builder()
                .putString("library", "android_library")
                .putString("device_locale", deviceLocale2)
                .build();
        FirebaseCrashlytics.getInstance().setCustomKeys(keysAndValues);
        FirebaseCrashlytics.getInstance().log("Latest Android Library crash");
        FirebaseCrashlytics.getInstance().log("This is a test log message to be recorded in crashlytics");
        FirebaseCrashlytics.getInstance().log("This is a second test log message to be recorded in crashlytics");
        FirebaseCrashlytics.getInstance().sendUnsentReports();

        //FirebaseCrashlytics crashlytics = FirebaseCrashlytics.getInstance();
        //crashlytics.log("Android Library crash");

        //crashlytics.setCustomKey("library", "android_library2");
        //crashlytics.setCustomKey("device_locale", deviceLocale2);


        throw new ExceptionInInitializerError ("Android Library crash");
    }
}
