package com.kpi.scineticle.view;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemUserBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.user.User;

public class UserAdapter extends ListAdapter<User, UserAdapter.UserHolder> {
    private onItemClickListener mListener;

    public UserAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<User> DIFF_CALLBACK = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            return oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getPhoneNumber().equals(newItem.getPhoneNumber()) &&
                    oldItem.getEmail().equals(newItem.getEmail());
        }
    };

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserBinding binding = ItemUserBinding.inflate(inflater, parent, false);
        return new UserHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User currentUser = getItem(position);
        holder.mItemUserBinding.setUser(currentUser);
    }

    public User getUserAt(int pos) {
        return getItem(pos);
    }

    class UserHolder extends RecyclerView.ViewHolder {
        ItemUserBinding mItemUserBinding;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            mItemUserBinding = DataBindingUtil.bind(itemView);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    if (mListener != null && position != RecyclerView.NO_POSITION) {
                        mListener.onLongItemClick(getItem(position));
                    }
                    return false;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (mListener != null && position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface onItemClickListener {
        void onItemClick(User user);
        void onLongItemClick(User user);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }


}
