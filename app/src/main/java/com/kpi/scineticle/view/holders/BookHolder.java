package com.kpi.scineticle.view.holders;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemBookWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class BookHolder extends BaseViewHolder<Book>{
    private ScientificWorkAdapter.OnItemClickListener<Book> mListener;
    private Book mBook;
    public ItemBookWorkBinding mItemBookWorkBinding;


    public BookHolder(@NonNull View itemView) {
        super(itemView);
        mItemBookWorkBinding = DataBindingUtil.bind(itemView);
        Log.d("VIEW", "ArticleHolder: " + mItemBookWorkBinding.articleName.getText());
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mBook);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mBook);
                }
            }
        });
    }


    @Override
    public void onBind(Book book) {
        mBook = book;
        mItemBookWorkBinding.setBookWork(book);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Book> listener) {
        mListener = listener;
    }
}
