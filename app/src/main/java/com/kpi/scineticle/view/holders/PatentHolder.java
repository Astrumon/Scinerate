package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemPatentWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocuments;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class PatentHolder extends BaseViewHolder<Patent> {
    private ScientificWorkAdapter.OnItemClickListener<Patent> mListener;
    private Patent mPatent;
    public ItemPatentWorkBinding mItemPatentWorkBinding;


    public PatentHolder(@NonNull View itemView) {
        super(itemView);
        mItemPatentWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mPatent);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mPatent);
                }
            }
        });
    }


    @Override
    public void onBind(Patent patent) {
        mPatent = patent;
        mItemPatentWorkBinding.setPatentWork(patent);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<Patent> listener) {
        mListener = listener;
    }
}
