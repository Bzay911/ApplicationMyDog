package com.example.applicationmydog.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.SignupFragmentBinding;
import com.example.applicationmydog.databinding.ThirdFragmentBinding;
import com.example.applicationmydog.users.User;
import com.example.applicationmydog.users.UserViewModel;

public class SignupFragment extends Fragment {

    private SignupFragmentBinding binding;
    public static SignupFragment newInstance() {

        return new SignupFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = SignupFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);

       UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding.loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavDirections navDirections = SignupFragmentDirections.actionSignupFragmentToLoginFragment();
                navController.navigate(navDirections);
            }

        });

        binding.signupNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = binding.userNameEditText.getText().toString();
                String email = binding.signupEmailEditText.getText().toString();
                String password = binding.signupPasswordEditText.getText().toString();

                if (userName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(), "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (userName.isEmpty()) {
                    Toast.makeText(getActivity(), "Username cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(getActivity(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getActivity(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else {

                    User user = new User(userName, email, password);
                    userViewModel.insert(user);

                    Toast.makeText(requireContext(), "Sign up sucessfully", Toast.LENGTH_SHORT).show();

//                    LoginFragment loginFragment = new LoginFragment();
//                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                    transaction.replace(R.id.signupFragment, loginFragment);
//                    transaction.addToBackStack(null);
//                    transaction.commit();

                    NavDirections navDirections = SignupFragmentDirections.actionSignupFragmentToLoginFragment();
                    navController.navigate(navDirections);

                }
            }
        });
    }
}