package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.model.ReportGenerator;
import com.kpi.scineticle.model.ReportTransfer;
import com.kpi.scineticle.model.TypeOfWorkIntentGenerator;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReportActivity extends AppCompatActivity {

    public static final String REPORT_ALL_DATA = "com.kpi.Scienticle.ALL_REPORTS";
    private TextView textView;
    private Bundle mBundle;
    private Context mContext;
    private ReportGenerator mReportGenerator;
    private boolean flag;
    private ScientWork mObject;
    private TypeOfWorkIntentGenerator typeOfWorkIntentGenerator;
    private String mType;
    public static int REQUEST_RESULT_REPORT = 0;
    private String login;
    private ReportTransfer reportTransfer;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_report);
        mReportGenerator = new ReportGenerator();
        textView = findViewById(R.id.report_text);
        mBundle = getIntent().getExtras();
        registerForContextMenu(textView);
        typeOfWorkIntentGenerator = new TypeOfWorkIntentGenerator(mContext, EditScientificWorkActivity.class);

        if (mBundle.get(EditScientificWorkActivity.TYPE_OF_WORK) != null) {
            flag = false;
            defineTypeAndShowReport(mBundle.get(EditScientificWorkActivity.TYPE_OF_WORK).toString());
        }

        if (getIntent().getStringExtra(REPORT_ALL_DATA) != null) {
            flag = true;
            login = getIntent().getStringExtra("login");
            reportTransfer = new ReportTransfer();
            reportTransfer.setMail(login);
            showAllReports();
        }


    }

    private void showAllReports() {
        textView.setText(getIntent().getStringExtra(REPORT_ALL_DATA));
    }

    private void defineTypeAndShowReport(String type) {
        mType = type;
        switch (type) {
            case Article.ARTICLE:
                Article article = (Article) mBundle.get(ArticleFragment.SCIENT_WORK);
                mObject = article;
                mObject.setTypeOfWork(Article.ARTICLE);
                setTextToTextView(article, Article.ARTICLE);
                break;
            case BibliographicPointer.BIBLIOGRAPHIC_POINTER:
                BibliographicPointer bibliographicPointer = (BibliographicPointer) mBundle.get(BibliographicPointerFragment.SCIENT_WORK);
                mObject = bibliographicPointer;
                mObject.setTypeOfWork(BibliographicPointer.BIBLIOGRAPHIC_POINTER);
                setTextToTextView(bibliographicPointer, BibliographicPointer.BIBLIOGRAPHIC_POINTER);
                break;
            case Book.BOOK:
                Book book = (Book) mBundle.get(BookFragment.SCIENT_WORK);
                mObject = book;
                mObject.setTypeOfWork(Book.BOOK);
                setTextToTextView(book, Book.BOOK);
                break;
            case Catalog.CATALOG:
                Catalog catalog = (Catalog) mBundle.get(CatalogFragment.SCIENT_WORK);
                mObject = catalog;
                mObject.setTypeOfWork(Catalog.CATALOG);
                setTextToTextView(catalog, Catalog.CATALOG);
                break;
            case Dissertation.DISSERTATION:
                Dissertation dissertation = (Dissertation) mBundle.get(DissertationFragment.SCIENT_WORK);
                mObject = dissertation;
                mObject.setTypeOfWork(Dissertation.DISSERTATION);
                setTextToTextView(dissertation, Dissertation.DISSERTATION);
                break;
            case ElectronicResource.ELECTRONIC_RESOURCE:
                ElectronicResource electronicResource = (ElectronicResource) mBundle.get(ElResourceFragment.SCIENT_WORK);
                mObject = electronicResource;
                mObject.setTypeOfWork(ElectronicResource.ELECTRONIC_RESOURCE);
                setTextToTextView(electronicResource, ElectronicResource.ELECTRONIC_RESOURCE);
                break;
            case LegisNormDocuments.LEGIS_NORM_DOCUMENTS:
                LegisNormDocuments legisNormDocuments = (LegisNormDocuments) mBundle.get(NormDocumentFragment.SCIENT_WORK);
                mObject = legisNormDocuments;
                mObject.setTypeOfWork(LegisNormDocuments.LEGIS_NORM_DOCUMENTS);
                setTextToTextView(legisNormDocuments, LegisNormDocuments.LEGIS_NORM_DOCUMENTS);
                break;
            case Patent.PATENT:
                Patent patent = (Patent) mBundle.get(PatentsFragment.SCIENT_WORK);
                mObject = patent;
                mObject.setTypeOfWork(Patent.PATENT);
                setTextToTextView(patent, Patent.PATENT);
                break;
            case Preprint.PREPRINT:
                Preprint preprint = (Preprint) mBundle.get(PreprintFragment.SCIENT_WORK);
                mObject = preprint;
                mObject.setTypeOfWork(Preprint.PREPRINT);
                setTextToTextView(preprint, Preprint.PREPRINT);
                break;
            case Standart.STANDART:
                Standart standart = (Standart) mBundle.get(StandartFragment.SCIENT_WORK);
                mObject = standart;
                mObject.setTypeOfWork(Standart.STANDART);
                setTextToTextView(standart, Standart.STANDART);
                break;
            case Thesis.THESIS:
                Thesis thesis = (Thesis) mBundle.get(ThesisFragment.SCIENT_WORK);
                mObject = thesis;
                mObject.setTypeOfWork(Thesis.THESIS);
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
        if (flag) {
            menu.add(0, 0, 0, "Скопіювати");
            textView = (TextView) v;
            menu.add(0, 2, 0, "Зберегти на пристрій");
            menu.add(0, 3, 0, "Відправити на пошту");
        } else {
            menu.add(0, 0, 0, "Скопіювати");
            menu.add(0, 1, 0, "Змінити");
        }



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 0:
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                clipboardManager.setText(textView.getText());
                return true;
            case 1:
                Toast.makeText(this, "Змінити", Toast.LENGTH_SHORT).show();
                Log.d("INTENT", "onContextItemSelected: " + mObject.getTypeOfWork());
                startActivityForResult(typeOfWorkIntentGenerator.getIntent(mObject), REQUEST_RESULT_REPORT);
                return true;
            case 2:
                Toast.makeText(this, "Зберегти на пристрій", Toast.LENGTH_SHORT).show();
                reportTransfer.setReport(getIntent().getStringExtra(REPORT_ALL_DATA));
                    if (AuthenticationActivity.permission && reportTransfer.writeToFile()) {
                        Toast.makeText(mContext, "Файл збережений /Download/data/scienticle/" + login + "_report.txt" , Toast.LENGTH_LONG).show();
                    } else if(!AuthenticationActivity.permission ){
                        Toast.makeText(mContext, "Потрібно надати доступ до збереження файлів" , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(mContext, "Виникла помилка при створенні файлу" , Toast.LENGTH_SHORT).show();
                    }
                return  true;
            case 3:
                Log.d("LOG", "onContextItemSelected: " + mBundle.getString("login"));
                reportTransfer.setReport(getIntent().getStringExtra(REPORT_ALL_DATA));
               if (reportTransfer.sendToEmail()) {
                   Toast.makeText(this, "Звіт відправлений на " + login, Toast.LENGTH_SHORT).show();
               }
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        ScientWork scientWork = (ScientWork) data.getExtras().get("WORK");
        setTextToTextView(scientWork, mType);
    }


}