package com.example.appqualityinsightsqaapp;

import static com.example.lib.JavaLibraryClass.createCrashInJavaLibrary;
import static com.example.mylibrary.AndroidLibraryClass.createCrashInAndroidLibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.appqualityinsightsqaapp.databinding.FragmentSecondBinding;
import com.google.firebase.crashlytics.CustomKeysAndValues;
import com.google.firebase.crashlytics.FirebaseCrashlytics;

import java.util.Locale;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String deviceLocale2 = Locale.getDefault().getDisplayLanguage();

        CustomKeysAndValues keysAndValues = new CustomKeysAndValues.Builder()
                .putString("fragment", "From_second_fragment")
                .putString("device_locale", deviceLocale2)
                .build();
        FirebaseCrashlytics.getInstance().setCustomKeys(keysAndValues);
        FirebaseCrashlytics.getInstance().log("User on second fragment");
        FirebaseCrashlytics.getInstance().log("User can create crash from different buttons");
        FirebaseCrashlytics.getInstance().log("Sending more logs to Firebase");
        FirebaseCrashlytics.getInstance().sendUnsentReports();


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        binding.andLibCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCrashInAndroidLibrary();
            }
        });
        binding.javaLibCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createCrashInJavaLibrary();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}