package com.kpi.scineticle.view;


import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityMainBindingImpl;
import com.kpi.scineticle.databinding.ItemUserBinding;
import com.kpi.scineticle.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private List<User> mUsers = new ArrayList<>();
    private onItemClickListener mListener;

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserBinding binding = ItemUserBinding.inflate(inflater, parent, false);
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

    public User getUserAt(int pos) {
        return mUsers.get(pos);
    }

    class UserHolder extends RecyclerView.ViewHolder {
        ItemUserBinding mItemUserBinding;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            mItemUserBinding = DataBindingUtil.bind(itemView);

            final int[] i = {0};
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ++i[0];
                    if (i[0] == 1) {
                        i[0] = 0;
                        int position = getAdapterPosition();
                        if (mListener != null && position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(mUsers.get(position));
                        }

                    }
                }
            });
        }
    }

    public interface onItemClickListener {
        void onItemClick(User user);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }


}
