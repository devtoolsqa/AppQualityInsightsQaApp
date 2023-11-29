package com.example.mylibrary;

public class AndroidLibraryClass {

    public static void createCrashInAndroidLibrary()  {

        throw new ExceptionInInitializerError ("Android Library crash");
    }
}
