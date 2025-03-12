package com.example.appqualityinsightsqaapp;

import static com.example.lib.JavaLibraryClass.createCrashInJavaLibrary;
import static com.example.mylibrary.AndroidLibraryClass.createCrashInAndroidLibrary;
import static com.google.play.dynamic.filters.opted.shared.Platform_androidKt.createCrashInKMPModule;

import android.content.Intent;
import android.os.Bundle;

import com.example.appqualityinsightsqaapp.realcrash.RealCrashScenariosMainActivity;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appqualityinsightsqaapp.databinding.ActivityMainBinding;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button andLibButton;
    Button andLibButton2;
    Button javalibCrash;
    Button realLifeCrashScenario;
    Button kmpCrash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String deviceLocale = Locale.getDefault().getDisplayLanguage();
        String country = Locale.getDefault().getCountry();
        String deviceName = android.os.Build.MANUFACTURER + "-" + android.os.Build.MODEL+ "-" + android.os.Build.PRODUCT;

        CustomKeysAndValues keysAndValues = new CustomKeysAndValues.Builder()
                .putString("fragment", "Main Activity")
                .putString("device_name", deviceName)
                .putString("device_locale", deviceLocale)
                .putString("country", country)
                .build();
        FirebaseCrashlytics.getInstance().setCustomKeys(keysAndValues);
        FirebaseCrashlytics.getInstance().log("App launched in: " + country + " with device locale as: " + deviceLocale);
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               throw new RuntimeException("Test Crash vcs");

            }
        });
        andLibButton=findViewById(R.id.and_lib_crash);
        andLibButton2=findViewById(R.id.and_lib_crash2);
        javalibCrash=findViewById(R.id.java_lib_crash);
        kmpCrash=findViewById(R.id.kmp_crash);
        realLifeCrashScenario = findViewById(R.id.real_life_crash_scenario);

        andLibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCrashInAndroidLibrary();
            }
        });

        andLibButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCrashInAndroidLibrary();
            }
        });

        javalibCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCrashInAndroidLibrary();
            }
        });
        javalibCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCrashInJavaLibrary();
            }
        });
        realLifeCrashScenario.setOnClickListener(v -> {
            startActivity(new Intent(this, RealCrashScenariosMainActivity.class));
        });
        kmpCrash.setOnClickListener(v -> {
            createCrashInKMPModule();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        throw new RuntimeException("Test Crash new modified");
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void performClick(View view) {
        String s = null;
        int length = s.length();
    }
}