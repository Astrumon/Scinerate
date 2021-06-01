package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemPreprintWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.Preprint;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class PreprintHolder extends BaseViewHolder<Preprint> {
    private ScientificWorkAdapter.OnItemClickListener<Preprint> mListener;
    private Preprint mPreprint;
    public ItemPreprintWorkBinding mItemPreprintWorkBinding;


    public PreprintHolder(@NonNull View itemView) {
        super(itemView);
        mItemPreprintWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mPreprint);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mPreprint);
                }
            }
        });
    }


    @Override
    public void onBind(Preprint preprint) {
        mPreprint = preprint;
        mItemPreprintWorkBinding.setPreprintWork(preprint);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Preprint> listener) {
        mListener = listener;
    }
}
