package com.kpi.scineticle.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.databinding.ItemArticleWorkBinding;
import com.kpi.scineticle.databinding.ItemBibliographicPointerWorkBinding;
import com.kpi.scineticle.databinding.ItemBookWorkBinding;
import com.kpi.scineticle.databinding.ItemCatalogWorkBinding;
import com.kpi.scineticle.databinding.ItemDissertationWorkBinding;
import com.kpi.scineticle.databinding.ItemElectronicResourceWorkBinding;
import com.kpi.scineticle.databinding.ItemLegicNormDocumentsWorkBinding;
import com.kpi.scineticle.databinding.ItemPatentWorkBinding;
import com.kpi.scineticle.databinding.ItemPreprintWorkBinding;
import com.kpi.scineticle.databinding.ItemStandartWorkBinding;
import com.kpi.scineticle.databinding.ItemThesisWorkBinding;
import com.kpi.scineticle.model.Data;
import com.kpi.scineticle.model.subsystemOfDataBase.article.Article;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.model.subsystemOfDataBase.book.Book;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.Catalog;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.Dissertation;
import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResource;
import com.kpi.scineticle.model.subsystemOfDataBase.legislative_normative_documents.LegisNormDocuments;
import com.kpi.scineticle.model.subsystemOfDataBase.patents.Patent;
import com.kpi.scineticle.model.subsystemOfDataBase.preprints.Preprint;
import com.kpi.scineticle.model.subsystemOfDataBase.standarts.Standart;
import com.kpi.scineticle.model.subsystemOfDataBase.thesis.Thesis;
import com.kpi.scineticle.view.holders.ArticleHolder;
import com.kpi.scineticle.view.holders.BaseViewHolder;
import com.kpi.scineticle.view.holders.BibliographicHolder;
import com.kpi.scineticle.view.holders.BookHolder;
import com.kpi.scineticle.view.holders.CatalogHolder;
import com.kpi.scineticle.view.holders.DissertationHolder;
import com.kpi.scineticle.view.holders.ElectronicResourceHolder;
import com.kpi.scineticle.view.holders.LegisNormDocumentsHolder;
import com.kpi.scineticle.view.holders.PatentHolder;
import com.kpi.scineticle.view.holders.PreprintHolder;
import com.kpi.scineticle.view.holders.StandartHolder;
import com.kpi.scineticle.view.holders.ThesisHolder;

import java.util.ArrayList;
import java.util.List;


