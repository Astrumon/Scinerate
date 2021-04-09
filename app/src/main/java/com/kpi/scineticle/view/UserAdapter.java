package com.kpi.scineticle.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ItemUserBinding;
import com.kpi.scineticle.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<User> mUsers = new ArrayList<>();


    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserBinding binding = ItemUserBinding.inflate(inflater, parent, false   );
        return new UserHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        User currentUser = mUsers.get(position);
        holder.mItemUserBinding.setUser(currentUser);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setUsers(List<User> users) {
        mUsers = users;
        notifyDataSetChanged();
    }

    class UserHolder extends RecyclerView.ViewHolder {
       ItemUserBinding mItemUserBinding;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
           mItemUserBinding = DataBindingUtil.bind(itemView);
        }
    }


}
