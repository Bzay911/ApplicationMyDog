package com.example.applicationmydog.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmydog.databinding.DogFragmentBinding;

import java.util.List;

public class DogFragment extends Fragment {

    private DogViewModel mViewModel;

    private DogFragmentBinding binding;

    public static DogFragment newInstance() {
        return new DogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DogFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DogViewModel.class);

        final Observer<List<Dog>> allDogsObserver = new Observer<List<Dog>>() {
            @Override
            public void onChanged(List<Dog> dogs) {

            }
        };

    }
}