package com.example.applicationmydog.ui.main;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationmydog.R;
import com.example.applicationmydog.databinding.RecyclerItemViewBinding;
import com.squareup.picasso.Picasso;

public class CommunityViewHolder extends RecyclerView.ViewHolder {

    private RecyclerItemViewBinding binding;
    public CommunityViewHolder(@NonNull RecyclerItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void updateDog(Dog dog){
       this.binding.dogDescriptionTextView.setText(dog.getDescription());
       this.binding.postedByTextView.setText("by " + dog.getPostedBy());

        //Loading image into profile picture
        Picasso.get().load("https://i.pinimg.com/originals/e1/45/4d/e1454d53ec5fca711806ddabf1d6d37b.png")
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerInside()
                .error(R.drawable.placeholder)
                .into(binding.dogImageView);
    }

    public void bind(Dog dog, OnItemClickListener onItemClickListener){
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(dog, view);
            }
        });
    }
}
