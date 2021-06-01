package com.kpi.scineticle.view.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemBibliographicPointerWorkBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.view.ScientificWorkAdapter;

public class BibliographicHolder extends BaseViewHolder<BibliographicPointer>{
    private ScientificWorkAdapter.OnItemClickListener<BibliographicPointer> mListener;
    private BibliographicPointer mBibliographicPointer;
    public ItemBibliographicPointerWorkBinding mItemBibliographicPointerWorkBinding;


    public BibliographicHolder(@NonNull View itemView) {
        super(itemView);
        mItemBibliographicPointerWorkBinding = DataBindingUtil.bind(itemView);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onLongItemClick(mBibliographicPointer);
                }
                return false;
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (mListener != null && position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(mBibliographicPointer);
                }
            }
        });
    }


    @Override
    public void onBind(BibliographicPointer bibliographicPointer) {
        mBibliographicPointer = bibliographicPointer;
        mItemBibliographicPointerWorkBinding.setBibliographicPointerWork(bibliographicPointer);
    }

    @Override
    public void setListener(ScientificWorkAdapter.OnItemClickListener<BibliographicPointer> listener) {
        mListener = listener;
    }
}
