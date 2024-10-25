package com.example.appqualityinsightsqaapp;

import static com.example.lib.JavaLibraryClass.createCrashInJavaLibrary;
import static com.example.mylibrary.AndroidLibraryClass.createCrashInAndroidLibrary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appqualityinsightsqaapp.databinding.ActivityMainBinding;
import com.example.appqualityinsightsqaapp.realcrash.RealCrashScenariosMainActivity;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button androidLibCrashButton;
    Button andLibButton2;
    Button javalibCrash;
    Button realLifeCrashScenario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String deviceLocale = Locale.getDefault().getDisplayLanguage();
        String country = Locale.getDefault().getCountry();
        String deviceName = android.os.Build.MANUFACTURER + "-" + android.os.Build.MODEL+ "-" + android.os.Build.PRODUCT;
// androidLibCrashButton
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
                Snackbar.make(view, "Replace with your own action: Checking commit", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                callCountryAPI();

//                throw new RuntimeException(getString(R.string.androidLibCrashButton));
            }
        });
        androidLibCrashButton = findViewById(R.id.androidLibCrashButton);
        andLibButton2=findViewById(R.id.and_lib_crash2);
        javalibCrash=findViewById(R.id.java_lib_crash);
        realLifeCrashScenario = findViewById(R.id.real_life_crash_scenario);


        androidLibCrashButton.setOnClickListener(new View.OnClickListener() {
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
    }

    private void callCountryAPI() {
// on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.petnav.com/")
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        // passing data from our text fields to our modal class.
        DataModal modal = new DataModal(0, "job");

        // calling a method to create a post and passing our modal class.
        Call<DataModal> call = retrofitAPI.createPost();

        // on below line we are executing our method.
        call.enqueue(new Callback<DataModal>() {
            @Override
            public void onResponse(Call<DataModal> call, Response<DataModal> response) {
                Log.d("TAG", response.toString());
                // this method is called when we get response from our api.
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                // we are getting response from our body
                // and passing it to our modal class.
                DataModal responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.
            }

            @Override
            public void onFailure(Call<DataModal> call, Throwable t) {
                Log.d("TAG", t.toString());
                // setting text to our text view when
                // we get error response from API.
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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