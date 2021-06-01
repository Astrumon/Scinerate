package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemStandartWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.Preprint;
import com.kpi.scineticle.model.subsystemOfDataBase.standarts.Standart;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class StandartHolder extends BaseViewHolder<Standart> {
    private ScientificWorkAdapter.OnItemClickListener<Standart> mListener;
    private Standart mStandart;
    public ItemStandartWorkBinding mItemStandartWorkBinding;


    public StandartHolder(@NonNull View itemView) {
        super(itemView);
        mItemStandartWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mStandart);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mStandart);
                }
            }
        });
    }


    @Override
    public void onBind(Standart standart) {
        mStandart = standart;
        mItemStandartWorkBinding.setStandartWork(standart);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Standart> listener) {
        mListener = listener;
    }
}
