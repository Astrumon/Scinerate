package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kpi.scineticle.R;
import com.kpi.scineticle.model.ReportGenerator;
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

public class ReportActivity extends AppCompatActivity {

    public static final String REPORT_ALL_DATA = "com.kpi.Scienticle.ALL_REPORTS";
    private TextView textView;
    private Bundle mBundle;
    private ReportGenerator mReportGenerator;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        mReportGenerator = new ReportGenerator();
        textView = findViewById(R.id.report_text);
        mBundle = getIntent().getExtras();
        registerForContextMenu(textView);

        if (mBundle.get(EditScientificWorkActivity.TYPE_OF_WORK) != null) {
            defineTypeAndShowReport(mBundle.get(EditScientificWorkActivity.TYPE_OF_WORK).toString());
        }

        if (getIntent().getStringExtra(REPORT_ALL_DATA) != null) {
            showAllReports();
        }
    }

    private void showAllReports() {
        textView.setText(getIntent().getStringExtra(REPORT_ALL_DATA));
    }

    private void defineTypeAndShowReport(String type) {

        switch (type) {
            case Article.ARTICLE:
                Article article = (Article) mBundle.get(ArticleFragment.SCIENT_WORK);
                setTextToTextView(article, Article.ARTICLE);
                break;
            case BibliographicPointer.BIBLIOGRAPHIC_POINTER:
                BibliographicPointer bibliographicPointer = (BibliographicPointer) mBundle.get(BibliographicPointerFragment.SCIENT_WORK);
                setTextToTextView(bibliographicPointer, BibliographicPointer.BIBLIOGRAPHIC_POINTER);
                break;
            case Book.BOOK:
                Book book = (Book) mBundle.get(BookFragment.SCIENT_WORK);
                setTextToTextView(book, Book.BOOK);
                break;
            case Catalog.CATALOG:
                Catalog catalog = (Catalog) mBundle.get(CatalogFragment.SCIENT_WORK);
                setTextToTextView(catalog, Catalog.CATALOG);
                break;
            case Dissertation.DISSERTATION:
                Dissertation dissertation = (Dissertation) mBundle.get(DissertationFragment.SCIENT_WORK);
                setTextToTextView(dissertation, Dissertation.DISSERTATION);
                break;
            case ElectronicResource.ELECTRONIC_RESOURCE:
                ElectronicResource electronicResource = (ElectronicResource) mBundle.get(ElResourceFragment.SCIENT_WORK);
                setTextToTextView(electronicResource, ElectronicResource.ELECTRONIC_RESOURCE);
                break;
            case LegisNormDocuments.LEGIS_NORM_DOCUMENTS:
                LegisNormDocuments legisNormDocuments = (LegisNormDocuments) mBundle.get(NormDocumentFragment.SCIENT_WORK);
                setTextToTextView(legisNormDocuments, LegisNormDocuments.LEGIS_NORM_DOCUMENTS);
                break;
            case Patent.PATENT:
                Patent patent = (Patent) mBundle.get(PatentsFragment.SCIENT_WORK);
                setTextToTextView(patent, Patent.PATENT);
                break;
            case Preprint.PREPRINT:
                Preprint preprint = (Preprint) mBundle.get(PreprintFragment.SCIENT_WORK);
                setTextToTextView(preprint, Preprint.PREPRINT);
                break;
            case Standart.STANDART:
                Standart standart = (Standart) mBundle.get(StandartFragment.SCIENT_WORK);
                setTextToTextView(standart, Standart.STANDART);
                break;
            case Thesis.THESIS:
                Thesis thesis = (Thesis) mBundle.get(ThesisFragment.SCIENT_WORK);
                setTextToTextView(thesis, Thesis.THESIS);
                break;
        }
    }

    public void setTextToTextView(Object object, String title) {
        setTitle("Звіт(" + title + "): ");
        mReportGenerator.setWork(object);
        textView.setText(mReportGenerator.getReport());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_close, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.close) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, v.getId(), 0, "Скопіювати");
        TextView textView = (TextView) v;
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        clipboardManager.setText(textView.getText());
        menu.add(1, v.getId(), 0, "Змінити");


    }
}