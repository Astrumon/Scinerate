package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemLegicNormDocumentsWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.Dissertation;
import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocuments;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class LegisNormDocumentsHolder extends BaseViewHolder<LegisNormDocuments> {
    private ScientificWorkAdapter.OnItemClickListener<LegisNormDocuments> mListener;
    private LegisNormDocuments mLegisNormDocuments;
    public ItemLegicNormDocumentsWorkBinding mItemLegicNormDocumentsWorkBinding;


    public LegisNormDocumentsHolder(@NonNull View itemView) {
        super(itemView);
        mItemLegicNormDocumentsWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mLegisNormDocuments);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mLegisNormDocuments);
                }
            }
        });
    }


    @Override
    public void onBind(LegisNormDocuments legisNormDocuments) {
        mLegisNormDocuments = legisNormDocuments;
        mItemLegicNormDocumentsWorkBinding.setLegisNormDocumentsWork(legisNormDocuments);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<LegisNormDocuments> listener) {
        mListener = listener;
    }
}
