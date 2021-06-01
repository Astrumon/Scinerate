package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemElectronicResourceWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResource;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class ElectronicResourceHolder extends BaseViewHolder<ElectronicResource> {
    private ScientificWorkAdapter.OnItemClickListener<ElectronicResource> mListener;
    private ElectronicResource mElectronicResource;
    public ItemElectronicResourceWorkBinding mItemElectronicResourceWorkBinding;


    public ElectronicResourceHolder(@NonNull View itemView) {
        super(itemView);
        mItemElectronicResourceWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mElectronicResource);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mElectronicResource);
                }
            }
        });
    }


    @Override
    public void onBind(ElectronicResource electronicResource) {
        mElectronicResource = electronicResource;
        mItemElectronicResourceWorkBinding.setElectronicResourceWork(electronicResource);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<ElectronicResource> listener) {
        mListener = listener;
    }
}
