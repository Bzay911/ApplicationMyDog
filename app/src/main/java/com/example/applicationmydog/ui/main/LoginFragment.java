package com.example.applicationmydog.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.applicationmydog.R;
import com.example.applicationmydog.UserRepository;
import com.example.applicationmydog.databinding.LoginFragmentBinding;
import com.example.applicationmydog.users.User;
import com.example.applicationmydog.users.UserViewModel;


public class LoginFragment extends Fragment {

    private LoginFragmentBinding binding;

    private UserViewModel userViewModel;

    public static LoginFragment newInstance() {

        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        NavController navController = Navigation.findNavController(view);


        binding.signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToSignupFragment();
                navController.navigate(navDirections);
            }
        });

        binding.loginNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginEmailEditText.getText().toString();
                String password = binding.loginPasswordEditText.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (email.isEmpty()) {
                    Toast.makeText(getActivity(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (password.isEmpty()) {
                    Toast.makeText(getActivity(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }

                else {
                    userViewModel.login(email, password).observe(getViewLifecycleOwner(), new Observer<User>() {
                        @Override
                        public void onChanged(User user) {
                            if (user != null){
                                NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToHomeFragment();
                                navController.navigate(navDirections);
                            }
                            else {
                                Toast.makeText(getActivity(), "Invalid email or password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }) ;
                }


            }
        });
    }
}