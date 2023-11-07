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