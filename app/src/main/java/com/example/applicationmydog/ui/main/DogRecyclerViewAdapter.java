package com.example.applicationmydog.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.applicationmydog.databinding.RecyclerItemViewBinding;

public class DogRecyclerViewAdapter extends ListAdapter<Dog, CommunityViewHolder> {

    private RecyclerItemViewBinding binding;

    private OnItemClickListener onItemClickListener;

    public DogRecyclerViewAdapter(OnItemClickListener onItemClickListener)
    {
        super(DIFF_CALLBACK);
        this.onItemClickListener = onItemClickListener;
    }

    private static final DiffUtil.ItemCallback<Dog> DIFF_CALLBACK = new DiffUtil.ItemCallback<Dog>() {
        @Override
        public boolean areItemsTheSame(@NonNull Dog oldItem, @NonNull Dog newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Dog oldItem, @NonNull Dog newItem) {
            return  oldItem.getAge() .equals( newItem.getAge() )&&
                    oldItem.getDescription() .equals(newItem.getDescription() ) &&
                    oldItem.getPostedBy() .equals(newItem.getPostedBy())  &&
                    oldItem.getGender() .equals(newItem.getGender())  &&
                    oldItem.getWeight().equals(newItem.getWeight()) &&
                    oldItem.getImage().equals(newItem.getImage()) &&
                    oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getType().equals(newItem.getType());
        }
    };
    protected DogRecyclerViewAdapter(@NonNull DiffUtil.ItemCallback<Dog> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public CommunityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        binding = RecyclerItemViewBinding.inflate(inflater, viewGroup, false);

        CommunityViewHolder communityViewHolder = new CommunityViewHolder(binding);
        return communityViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityViewHolder communityViewHolder, int position) {
        // Get data from the list based on the position
        Dog dog = getDogAt(position);
        communityViewHolder.updateDog(dog);
        communityViewHolder.bind(dog, onItemClickListener);
    }

    public Dog getDogAt(int position){
        return getItem(position);
    }
}
