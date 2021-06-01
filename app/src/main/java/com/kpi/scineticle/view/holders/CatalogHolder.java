package com.kpi.scineticle.view.holders;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemCatalogWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.Catalog;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class CatalogHolder extends BaseViewHolder<Catalog>{
    private ScientificWorkAdapter.OnItemClickListener<Catalog> mListener;
    private Catalog mCatalog;
    public ItemCatalogWorkBinding mItemCatalogWorkBinding;


    public CatalogHolder(@NonNull View itemView) {
        super(itemView);
        mItemCatalogWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mCatalog);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mCatalog);
                }
            }
        });
    }


    @Override
    public void onBind(Catalog catalog) {
        mCatalog = catalog;
        mItemCatalogWorkBinding.setCatalogWork(catalog);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Catalog> listener) {
        mListener = listener;
    }
}
