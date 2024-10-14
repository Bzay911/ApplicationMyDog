package com.example.applicationmydog.ui.main;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.bumptech.glide.Glide;
import com.example.applicationmydog.MyForegroundService;
import com.example.applicationmydog.R;
import com.example.applicationmydog.ReminderReceiver;
import com.example.applicationmydog.databinding.ReminderFragmentBinding;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

public class ReminderFragment extends Fragment {

    private ReminderFragmentBinding binding;
    private MaterialTimePicker picker;
    private Calendar calendar;
    private AlarmManager alarmManager;

    private PendingIntent pendingIntent;

    public static ReminderFragment newInstance() {

        return new ReminderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = ReminderFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String gifUrl = "https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExd2Q1ZjNjY2ZwbTJndXlyMmN0ajhrb2hzcTZoZXgyNjJreDgwdzVrayZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/piwLYTTDYHYQzFEySf/giphy.gif"; // Replace with your GIF URL
        Glide.with(this).asGif().load(gifUrl).into(binding.reminderImage);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String currentTime = dateFormat.format(calendar.getTime());

        binding.selectedTime.setText(currentTime);

        createNotificationChannel();

        binding.selectTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        binding.setReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setReminder();
            }
        });


        binding.cancelReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cancelReminder();

            }
        });
    }

    private void cancelReminder() {
        Intent intent = new Intent(requireContext(), ReminderReceiver.class);

        pendingIntent = PendingIntent.getBroadcast(requireContext(), 0, intent, 0 | PendingIntent.FLAG_UPDATE_CURRENT);

        if (alarmManager == null) {
            alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);
        }
        alarmManager.cancel(pendingIntent);
        Toast.makeText(getContext(), "Reminder Cancelled", Toast.LENGTH_SHORT).show();

    }

    private void setReminder() {

        if (calendar == null) {
            // Handle the case where the user hasn't selected a time
            Toast.makeText(requireContext(), "Please select a time for the reminder", Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            startForegroundService();

            // Set the alarm
            alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);

            Intent intent = new Intent(requireContext(), ReminderReceiver.class);

            pendingIntent = PendingIntent.getBroadcast(requireContext(), 0, intent, 0 | PendingIntent.FLAG_UPDATE_CURRENT);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

            Toast.makeText(requireContext(), "Reminder set successfully", Toast.LENGTH_SHORT).show();

            // Stop the foreground service after setting the alarm
            stopForegroundService();
        }
        catch (NullPointerException e) {
            e.printStackTrace();
            // Handle the exception gracefully
            Toast.makeText(requireContext(), "Error setting reminder", Toast.LENGTH_SHORT).show();
        }

    }

    private void startForegroundService() {
        Intent serviceIntent = new Intent(requireContext(), MyForegroundService.class);
        ContextCompat.startForegroundService(requireContext(), serviceIntent);
    }

    private void stopForegroundService() {
        Intent serviceIntent = new Intent(requireContext(), MyForegroundService.class);
        requireContext().stopService(serviceIntent);
    }


    private void showTimePicker() {
        picker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("Select Reminder Time")
                .build();

        picker.show(getActivity().getSupportFragmentManager(), "mydog");

        picker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (picker.getHour() > 12) {
                    binding.selectedTime.setText(
                            String.format("%02d", (picker.getHour() - 12)) + " : " + String.format("%02d", picker.getMinute()) + " PM"
                    );
                } else {
                    binding.selectedTime.setText(picker.getHour() + " : " + picker.getMinute() + " AM");
                }

                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, picker.getHour());
                calendar.set(Calendar.MINUTE, picker.getMinute());
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "MyDogReminderChannel";
            String description = "Channel For Reminder Manager";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("mydog", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);

        }
    }
}