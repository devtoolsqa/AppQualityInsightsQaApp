package com.example.appqualityinsightsqaapp.realcrash;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.appqualityinsightsqaapp.R;

public class IllegalFormatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illegal_format);

        String.format("Hello, %f!", 123);
    }
}