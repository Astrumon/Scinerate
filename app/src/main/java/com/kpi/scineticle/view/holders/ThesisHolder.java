package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemThesisWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.standarts.Standart;
import com.kpi.scineticle.model.subsystemOfDataBase.thesis.Thesis;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class ThesisHolder extends BaseViewHolder<Thesis> {
    private ScientificWorkAdapter.OnItemClickListener<Thesis> mListener;
    private Thesis mThesis;
    public ItemThesisWorkBinding mItemThesisWorkBinding;


    public ThesisHolder(@NonNull View itemView) {
        super(itemView);
        mItemThesisWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mThesis);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mThesis);
                }
            }
        });
    }


    @Override
    public void onBind(Thesis thesis) {
        mThesis = thesis;
        mItemThesisWorkBinding.setThesisWork(thesis);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Thesis> listener) {
        mListener = listener;
    }
}
