package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemDissertationWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.Catalog;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.Dissertation;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class DissertationHolder extends BaseViewHolder<Dissertation> {
    private ScientificWorkAdapter.OnItemClickListener<Dissertation> mListener;
    private Dissertation mDissertation;
    public ItemDissertationWorkBinding mItemDissertationWorkBinding;


    public DissertationHolder(@NonNull View itemView) {
        super(itemView);
        mItemDissertationWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mDissertation);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mDissertation);
                }
            }
        });
    }


    @Override
    public void onBind(Dissertation dissertation) {
        mDissertation = dissertation;
        mItemDissertationWorkBinding.setDissertationWork(dissertation);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Dissertation> listener) {
        mListener = listener;
    }
}
