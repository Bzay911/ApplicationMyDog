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
import com.example.applicationmydog.databinding.SecondFragmentBinding;

public class SecondFragment extends Fragment {

    private SecondFragmentBinding binding;

    public static SecondFragment newInstance() {

        return  new SecondFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = SecondFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

        binding.nextButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                NavDirections navDirections = SecondFragmentDirections.actionSecondFragmentToThirdFragment();
                navController.navigate(navDirections);
            }
        });

        binding.skipbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = SecondFragmentDirections.actionSecondFragmentToLogSignFragment();
                navController.navigate(navDirections);
            }
        });
    }
}