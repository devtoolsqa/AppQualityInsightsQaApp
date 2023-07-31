package com.example.appqualityinsightsqaapp;

import static com.example.mylibrary.AndroidLibraryClass.createCrashInAndroidLibrary;

import android.os.Bundle;

import com.example.lib.JavaLibraryClass;
import com.example.lib.TestClass;
import com.example.mylibrary.AndroidLibraryClass;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appqualityinsightsqaapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button andLibButton;
    Button javalibCrash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        javalibCrash=findViewById(R.id.java_lib_crash);
        andLibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCrashInAndroidLibrary();
            }
        });

        javalibCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestClass.Test();
            }
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
        String s=null;
        int length=s.length();
    }
}