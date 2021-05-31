package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public abstract class BaseViewHolder<T extends ScientWork> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void onBind(T t);

    public abstract void setListener(ScientificWorkAdapter.OnItemClickListener<T> listener);

}
