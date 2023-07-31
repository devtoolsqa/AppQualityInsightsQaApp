package com.example.lib;

public class JavaLibraryClass {
    public static void createCrashInJavaLibrary()  {
        createClassCastException();
        throw new NullPointerException("Java Library crash");
    }

    public static void createClassCastException()
    {
        throw new ClassCastException("ClassNotFoundException at java library");
    }
}
