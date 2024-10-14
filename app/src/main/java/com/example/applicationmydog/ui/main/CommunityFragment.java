package com.example.applicationmydog.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.CommunityFragmentBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CommunityFragment extends Fragment implements OnItemClickListener {

    private CommunityViewModel mViewModel;

    private CommunityFragmentBinding binding;

    public static CommunityFragment newInstance() {
        return new CommunityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CommunityFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CommunityViewModel.class);

        //Configure the Recycler View
        binding.communityRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.communityRecyclerView.setHasFixedSize(true);

        DogRecyclerViewAdapter adapter = new DogRecyclerViewAdapter(this);
        binding.communityRecyclerView.setAdapter(adapter);


        RecyclerSwipeHelper recyclerSwipeHelper = new RecyclerSwipeHelper(Color.RED,
                Color.RED,
                R.drawable.baseline_delete_forever_100,
                R.drawable.baseline_delete_forever_100,
                getContext()) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int adapterPosition = viewHolder.getAdapterPosition();
                Dog dog = mViewModel.getAllDogs().getValue().get(adapterPosition);
                mViewModel.delete(dog);

                Snackbar.make(binding.communityRecyclerView, dog.getDescription().concat(" deleted"), Snackbar.LENGTH_LONG)
                        .setAction("undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mViewModel.insert(dog);
                            }
                        }).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(recyclerSwipeHelper);
        itemTouchHelper.attachToRecyclerView(binding.communityRecyclerView);

        final Observer<List<Dog>> allDogsObserver = new Observer<List<Dog>>() {
            @Override
            public void onChanged(List<Dog> dogs) {
                //Set list of dogs to the adapter
                adapter.submitList(dogs);
            }
        };
        mViewModel.getAllDogs().observe(getViewLifecycleOwner(), allDogsObserver);

        binding.addDogFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                NavDirections navDirections = CommunityFragmentDirections.actionCommunityFragmentToAddDogScrollingFragment();
                navController.navigate(navDirections);
            }
        });

        if (getArguments() != null) {
            if (!getArguments().isEmpty()){
                CommunityFragmentArgs args = CommunityFragmentArgs.fromBundle(getArguments());
                Dog dog = args.getDog();
                if(dog != null){
                    mViewModel.insert(dog);
                }
                setArguments(null);
            }
        }


    }

    @Override
    public void onClick(Dog dog, View view) {
        Log.i("XYZ", dog.toString());

        int id = dog.getId();
        NavController navController = Navigation.findNavController(view);
        CommunityFragmentDirections.ActionCommunityFragmentToUpdateScrollingFragment action = CommunityFragmentDirections.actionCommunityFragmentToUpdateScrollingFragment(id);
        navController.navigate(action);
    }
}