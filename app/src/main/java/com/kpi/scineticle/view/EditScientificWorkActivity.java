package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ArticleFragmentBinding;
import com.kpi.scineticle.databinding.BibliographicPointerFragmentBinding;
import com.kpi.scineticle.databinding.BookFragmentBinding;
import com.kpi.scineticle.databinding.CatalogFragmentBinding;
import com.kpi.scineticle.databinding.DissertationFragmentBinding;
import com.kpi.scineticle.databinding.ElResourceFragmentBinding;
import com.kpi.scineticle.databinding.NormDocumentFragmentBinding;
import com.kpi.scineticle.databinding.PatentsFragmentBinding;
import com.kpi.scineticle.databinding.PreprintFragmentBinding;
import com.kpi.scineticle.databinding.StandartFragmentBinding;
import com.kpi.scineticle.databinding.ThesisFragmentBinding;
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
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.Alert;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ArticleViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BibliographicPointerViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.CatalogViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.DissertationViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ElResourceViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.NormDocumentViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.PatentsViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.PreprintViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ScientificWorkCRUDViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.StandartViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ThesisViewModel;

public class EditScientificWorkActivity extends AppCompatActivity {

    private Bundle mBundle;
    private Context mContext;
    private ScientificWorkCRUDViewModel scientificWorkCRUDViewModel;
    public static final String TYPE_OF_WORK = "com.kpi.Scienticle.TYPE_OF_WORK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_scientific_work);

