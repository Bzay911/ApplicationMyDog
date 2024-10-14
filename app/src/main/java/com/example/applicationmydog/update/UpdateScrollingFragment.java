package com.example.applicationmydog.update;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.UpdateScrollingFragmentBinding;
import com.example.applicationmydog.ui.main.CommunityViewHolder;
import com.example.applicationmydog.ui.main.CommunityViewModel;
import com.example.applicationmydog.ui.main.Dog;
import com.example.applicationmydog.ui.main.DogDAO;
import com.example.applicationmydog.ui.main.DogViewModel;
import com.google.android.material.snackbar.Snackbar;

public class UpdateScrollingFragment extends Fragment {

    private CommunityViewModel mViewModel;

   private Dog dog;

   private DogViewModel dogViewModel;
    private UpdateScrollingFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UpdateScrollingFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CommunityViewModel.class);



            binding.updateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String newDescription = binding.updatePostDescriptionEditText.getText().toString();
                    if (newDescription.trim().isEmpty())
                    {
                        Snackbar.make(view, "Description is required", Snackbar.LENGTH_SHORT).show();
                        binding.updatePostDescriptionEditText.getText().clear();
                        binding.updatePostDescriptionEditText.requestFocus();

                    };

                    String newName = binding.updatePostNameEditText.getText().toString();
                    if (newName.trim().isEmpty())
                    {
                        Snackbar.make(view, "Name is required", Snackbar.LENGTH_SHORT).show();
                        binding.updatePostNameEditText.getText().clear();
                        binding.updatePostNameEditText.requestFocus();

                    };

                    UpdateScrollingFragmentArgs args = UpdateScrollingFragmentArgs.fromBundle(getArguments());
                    int id = args.getId();

                    Dog updatedDog = mViewModel.findById(id);
                    updatedDog.setDescription(newDescription);
                    updatedDog.setPostedBy(newName);
                    mViewModel.update(updatedDog);

                    Toast.makeText(requireContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                    NavController navController =  Navigation.findNavController(view);
                    NavDirections navDirections = UpdateScrollingFragmentDirections.actionUpdateScrollingFragmentToCommunityFragment(null);
                    navController.navigate(navDirections);


                }

        });

            binding.updateCancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavController navController =  Navigation.findNavController(view);
                    NavDirections navDirections = UpdateScrollingFragmentDirections.actionUpdateScrollingFragmentToCommunityFragment(null);
                    navController.navigate(navDirections);
                }
            });



    }
    }
