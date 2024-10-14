package com.example.applicationmydog.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.ThirdFragmentBinding;


public class ThirdFragment extends Fragment {

    private ThirdFragmentBinding binding;

    public static ThirdFragment newInstance() {

        return new ThirdFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ThirdFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        binding.nextButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = ThirdFragmentDirections.actionThirdFragmentToLogSignFragment2();
                navController.navigate(navDirections);
            }
        });

        binding.skipbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = ThirdFragmentDirections.actionThirdFragmentToLogSignFragment2();
                navController.navigate(navDirections);
            }
        });
    }
}