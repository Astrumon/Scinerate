package com.kpi.scineticle.view.holders;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemArticleWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.view.ScientificWorkAdapter;


public class ArticleHolder extends BaseViewHolder<Article> {

    private ScientificWorkAdapter.OnItemClickListener<Article> mListener;
    private Article mScientWork;
    public ItemArticleWorkBinding mItemScientificWorkBinding;


    public void onBind(Article article) {
        mScientWork = article;
        mItemScientificWorkBinding.setArticleWork(article);
    }

    public ArticleHolder(@NonNull View itemView) {
        super(itemView);
        mItemScientificWorkBinding = DataBindingUtil.bind(itemView);
        Log.d("VIEW", "ArticleHolder: " + mItemScientificWorkBinding.articleName.getText());
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mScientWork);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mScientWork);
                }
            }
        });
    }


    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Article> listener) {
        mListener = listener;
    }
}