        mContext = this;
        scientificWorkCRUDViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ScientificWorkCRUDViewModel.class);

        mBundle = getIntent().getExtras();
        defineFragmentType(mBundle.get(TYPE_OF_WORK).toString());
    }


    private void editArticle(ArticleFragmentBinding articleFragmentBinding) {
        articleFragmentBinding.btnCreateArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Article article = articleFragmentBinding.getArticleViewModel().getArticleData();
                article.setId(mBundle.getInt(ArticleFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(article)) {
                                    Toast.makeText(EditScientificWorkActivity.this, article.getTypeOfWork() + " успішно оновлена", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", article);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }

                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setArtilce();
                            }
                        }).create().show();
            }
        });
    }


    private void defineFragmentType(String typeOfWork) {
        switch (typeOfWork) {
            case ScientWork.ARTICLE:
                setTitle(ScientWork.ARTICLE);
                setArtilce();
                break;
            case ScientWork.BOOK:
                setTitle(ScientWork.BOOK);
                setBook();
                break;
            case ScientWork.BIBLIOGRAPHIC_POINTER:
                setTitle(ScientWork.BIBLIOGRAPHIC_POINTER);
                setBibliographicPointer();
                break;
            case ScientWork.CATALOG:
                setTitle(ScientWork.CATALOG);
                setCatalog();
                break;
            case ScientWork.DISSERTATION:
                setTitle(ScientWork.DISSERTATION);
                setDissertation();
                break;
            case ScientWork.ELECTRONIC_RESOURCE:
                setTitle(ScientWork.ELECTRONIC_RESOURCE);
                setElResource();
                break;
            case ScientWork.LEGIS_NORM_DOCUMENTS:
                setTitle(ScientWork.LEGIS_NORM_DOCUMENTS);
                setNormDocuments();
                break;
            case ScientWork.PATENT:
                setTitle(ScientWork.PATENT);
                setPatents();
                break;
            case ScientWork.PREPRINT:
                setPreprints();
                setTitle(ScientWork.PREPRINT);
                break;
            case ScientWork.STANDART:
                setStandart();
                setTitle(ScientWork.STANDART);
                break;
            case ScientWork.THESIS:
                setThesis();
                setTitle(ScientWork.THESIS);
                break;
        }
    }

    private void setArtilce() {
        ArticleFragmentBinding mArticleFragmentBinding = ArticleFragmentBinding.inflate(getLayoutInflater());

        Article article = (Article) mBundle.get(ArticleFragment.SCIENT_WORK);

        ArticleViewModel articleViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ArticleViewModel.class);
        mArticleFragmentBinding.setArticleViewModel(articleViewModel);

        mArticleFragmentBinding.getArticleViewModel().setUserLogin(article.getUserLogin());
        mArticleFragmentBinding.getArticleViewModel().setValues(article);

        setContentView(mArticleFragmentBinding.getRoot());
        editArticle(mArticleFragmentBinding);
    }

    private void setBook() {
        BookFragmentBinding bookFragmentBinding = BookFragmentBinding.inflate(getLayoutInflater());

        Book book = (Book) mBundle.get(BookFragment.SCIENT_WORK);

        BookViewModel bookViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(BookViewModel.class);
        bookFragmentBinding.setBookViewModel(bookViewModel);

        bookFragmentBinding.getBookViewModel().setUserLogin(book.getUserLogin());
        bookFragmentBinding.getBookViewModel().setValues(book);

        setContentView(bookFragmentBinding.getRoot());
        editBook(bookFragmentBinding);
    }

    private void editBook(BookFragmentBinding bookFragmentBinding) {
        bookFragmentBinding.btnBookCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = bookFragmentBinding.getBookViewModel().getBook();
                book.setId(mBundle.getInt(BookFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(book)) {
                                    Toast.makeText(EditScientificWorkActivity.this, book.getTypeOfWork() + " успішно оновлена", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", book);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setBook();
                            }
                        }).create().show();
            }
        });
    }

    private void setBibliographicPointer() {
        BibliographicPointerFragmentBinding bibliographicPointerFragmentBinding = BibliographicPointerFragmentBinding.inflate(getLayoutInflater());

        BibliographicPointer bibliographicPointer = (BibliographicPointer) mBundle.get(BibliographicPointerFragment.SCIENT_WORK);

        BibliographicPointerViewModel bibliographicPointerViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(BibliographicPointerViewModel.class);
        bibliographicPointerFragmentBinding.setBibliographiPointerViewModel(bibliographicPointerViewModel);

        bibliographicPointerFragmentBinding.getBibliographiPointerViewModel().setUserLogin(bibliographicPointer.getUserLogin());
        bibliographicPointerFragmentBinding.getBibliographiPointerViewModel().setValues(bibliographicPointer);

        setContentView(bibliographicPointerFragmentBinding.getRoot());
        editBibliographicPointer(bibliographicPointerFragmentBinding);
    }

    private void editBibliographicPointer(BibliographicPointerFragmentBinding bibliographicPointerFragmentBinding) {
        bibliographicPointerFragmentBinding.btnCreateBibliographicPointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BibliographicPointer bibliographicPointer = bibliographicPointerFragmentBinding.getBibliographiPointerViewModel().getBibliographicData();
                bibliographicPointer.setId(mBundle.getInt(BibliographicPointerFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(bibliographicPointer)) {
                                    Toast.makeText(EditScientificWorkActivity.this, bibliographicPointer.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", bibliographicPointer);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setBibliographicPointer();
                            }
                        }).create().show();
            }
        });
    }

    private void setCatalog() {
        CatalogFragmentBinding mCatalogFragmentBinding = CatalogFragmentBinding.inflate(getLayoutInflater());
        Catalog catalog = (Catalog) mBundle.get(CatalogFragment.SCIENT_WORK);
        CatalogViewModel catalogViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(CatalogViewModel.class);
        mCatalogFragmentBinding.setCatalogViewModel(catalogViewModel);
        mCatalogFragmentBinding.getCatalogViewModel().setUserLogin(catalog.getUserLogin());
        mCatalogFragmentBinding.getCatalogViewModel().setValues(catalog);
        setContentView(mCatalogFragmentBinding.getRoot());
        editCatalog(mCatalogFragmentBinding);
    }

    private void editCatalog(CatalogFragmentBinding catalogFragmentBinding) {
        catalogFragmentBinding.btnCatalogCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catalog catalog = catalogFragmentBinding.getCatalogViewModel().getCatalog();
                catalog.setId(mBundle.getInt(CatalogFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(catalog)) {
                                    Toast.makeText(EditScientificWorkActivity.this, catalog.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", catalog);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setCatalog();
                            }
                        }).create().show();
            }
        });
    }

    private void setDissertation() {
        DissertationFragmentBinding dissertationFragmentBinding = DissertationFragmentBinding.inflate(getLayoutInflater());
        Dissertation dissertation = (Dissertation) mBundle.get(DissertationFragment.SCIENT_WORK);
        DissertationViewModel dissertationFragment = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(DissertationViewModel.class);
        dissertationFragmentBinding.setDissertetionViewModel(dissertationFragment);
        dissertationFragmentBinding.getDissertetionViewModel().setUserLogin(dissertation.getUserLogin());
        dissertationFragmentBinding.getDissertetionViewModel().setValues(dissertation);
        setContentView(dissertationFragmentBinding.getRoot());
        editDissertation(dissertationFragmentBinding);
    }

    private void editDissertation(DissertationFragmentBinding dissertationFragmentBinding) {
        dissertationFragmentBinding.btnDissertationCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dissertation dissertation = dissertationFragmentBinding.getDissertetionViewModel().getDissertation();
                dissertation.setId(mBundle.getInt(DissertationFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(dissertation)) {
                                    Toast.makeText(EditScientificWorkActivity.this, "Дисертацію успішно оновлено", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", dissertation);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setDissertation();
                            }
                        }).create().show();
            }
        });
    }

    private void setElResource() {
        ElResourceFragmentBinding elResourceFragmentBinding = ElResourceFragmentBinding.inflate(getLayoutInflater());
        ElectronicResource electronicResource = (ElectronicResource) mBundle.get(ElResourceFragment.SCIENT_WORK);
        ElResourceViewModel elResourceViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ElResourceViewModel.class);
        elResourceFragmentBinding.setElResourceViewModel(elResourceViewModel);
        elResourceFragmentBinding.getElResourceViewModel().setUserLogin(electronicResource.getUserLogin());
        elResourceFragmentBinding.getElResourceViewModel().setValues(electronicResource);
        setContentView(elResourceFragmentBinding.getRoot());
        editElResource(elResourceFragmentBinding);
    }

    private void editElResource(ElResourceFragmentBinding elResourceFragmentBinding) {
        elResourceFragmentBinding.btnElResourceCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ElectronicResource electronicResource = elResourceFragmentBinding.getElResourceViewModel().getElectronicResource();
                electronicResource.setId(mBundle.getInt(ElResourceFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(electronicResource)) {
                                    Toast.makeText(EditScientificWorkActivity.this, electronicResource.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", electronicResource);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setElResource();
                            }
                        }).create().show();
            }
        });
    }

    private void setNormDocuments() {
        NormDocumentFragmentBinding normDocumentFragmentBinding = NormDocumentFragmentBinding.inflate(getLayoutInflater());
        LegisNormDocuments legisNormDocuments = (LegisNormDocuments) mBundle.get(NormDocumentFragment.SCIENT_WORK);
        NormDocumentViewModel normDocumentViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(NormDocumentViewModel.class);
        normDocumentFragmentBinding.setNormDocumentsViewModel(normDocumentViewModel);
        normDocumentFragmentBinding.getNormDocumentsViewModel().setUserLogin(legisNormDocuments.getUserLogin());
        normDocumentFragmentBinding.getNormDocumentsViewModel().setValues(legisNormDocuments);
        setContentView(normDocumentFragmentBinding.getRoot());
        editNormDocuments(normDocumentFragmentBinding);
    }

    private void editNormDocuments(NormDocumentFragmentBinding normDocumentFragmentBinding) {
        normDocumentFragmentBinding.btnNormDocumentsCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LegisNormDocuments legisNormDocuments = normDocumentFragmentBinding.getNormDocumentsViewModel().getLegisNormDocuments();
                legisNormDocuments.setId(mBundle.getInt(NormDocumentFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(legisNormDocuments)) {
                                    Toast.makeText(EditScientificWorkActivity.this, legisNormDocuments.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", legisNormDocuments);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setNormDocuments();
                            }
                        }).create().show();
            }
        });
    }

    private void setPatents() {
        PatentsFragmentBinding patentsFragmentBinding = PatentsFragmentBinding.inflate(getLayoutInflater());
        Patent patent = (Patent) mBundle.get(PatentsFragment.SCIENT_WORK);
        PatentsViewModel patentsViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(PatentsViewModel.class);
        patentsFragmentBinding.setPatentsViewModel(patentsViewModel);
        patentsFragmentBinding.getPatentsViewModel().setUserLogin(patent.getUserLogin());
        patentsFragmentBinding.getPatentsViewModel().setValues(patent);
        setContentView(patentsFragmentBinding.getRoot());
        editPatent(patentsFragmentBinding);
    }

    private void editPatent(PatentsFragmentBinding patentsFragmentBinding) {
        patentsFragmentBinding.btnPatentCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Patent patent = patentsFragmentBinding.getPatentsViewModel().getPatentData();
                patent.setId(mBundle.getInt(PatentsFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(patent)) {
                                    Toast.makeText(EditScientificWorkActivity.this, patent.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", patent);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setPatents();
                            }
                        }).create().show();
            }
        });
    }

    private void setPreprints() {
        PreprintFragmentBinding preprintFragmentBinding = PreprintFragmentBinding.inflate(getLayoutInflater());
        Preprint preprint = (Preprint) mBundle.get(PreprintFragment.SCIENT_WORK);
        PreprintViewModel preprintViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(PreprintViewModel.class);
        preprintFragmentBinding.setPreprintViewModel(preprintViewModel);
        preprintFragmentBinding.getPreprintViewModel().setUserLogin(preprint.getUserLogin());
        preprintFragmentBinding.getPreprintViewModel().setValues(preprint);
        setContentView(preprintFragmentBinding.getRoot());
        editPreprint(preprintFragmentBinding);
    }

    private void editPreprint(PreprintFragmentBinding preprintFragmentBinding) {
        preprintFragmentBinding.btnPreprintCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preprint preprint = preprintFragmentBinding.getPreprintViewModel().getPreprintData();
                preprint.setId(mBundle.getInt(PreprintFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(preprint)) {
                                    Toast.makeText(EditScientificWorkActivity.this, preprint.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", preprint);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setPreprints();
                            }
                        }).create().show();
            }
        });
    }

    private void setStandart() {
        StandartFragmentBinding standartFragmentBinding = StandartFragmentBinding.inflate(getLayoutInflater());
        Standart standart = (Standart) mBundle.get(StandartFragment.SCIENT_WORK);
        StandartViewModel standartViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(StandartViewModel.class);
        standartFragmentBinding.setStandartViewModel(standartViewModel);
        standartFragmentBinding.getStandartViewModel().setUserLogin(standart.getUserLogin());
        standartFragmentBinding.getStandartViewModel().setValues(standart);
        setContentView(standartFragmentBinding.getRoot());
        editStandart(standartFragmentBinding);
    }

    private void editStandart(StandartFragmentBinding standartFragmentBinding) {
        standartFragmentBinding.btnStandartCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Standart standart = standartFragmentBinding.getStandartViewModel().getStandartData();
                standart.setId(mBundle.getInt(StandartFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(standart)) {
                                    Toast.makeText(EditScientificWorkActivity.this, standart.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", standart);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setStandart();
                            }
                        }).create().show();
            }
        });
    }

    private void setThesis() {
        ThesisFragmentBinding thesisFragmentBinding = ThesisFragmentBinding.inflate(getLayoutInflater());
        Thesis thesis = (Thesis) mBundle.get(ThesisFragment.SCIENT_WORK);
        ThesisViewModel thesisViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ThesisViewModel.class);
        thesisFragmentBinding.setThesisViewModel(thesisViewModel);
        thesisFragmentBinding.getThesisViewModel().setUserLogin(thesis.getLoginUser());
        thesisFragmentBinding.getThesisViewModel().setValues(thesis);
        setContentView(thesisFragmentBinding.getRoot());
        editThesis(thesisFragmentBinding);
    }

    private void editThesis(ThesisFragmentBinding thesisFragmentBinding) {
        thesisFragmentBinding.btnThesisCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thesis thesis = thesisFragmentBinding.getThesisViewModel().getThesisData();
                thesis.setId(mBundle.getInt(ThesisFragment.ID));

                String textAlert = "Ви впевнені, що хочете внести зміни в даній роботі?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (scientificWorkCRUDViewModel.getUserEditViewModel().update(thesis)) {
                                    Toast.makeText(EditScientificWorkActivity.this, thesis.getTypeOfWork() + " успішно оновлений", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(mContext, ReportActivity.class);
                                    intent.putExtra("WORK", thesis);
                                    setResult(ReportActivity.REQUEST_RESULT_REPORT, intent);
                                    finish();
                                }
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setThesis();
                            }
                        }).create().show();
            }
        });
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




}