package com.example.applicationmydog.users;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.UserFragmentBinding;
import com.example.applicationmydog.ui.main.DogViewModel;

import java.util.List;

public class UserFragment extends Fragment {

    private UserViewModel mViewModel;
    public UserFragmentBinding binding;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UserFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        final Observer<List<User>> allUsersObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> userList) {

            }
        };
    }
}