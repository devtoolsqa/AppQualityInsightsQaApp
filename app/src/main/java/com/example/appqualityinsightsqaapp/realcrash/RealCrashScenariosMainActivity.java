package com.example.appqualityinsightsqaapp.realcrash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appqualityinsightsqaapp.R;

public class RealCrashScenariosMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_crash_scenarios_main);

        Button unRegisteredActivityButton = findViewById(R.id.unregistered_activity_button);
        Button noActionBarActivityButton = findViewById(R.id.no_action_bar_activity_button);
        Button wrongFormatConversionButton = findViewById(R.id.wrong_format_conversion_button);

        unRegisteredActivityButton.setOnClickListener(v -> startActivity(new Intent(this, UnRegisteredActivity.class)));
        noActionBarActivityButton.setOnClickListener(v -> startActivity(new Intent(this, CrashNoActionBarActivity.class)));
        wrongFormatConversionButton.setOnClickListener(v -> startActivity(new Intent(this, IllegalFormatActivity.class)));
    }
}