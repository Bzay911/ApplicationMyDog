package com.example.applicationmydog.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.AddDogScrollingFragmentBinding;
import com.example.applicationmydog.ui.main.CommunityFragmentDirections;
import com.example.applicationmydog.ui.main.Dog;
import com.google.android.material.snackbar.Snackbar;

public class AddDogScrollingFragment extends Fragment {

    AddDogScrollingFragmentBinding binding;
    Dog dog;

    public static AddDogScrollingFragment newInstance(){
        return new AddDogScrollingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AddDogScrollingFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String postDescription = binding.postDescriptionEditText.getText().toString();
                if (postDescription.trim().isEmpty())
                {
                    Snackbar.make(view, "Description is required", Snackbar.LENGTH_SHORT).show();
                    binding.postDescriptionEditText.getText().clear();
                    binding.postDescriptionEditText.requestFocus();
                    return;
                }

                String postedBy = binding.postedByEditText.getText().toString();

                dog = new Dog();
                dog.setDescription(postDescription);
                dog.setPostedBy(postedBy);
                dog.setAge(0);
                dog.setWeight(0);


                //Pass the object to the community fragment which in turn will save the data in the db
                NavController navController = Navigation.findNavController(view);
                AddDogScrollingFragmentDirections.ActionAddDogScrollingFragmentToCommunityFragment action = AddDogScrollingFragmentDirections.actionAddDogScrollingFragmentToCommunityFragment(dog);
                navController.navigate(action);

            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(view);
                NavDirections navDirections = AddDogScrollingFragmentDirections.actionAddDogScrollingFragmentToCommunityFragment(null);
                navController.navigate(navDirections);
            }
        });
    }
}