public class ScientificWorkAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private OnItemClickListener mListener;

    private List<Article> mListArticle = new ArrayList<>();
    private List<Book> mListBook = new ArrayList<>();
    private List<BibliographicPointer> mListBibliographicPointers = new ArrayList<>();
    private List<Catalog> mCatalogs = new ArrayList<>();
    private List<Dissertation> mDissertations = new ArrayList<>();
    private List<ElectronicResource> mElectronicResources = new ArrayList<>();
    private List<LegisNormDocuments> mLegisNormDocuments = new ArrayList<>();
    private List<Patent> mPatents = new ArrayList<>();
    private List<Preprint> mPreprints = new ArrayList<>();
    private List<Standart> mStandarts = new ArrayList<>();
    private List<Thesis> mTheses = new ArrayList<>();
    private List<Data> mData;

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getByType(parent, viewType);
    }

    private BaseViewHolder getByType(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case Data.ARTICLE:
                ItemArticleWorkBinding bindingArticle = ItemArticleWorkBinding.inflate(inflater, parent, false);
                viewHolder = new ArticleHolder(bindingArticle.getRoot());
                return viewHolder;
            case Data.BOOK:
                ItemBookWorkBinding bindingBook = ItemBookWorkBinding.inflate(inflater, parent, false);
                viewHolder = new BookHolder(bindingBook.getRoot());
                return viewHolder;
            case Data.BIBLIOGRAPHIC_POINTER:
                ItemBibliographicPointerWorkBinding bibliographicPointerWorkBinding = ItemBibliographicPointerWorkBinding.inflate(inflater, parent, false);
                viewHolder = new BibliographicHolder(bibliographicPointerWorkBinding.getRoot());
                return viewHolder;
            case Data.CATALOG:
                ItemCatalogWorkBinding catalogWorkBinding = ItemCatalogWorkBinding.inflate(inflater, parent, false);
                viewHolder = new CatalogHolder(catalogWorkBinding.getRoot());
                return viewHolder;
            case Data.DISSERTATION:
                ItemDissertationWorkBinding dissertationWorkBinding = ItemDissertationWorkBinding.inflate(inflater, parent, false);
                viewHolder = new DissertationHolder(dissertationWorkBinding.getRoot());
                return viewHolder;
            case Data.ELECTRONIC_RESOURCE:
                ItemElectronicResourceWorkBinding electronicResourceWorkBinding = ItemElectronicResourceWorkBinding.inflate(inflater, parent, false);
                viewHolder = new ElectronicResourceHolder(electronicResourceWorkBinding.getRoot());
                return viewHolder;
            case Data.LEGIS_NORM_DOCUMENTS:
                ItemLegicNormDocumentsWorkBinding legicNormDocumentsWorkBinding = ItemLegicNormDocumentsWorkBinding.inflate(inflater, parent, false);
                viewHolder = new LegisNormDocumentsHolder(legicNormDocumentsWorkBinding.getRoot());
                return viewHolder;
            case Data.PATENT:
                ItemPatentWorkBinding patentWorkBinding = ItemPatentWorkBinding.inflate(inflater, parent, false);
                viewHolder = new PatentHolder(patentWorkBinding.getRoot());
                return viewHolder;
            case Data.PREPRINT:
                ItemPreprintWorkBinding preprintWorkBinding = ItemPreprintWorkBinding.inflate(inflater, parent, false);
                viewHolder = new PreprintHolder(preprintWorkBinding.getRoot());
                return viewHolder;
            case Data.STANDART:
                ItemStandartWorkBinding standartWorkBinding = ItemStandartWorkBinding.inflate(inflater, parent, false);
                viewHolder = new StandartHolder(standartWorkBinding.getRoot());
                return viewHolder;
            case Data.THESIS:
                ItemThesisWorkBinding thesisWorkBinding = ItemThesisWorkBinding.inflate(inflater, parent, false);
                viewHolder = new ThesisHolder(thesisWorkBinding.getRoot());
                return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case Data.ARTICLE:
               ArticleHolder articleHolder = (ArticleHolder)holder;
               articleHolder.onBind(getScientWork(position).article);
               articleHolder.setListener(mListener);
               break;
            case Data.BOOK:
                BookHolder bookHolder = (BookHolder) holder;
                bookHolder.onBind(getScientWork(position).book);
                bookHolder.setListener(mListener);
                break;
            case Data.BIBLIOGRAPHIC_POINTER:
                BibliographicHolder bibliographicHolder = (BibliographicHolder) holder;
                bibliographicHolder.onBind(getScientWork(position).bibliographicPointer);
                bibliographicHolder.setListener(mListener);
                break;
            case Data.CATALOG:
                CatalogHolder catalogHolder = (CatalogHolder) holder;
                catalogHolder.onBind(getScientWork(position).catalog);
                catalogHolder.setListener(mListener);
                break;
            case Data.DISSERTATION:
                DissertationHolder dissertationHolder = (DissertationHolder) holder;
                dissertationHolder.onBind(getScientWork(position).dissertation);
                dissertationHolder.setListener(mListener);
                break;
            case Data.ELECTRONIC_RESOURCE:
                ElectronicResourceHolder electronicResourceHolder = (ElectronicResourceHolder) holder;
                electronicResourceHolder.onBind(getScientWork(position).electronicResource);
                electronicResourceHolder.setListener(mListener);
                break;
            case Data.LEGIS_NORM_DOCUMENTS:
                LegisNormDocumentsHolder legisNormDocumentsHolder = (LegisNormDocumentsHolder) holder;
                legisNormDocumentsHolder.onBind(getScientWork(position).legisNormDocuments);
                legisNormDocumentsHolder.setListener(mListener);
                break;
            case Data.PATENT:
                PatentHolder patentHolder = (PatentHolder) holder;
                patentHolder.onBind(getScientWork(position).patent);
                patentHolder.setListener(mListener);
                break;
            case Data.PREPRINT:
                PreprintHolder preprintHolder = (PreprintHolder) holder;
                preprintHolder.onBind(getScientWork(position).preprint);
                preprintHolder.setListener(mListener);
                break;
            case Data.STANDART:
                StandartHolder standartHolder = (StandartHolder) holder;
                standartHolder.onBind(getScientWork(position).standart);
                standartHolder.setListener(mListener);
                break;
            case Data.THESIS:
                ThesisHolder thesisHolder = (ThesisHolder) holder;
                thesisHolder.onBind(getScientWork(position).thesis);
                thesisHolder.setListener(mListener);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (getScientWork(position).article instanceof Article) {
            return Data.ARTICLE;
        }

        if (getScientWork(position).book instanceof Book) {
            return Data.BOOK;
        }

        if (getScientWork(position).bibliographicPointer instanceof BibliographicPointer) {
            return Data.BIBLIOGRAPHIC_POINTER;
        }

        if (getScientWork(position).catalog instanceof Catalog) {
            return Data.CATALOG;
        }

        if (getScientWork(position).dissertation instanceof Dissertation) {
            return Data.DISSERTATION;
        }

        if (getScientWork(position).electronicResource instanceof ElectronicResource) {
            return Data.ELECTRONIC_RESOURCE;
        }

        if (getScientWork(position).legisNormDocuments instanceof LegisNormDocuments) {
            return Data.LEGIS_NORM_DOCUMENTS;
        }

        if (getScientWork(position).patent instanceof Patent) {
            return Data.PATENT;
        }

        if (getScientWork(position).preprint instanceof Preprint) {
            return Data.PREPRINT;
        }

        if (getScientWork(position).standart instanceof Standart) {
            return Data.STANDART;
        }

        if (getScientWork(position).thesis instanceof Thesis) {
            return Data.THESIS;
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        mData = Data.merge(mListArticle,
                mListBook,
                mListBibliographicPointers,
                mDissertations,
                mCatalogs,
                mElectronicResources,
                mLegisNormDocuments,
                mPatents,
                mPreprints,
                mStandarts,
                mTheses);

        return mData.size();
    }

    public void setArticles(List<Article> list) {
        mListArticle = list;
        notifyDataSetChanged();
    }


    public void setBooks(List<Book> list) {
        mListBook = list;
        notifyDataSetChanged();
    }

    public void setCatalogs(List<Catalog> catalogs) {
        mCatalogs = catalogs;
        notifyDataSetChanged();
    }

    public void setDissertations(List<Dissertation> dissertations) {
        mDissertations = dissertations;
        notifyDataSetChanged();
    }

    public void setElectronicResources(List<ElectronicResource> electronicResources) {
        mElectronicResources = electronicResources;
        notifyDataSetChanged();
    }

    public void setLegisNormDocuments(List<LegisNormDocuments> legisNormDocuments) {
        mLegisNormDocuments = legisNormDocuments;
        notifyDataSetChanged();
    }

    public void setPatents(List<Patent> patents) {
        mPatents = patents;
        notifyDataSetChanged();
    }

    public void setPreprints(List<Preprint> preprints) {
        mPreprints = preprints;
        notifyDataSetChanged();
    }

    public void setStandarts(List<Standart> standarts) {
        mStandarts = standarts;
        notifyDataSetChanged();
    }

    public void setTheses(List<Thesis> theses) {
        mTheses = theses;
        notifyDataSetChanged();
    }

    public void setListBibliographicPointers(List<BibliographicPointer> list) {
        mListBibliographicPointers = list;
        notifyDataSetChanged();
    }

    public List<Data> getData() {
        return mData;
    }

    public Data getScientWork(int position) {
        return mData.get(position);
    }

    public interface OnItemClickListener<T> {
        void onItemClick(T t);
        void onLongItemClick(T t);

    }

    public void setOnItemClickListener(OnItemClickListener<Data> listener) {
        mListener = listener;
    }
}
