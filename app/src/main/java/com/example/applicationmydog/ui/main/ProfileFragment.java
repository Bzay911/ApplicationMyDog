package com.example.applicationmydog.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.ProfileFragmentBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProfileFragment extends Fragment {

    private ProfileFragmentBinding binding;

    public static ProfileFragment newInstance() {

        return new ProfileFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ProfileFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Loading image into profile picture
        Picasso.get().load("https://static.vecteezy.com/system/resources/previews/021/244/162/non_2x/cartoon-dog-pet-characters-illustration-png.png")
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.profileImage);

        binding.logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                NavDirections navDirections = ProfileFragmentDirections.actionProfileFragmentToLoginFragment();
                navController.navigate(navDirections);
            }
        });
    }




}
