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

        Toast.makeText(this, login + " Вітаємо!", Toast.LENGTH_SHORT).show();
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
        }

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

        recyclerView.setAdapter(mScientificWorkAdapter);
    }

    public void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_scientific_work);
        mScientificWorkCRUDViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(ScientificWorkCRUDViewModel.class);
        mScientificWorkCRUDViewModel.setUserLogin(getIntent().getExtras().get("login").toString());
        Log.d("MAIN", "initDataBinding: " + getIntent().getExtras().get("login").toString());
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
                //TODO delete article
                Toast.makeText(this, "All articles deleted", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sortByName:
                //TODO sort by name article
                Toast.makeText(this, "All arcticles sorted by name", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sortByDate:
                //TODO sort by date article
                Toast.makeText(this, "All articles sorted by date", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ScientificWorkMainActivity.this, AuthenticationActivity.class);
        startActivity(intent);
    }
}
