package com.kpi.scineticle.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityScientificWorkBinding;
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
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.Alert;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ScientificWorkCRUDViewModel;

import java.util.List;

public class ScientificWorkMainActivity extends AppCompatActivity {
    public static final int ADD_ARTICLE_REQUEST = 1;
    public static final int EDIT_ARTICLE_REQUEST = 2;
    private ScientificWorkAdapter mScientificWorkAdapter;
    private ScientificWorkCRUDViewModel mScientificWorkCRUDViewModel;
    private ActivityScientificWorkBinding mBinding;
    private Context mContext;
    private String login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setContentView(R.layout.activity_scientific_work);

        setLogin();

        mScientificWorkAdapter = new ScientificWorkAdapter();

        initDataBinding();
        setupListScienticView(mBinding.recyclerArticle);

        mContext = this;

        clickToAddWork();
        clickItem();
        swipeToDeleteWork();
    }

    private void clickItem() {
        mScientificWorkAdapter.setOnItemClickListener(new ScientificWorkAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Object o) {
                Toast.makeText(mContext, "TEST", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(Object o) {
                Toast.makeText(mContext, "LONG_TEST", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clickToAddWork() {
        mBinding.buttonAddArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScientificWorkMainActivity.this, AddEditScientificWorkActivity.class);
                intent.putExtra("login", login);
                startActivityForResult(intent, ADD_ARTICLE_REQUEST);
            }
        });
    }

    private void setLogin() {
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            login = arguments.get("login").toString();
        }

        Toast.makeText(this, login + " вітаємо!", Toast.LENGTH_SHORT).show();
    }

    private void swipeToDeleteWork() {
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                String textAlert = "Ви впевнені, що хочете видалити дану роботу?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteWorkByType(viewHolder.getItemViewType(), viewHolder.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setupListScienticView(mBinding.recyclerArticle);
                            }
                        }).create().show();
            }
        }).attachToRecyclerView(mBinding.recyclerArticle);
    }

    public void deleteWorkByType(int type, int position) {
        switch (type) {
            case Data.ARTICLE:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mArticleRepository
                        .delete((Article) mScientificWorkAdapter.getScientWork(position).article);
                break;
            case Data.BOOK:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mBookRepository
                        .delete((Book) mScientificWorkAdapter.getScientWork(position).book);
                break;
            case Data.BIBLIOGRAPHIC_POINTER:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mBibliographicRepository
                        .delete((BibliographicPointer) mScientificWorkAdapter.getScientWork(position).bibliographicPointer);
                break;
            case Data.CATALOG:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mCatalogRepository
                        .delete((Catalog) mScientificWorkAdapter.getScientWork(position).catalog);
                break;
            case Data.DISSERTATION:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mDissertationRepository
                        .delete((Dissertation) mScientificWorkAdapter.getScientWork(position).dissertation);
                break;
            case Data.ELECTRONIC_RESOURCE:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mElectronicResourceRepository
                        .delete((ElectronicResource) mScientificWorkAdapter.getScientWork(position).electronicResource);
                break;
            case Data.LEGIS_NORM_DOCUMENTS:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mLegisNormDocumentsRepository
                        .delete((LegisNormDocuments) mScientificWorkAdapter.getScientWork(position).legisNormDocuments);
                break;
            case Data.PATENT:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mPatentRepository
                        .delete((Patent) mScientificWorkAdapter.getScientWork(position).patent);
                break;
            case Data.PREPRINT:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mPreprintRepository
                        .delete((Preprint) mScientificWorkAdapter.getScientWork(position).preprint);
                break;
            case Data.STANDART:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mStandartRepository
                        .delete((Standart) mScientificWorkAdapter.getScientWork(position).standart);
                break;
            case Data.THESIS:
                mScientificWorkCRUDViewModel.getUserDeleteViewModel().mThesisRepository
                        .delete((Thesis) mScientificWorkAdapter.getScientWork(position).thesis);
                break;
        }

    }

    public void deleteAllWorks() {
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mArticleRepository.deleteAllArticles(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mBookRepository.deleteAllBooks(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mCatalogRepository.deleteAllCatalogs(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mDissertationRepository.deleteAllDissertations(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mElectronicResourceRepository.deleteAllElectronicResources(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mLegisNormDocumentsRepository.deleteAllLegisNormDocuments(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mPatentRepository.deleteAllPatents(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mPreprintRepository.deleteAllPreprints(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mStandartRepository.deleteAllStandarts(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mThesisRepository.deleteAllThesis(login);
        mScientificWorkCRUDViewModel.getUserDeleteViewModel().mBibliographicRepository.deleteAllBibliographicPointers(login);
    }

    private void setupListScienticView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mScientificWorkCRUDViewModel.getAllTestWorks().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                mScientificWorkAdapter.setBooks(books);
            }
        });

        mScientificWorkCRUDViewModel.getAllArticle().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> books) {
                mScientificWorkAdapter.setArticles(books);
            }
        });

        mScientificWorkCRUDViewModel.getAllBibliographicPointers().observe(this, new Observer<List<BibliographicPointer>>() {
            @Override
            public void onChanged(List<BibliographicPointer> bibliographicPointers) {
                mScientificWorkAdapter.setListBibliographicPointers(bibliographicPointers);
            }
        });

        mScientificWorkCRUDViewModel.getAllCatalogs().observe(this, new Observer<List<Catalog>>() {
            @Override
            public void onChanged(List<Catalog> catalogs) {
                mScientificWorkAdapter.setCatalogs(catalogs);
            }
        });

        mScientificWorkCRUDViewModel.getAllDissertation().observe(this, new Observer<List<Dissertation>>() {
            @Override
            public void onChanged(List<Dissertation> dissertations) {
                mScientificWorkAdapter.setDissertations(dissertations);
            }
        });

        mScientificWorkCRUDViewModel.getAllElectronicResources().observe(this, new Observer<List<ElectronicResource>>() {
            @Override
            public void onChanged(List<ElectronicResource> electronicResources) {
                mScientificWorkAdapter.setElectronicResources(electronicResources);
            }
        });

        mScientificWorkCRUDViewModel.getAllLegisNormDocuments().observe(this, new Observer<List<LegisNormDocuments>>() {
            @Override
            public void onChanged(List<LegisNormDocuments> legisNormDocuments) {
                mScientificWorkAdapter.setLegisNormDocuments(legisNormDocuments);
            }
        });

        mScientificWorkCRUDViewModel.getAllPatents().observe(this, new Observer<List<Patent>>() {
            @Override
            public void onChanged(List<Patent> patents) {
                mScientificWorkAdapter.setPatents(patents);
            }
        });

        mScientificWorkCRUDViewModel.getAllPreprints().observe(this, new Observer<List<Preprint>>() {
            @Override
            public void onChanged(List<Preprint> preprints) {
                mScientificWorkAdapter.setPreprints(preprints);
            }
        });

        mScientificWorkCRUDViewModel.getAllStandarts().observe(this, new Observer<List<Standart>>() {
            @Override
            public void onChanged(List<Standart> standarts) {
                mScientificWorkAdapter.setStandarts(standarts);
            }
        });

        mScientificWorkCRUDViewModel.getAllTheses().observe(this, new Observer<List<Thesis>>() {
            @Override
            public void onChanged(List<Thesis> theses) {
                mScientificWorkAdapter.setTheses(theses);
            }
        });

        recyclerView.setAdapter(mScientificWorkAdapter);
    }

    public void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_scientific_work);
        mScientificWorkCRUDViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ScientificWorkCRUDViewModel.class);
        mScientificWorkCRUDViewModel.setUserLogin(login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_scientific_work, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAllArticles:
                String textAlert = "Ви впевнені, що хочете видалити всі роботи?";
                Alert.createAlert(mContext, textAlert)
                        .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteAllWorks();
                                Toast.makeText(mContext, "Всі бібліографічні записи видалені", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // setupListScienticView(mBinding.recyclerArticle);
                            }
                        }).create().show();


                return true;
            case R.id.sortByName:
                //TODO sort by name article
                Toast.makeText(this, "All arcticles sorted by name", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sortByDate:
                //TODO sort by date article
                Toast.makeText(this, "All articles sorted by date", Toast.LENGTH_SHORT).show();
            case R.id.close:
                alertAboutExit();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onBackPressed() {
        alertAboutExit();
    }

    public void alertAboutExit() {
        String textAlert = "Ви впевнені, що хочете вийти з аккаунту?";
        Alert.createAlert(mContext, textAlert)
                .setPositiveButton("Так", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ScientificWorkMainActivity.this, AuthenticationActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // setupListScienticView(mBinding.recyclerArticle);
                    }
                }).create().show();
    }
}
