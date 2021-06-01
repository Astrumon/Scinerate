package com.kpi.scineticle.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemArticleWorkBinding;
import com.kpi.scineticle.databinding.ItemBibliographicPointerWorkBinding;
import com.kpi.scineticle.databinding.ItemBookWorkBinding;
import com.kpi.scineticle.model.Data;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.view.holders.ArticleHolder;
import com.kpi.scineticle.view.holders.BaseViewHolder;
import com.kpi.scineticle.view.holders.BibliographicHolder;
import com.kpi.scineticle.view.holders.BookHolder;

import java.util.ArrayList;
import java.util.List;


public class ScientificWorkAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private OnItemClickListener mListener;

    private List<Article> mListArticle = new ArrayList<>();
    private List<Book> mListBook = new ArrayList<>();
    private List<BibliographicPointer> mListBibliographicPointers = new ArrayList<>();
    private List<Data> mData;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getByType(parent, viewType);
    }

    private BaseViewHolder getByType(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case Data.ARTICLE:
                ItemArticleWorkBinding bindingArticle = ItemArticleWorkBinding.inflate(inflater, parent, false);
                viewHolder = new ArticleHolder(bindingArticle.getRoot());
                return viewHolder;
            case Data.BOOK:
                ItemBookWorkBinding bindingBook = ItemBookWorkBinding.inflate(inflater, parent, false);
                viewHolder = new BookHolder(bindingBook.getRoot());
                return viewHolder;
            case Data.BIBLIOGRAPHIC_POINTER:
                ItemBibliographicPointerWorkBinding bibliographicPointerWorkBinding = ItemBibliographicPointerWorkBinding.inflate(inflater, parent, false);
                viewHolder = new BibliographicHolder(bibliographicPointerWorkBinding.getRoot());
                return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case Data.ARTICLE:
               ArticleHolder articleHolder = (ArticleHolder)holder;
               articleHolder.onBind((Article)getScientWork(position).article);
               articleHolder.setListener(mListener);
               break;
            case Data.BOOK:
                BookHolder bookHolder = (BookHolder) holder;
                bookHolder.onBind((Book)getScientWork(position).book);
                bookHolder.setListener(mListener);
                break;
            case Data.BIBLIOGRAPHIC_POINTER:
                BibliographicHolder bibliographicHolder = (BibliographicHolder) holder;
                bibliographicHolder.onBind((BibliographicPointer)getScientWork(position).bibliographicPointer);
                bibliographicHolder.setListener(mListener);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (getScientWork(position).article instanceof Article) {
            return Data.ARTICLE;
        }

        if (getScientWork(position).book instanceof Book) {
            return Data.BOOK;
        }

        if (getScientWork(position).bibliographicPointer instanceof BibliographicPointer) {
            return Data.BIBLIOGRAPHIC_POINTER;
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        mData = Data.merge(mListArticle, mListBook, mListBibliographicPointers);
        return mData.size();
    }

    public void setArticles(List<Article> list) {
        mListArticle = list;

        notifyDataSetChanged();
    }


    public void setBooks(List<Book> list) {
        mListBook = list;
        notifyDataSetChanged();
    }

    public void setListBibliographicPointers(List<BibliographicPointer> list) {
        mListBibliographicPointers = list;
        notifyDataSetChanged();
    }

    public Data getScientWork(int position) {
        return mData.get(position);
    }

    public interface OnItemClickListener<T> {
        void onItemClick(T t);
        void onLongItemClick(T t);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
