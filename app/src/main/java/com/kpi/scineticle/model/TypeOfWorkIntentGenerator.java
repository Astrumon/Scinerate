package com.kpi.scineticle.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.kpi.scineticle.model.subsystemOfDataBase.ScientWork;
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
import com.kpi.scineticle.view.EditScientificWorkActivity;
import com.kpi.scineticle.view.fragments.ArticleFragment;
import com.kpi.scineticle.view.fragments.BibliographicPointerFragment;
import com.kpi.scineticle.view.fragments.BookFragment;
import com.kpi.scineticle.view.fragments.CatalogFragment;
import com.kpi.scineticle.view.fragments.DissertationFragment;
import com.kpi.scineticle.view.fragments.ElResourceFragment;
import com.kpi.scineticle.view.fragments.NormDocumentFragment;
import com.kpi.scineticle.view.fragments.PatentsFragment;
import com.kpi.scineticle.view.fragments.PreprintFragment;
import com.kpi.scineticle.view.fragments.StandartFragment;
import com.kpi.scineticle.view.fragments.ThesisFragment;

public class TypeOfWorkIntentGenerator {
    private Context mContext;
    private Intent mIntent;
    private Class toClass;

    public TypeOfWorkIntentGenerator(Context context, Class toClass) {
        mContext = context;
        this.toClass = toClass;
    }

    public Intent getIntent(Object o) {
        switch (Data.defineTypeOfData(o)) {
            case Data.ARTICLE:
                Article article = (Article) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(ArticleFragment.SCIENT_WORK, article);
                mIntent.putExtra("login", article.getUserLogin());
                mIntent.putExtra(ArticleFragment.ID, article.getId());
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, article.getTypeOfWork());
                Log.d("INTENT", "getIntent: " + article.getTypeOfWork());
                return mIntent;

            case Data.BOOK:
                Book book = (Book) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(BookFragment.ID, book.getId());
                mIntent.putExtra(BookFragment.SCIENT_WORK, book);
                mIntent.putExtra("login", book.getUserLogin());
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, book.getTypeOfWork());
                return mIntent;

            case Data.BIBLIOGRAPHIC_POINTER:
                BibliographicPointer bibliographicPointer = (BibliographicPointer) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(BibliographicPointerFragment.SCIENT_WORK, bibliographicPointer);
                mIntent.putExtra(BibliographicPointerFragment.ID, bibliographicPointer.getId());
                mIntent.putExtra("login", bibliographicPointer.getUserLogin());
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, bibliographicPointer.getTypeOfWork());
                return mIntent;

            case Data.CATALOG:
                Catalog catalog = (Catalog) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(CatalogFragment.SCIENT_WORK, catalog);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, catalog.getTypeOfWork());
                mIntent.putExtra(CatalogFragment.ID, catalog.getId());
                return mIntent;

            case Data.DISSERTATION:
                Dissertation dissertation = (Dissertation) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(DissertationFragment.SCIENT_WORK, dissertation);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, dissertation.getTypeOfWork());
                mIntent.putExtra(DissertationFragment.ID, dissertation.getId());
                return mIntent;

            case Data.ELECTRONIC_RESOURCE:
                ElectronicResource electronicResource = (ElectronicResource) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(ElResourceFragment.SCIENT_WORK, electronicResource);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, electronicResource.getTypeOfWork());
                mIntent.putExtra(ElResourceFragment.ID, electronicResource.getId());
                return mIntent;

            case Data.LEGIS_NORM_DOCUMENTS:
                LegisNormDocuments legisNormDocuments = (LegisNormDocuments) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(NormDocumentFragment.SCIENT_WORK, legisNormDocuments);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, legisNormDocuments.getTypeOfWork());
                mIntent.putExtra(NormDocumentFragment.ID, legisNormDocuments.getId());
                return mIntent;

            case Data.PATENT:
                Patent patent = (Patent) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(PatentsFragment.SCIENT_WORK, patent);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, patent.getTypeOfWork());
                mIntent.putExtra(PatentsFragment.ID, patent.getId());
                return mIntent;

            case Data.PREPRINT:
                Preprint preprint = (Preprint) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(PreprintFragment.SCIENT_WORK, preprint);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, preprint.getTypeOfWork());
                mIntent.putExtra(PreprintFragment.ID, preprint.getId());
                return mIntent;

            case Data.STANDART:
                Standart standart = (Standart) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(StandartFragment.SCIENT_WORK, standart);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, standart.getTypeOfWork());
                mIntent.putExtra(StandartFragment.ID, standart.getId());
                return mIntent;

            case Data.THESIS:
                Thesis thesis = (Thesis) o;
                mIntent = new Intent(mContext, toClass);
                mIntent.putExtra(ThesisFragment.SCIENT_WORK, thesis);
                mIntent.putExtra(EditScientificWorkActivity.TYPE_OF_WORK, thesis.getTypeOfWork());
                mIntent.putExtra(ThesisFragment.ID, thesis.getId());
                return mIntent;
            default:
                Toast.makeText(mContext, "LONG_TEST", Toast.LENGTH_SHORT).show();
                break;
        }

        return null;
    }

}
