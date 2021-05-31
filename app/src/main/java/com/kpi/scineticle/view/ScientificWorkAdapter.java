package com.kpi.scineticle.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.kpi.scineticle.databinding.ItemArticleWorkBinding;
import com.kpi.scineticle.databinding.ItemBookWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.view.holders.ArticleHolder;
import com.kpi.scineticle.view.holders.BaseViewHolder;
import com.kpi.scineticle.view.holders.BookHolder;

import java.util.List;

public class ScientificWorkAdapter<T extends ScientWork> extends ListAdapter<ScientWork, BaseViewHolder<T>> {
    private OnItemClickListener mListener;
    private ScientWork work;
    private static final int ARTICLE = 1;
    private static final int BOOK = 2;


    public ScientificWorkAdapter() {
        super(new DiffUtil.ItemCallback<ScientWork>() {

            @Override
            public boolean areItemsTheSame(@NonNull ScientWork oldItem, @NonNull ScientWork newItem) {
                return oldItem.getId() == newItem.getId();
            }



            @Override
            public boolean areContentsTheSame(@NonNull ScientWork oldItem, @NonNull ScientWork newItem) {
                return oldItem.getTypeOfWork().equals(newItem.getTypeOfWork());
            }
        });
    }


    public ScientWork getScientWorkAt(int pos) {
        return getItem(pos);
    }

    @NonNull
    @Override
    public BaseViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getByType(parent, viewType);
    }

    private BaseViewHolder<T> getByType(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ARTICLE:
                ItemArticleWorkBinding bindingArticle = ItemArticleWorkBinding.inflate(inflater, parent, false);
                Log.d("VIEW", "getByType: " + bindingArticle.articleName.getText());
                viewHolder = new ArticleHolder(bindingArticle.getRoot());
                break;
            case BOOK:
                ItemBookWorkBinding bindingBook = ItemBookWorkBinding.inflate(inflater, parent, false);
                viewHolder = new BookHolder(bindingBook.getRoot());
                break;

        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        Log.d("HOL", "onBindViewHolder: " + getItemCount());

        holder.onBind(getItem(position));
        holder.setListener(mListener);
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof Article) {
            work = (Article) getItem(position);
            Log.d("VIEW", "test: " + position);
            return ARTICLE;
        }

        if (getItem(position) instanceof Book) {
            work = (Book) getItem(position);
            Log.d("VIEW", "test: " + position);
            return BOOK;
        }

        return -1;
    }



    public interface OnItemClickListener<T> {
        void onItemClick(T t);
        void onLongItemClick(T t);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
