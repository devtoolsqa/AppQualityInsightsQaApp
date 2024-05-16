package com.example.appqualityinsightsqaapp.realcrash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appqualityinsightsqaapp.R;

public class CrashNoActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_no_action_bar);

        // getActionBar() will throw null pointer exception
        getActionBar().setTitle("This line should crash the app");
    }
}