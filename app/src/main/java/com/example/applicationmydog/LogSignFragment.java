package com.example.applicationmydog;

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

import com.bumptech.glide.Glide;
import com.example.applicationmydog.databinding.LogSignFragmentBinding;


public class LogSignFragment extends Fragment {

    private LogSignFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = LogSignFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String gifUrl = "https://media0.giphy.com/media/v1.Y2lkPTc5MGI3NjExN2t0OTFoaHQ0ODVxYXhvZmhqaDYxZzgxMjZkeHJydWEwY3psZTlsbSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/bcKmIWkUMCjVm/giphy.gif";
        Glide.with(this).asGif().load(gifUrl).into(binding.logSignImageView);

        NavController navController = Navigation.findNavController(view);

        binding.logSignLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = LogSignFragmentDirections.actionLogSignFragmentToLoginFragment();
                navController.navigate(navDirections);
            }
        });


        binding.logSignSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = LogSignFragmentDirections.actionLogSignFragmentToSignupFragment();
                navController.navigate(navDirections);
            }
        });
    }
}