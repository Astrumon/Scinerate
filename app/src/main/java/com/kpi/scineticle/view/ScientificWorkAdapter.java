package com.kpi.scineticle.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemScientificWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;

public class ScientificWorkAdapter extends ListAdapter<Article, ScientificWorkAdapter.ScinetificWorkHolder> {
    private OnItemClickListener mListener;

    public ScientificWorkAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Article> DIFF_CALLBACK = new DiffUtil.ItemCallback<Article>() {
        @Override
        public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
            return oldItem.getNameArticle().equals(newItem.getNameArticle());
        }
    };

    public Article getScientWorkAt(int pos) {
        return getItem(pos);
    }

    @NonNull
    @Override
    public ScinetificWorkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemScientificWorkBinding binding = ItemScientificWorkBinding.inflate(inflater, parent, false);
        return new ScinetificWorkHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ScinetificWorkHolder holder, int position) {
        Article article = getItem(position);
        holder.mItemScientificWorkBinding.setScientWork(article);
    }


    class ScinetificWorkHolder extends RecyclerView.ViewHolder {
        ItemScientificWorkBinding mItemScientificWorkBinding;

        public ScinetificWorkHolder(@NonNull View itemView) {
            super(itemView);
            mItemScientificWorkBinding = DataBindingUtil.bind(itemView);
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

    public interface OnItemClickListener {
        void onItemClick(Article article);
        void onLongItemClick(Article article);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
