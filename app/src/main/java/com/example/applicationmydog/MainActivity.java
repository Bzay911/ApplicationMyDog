package com.example.applicationmydog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.applicationmydog.databinding.MainFragmentBinding;
import com.example.applicationmydog.ui.main.DogFragment;
import com.example.applicationmydog.ui.main.HomeFragment;
import com.example.applicationmydog.ui.main.ReminderFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.example.applicationmydog.ui.main.CommunityFragment;


public class MainActivity extends AppCompatActivity {

    private MainFragmentBinding binding;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up NavController
        navController = Navigation.findNavController(this, R.id.fragmentContainerView);

        // Connect BottomNavigationView to NavController
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            // Check the fragment IDs using if-else conditions
            int destinationId = destination.getId();
            if (destinationId == R.id.homeFragment ||
                    destinationId == R.id.communityFragment ||
                    destinationId == R.id.reminderFragment ||
                    destinationId == R.id.petstoreFragment ||
                    destinationId == R.id.profileFragment) {
                bottomNavigationView.setVisibility(View.VISIBLE);
            } else {
                bottomNavigationView.setVisibility(View.GONE);
            }
        });
    }


}