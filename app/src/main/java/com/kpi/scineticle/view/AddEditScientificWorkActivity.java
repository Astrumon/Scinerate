package com.kpi.scineticle.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.kpi.scineticle.R;
import com.kpi.scineticle.model.subsystemOfDataBase.catalogs.Catalog;
import com.kpi.scineticle.model.subsystemOfDataBase.dissertations.Dissertation;
import com.kpi.scineticle.model.subsystemOfDataBase.electronic_resource.ElectronicResource;
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

public class AddEditScientificWorkActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private FrameLayout container;
    private FragmentManager mFragmentManager;
    private ArticleFragment mArticleFragment;
    private BookFragment mBookFragment;
    private DissertationFragment mDissertationFragment;
    private PatentsFragment mPatentsFragment;
    private ThesisFragment mThesisFragment;
    private ElResourceFragment mElResourceFragment;
    private NormDocumentFragment mNormDocumentFragment;
    private StandartFragment mStandartFragment;
    private PreprintFragment mPreprintFragment;
    private CatalogFragment mCatalogFragment;
    private BibliographicPointerFragment mBibliographicPointerFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_scientific_work);

        container = (FrameLayout) findViewById(R.id.container);

        initFragments();
        setArgumentsToFragments();

        Spinner spinner = findViewById(R.id.spinner_article);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.articles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void setArgumentsToFragments() {
        Bundle bundle = getIntent().getExtras();
        Log.d("ADD_EDIT", "onCreate: " + bundle.get("login"));
        mArticleFragment.setArguments(bundle);
        mCatalogFragment.setArguments(bundle);
        mElResourceFragment.setArguments(bundle);
        mBookFragment.setArguments(bundle);
        mDissertationFragment.setArguments(bundle);
        mPatentsFragment.setArguments(bundle);
        mThesisFragment.setArguments(bundle);
        mNormDocumentFragment.setArguments(bundle);
        mPreprintFragment.setArguments(bundle);
        mStandartFragment.setArguments(bundle);
        mBibliographicPointerFragment.setArguments(bundle);
    }

    private void initFragments() {
        mFragmentManager = getSupportFragmentManager();
        mArticleFragment = new ArticleFragment();
        mBookFragment = new BookFragment();
        mDissertationFragment = new DissertationFragment();
        mPatentsFragment = new PatentsFragment();
        mThesisFragment = new ThesisFragment();
        mElResourceFragment = new ElResourceFragment();
        mNormDocumentFragment = new NormDocumentFragment();
        mStandartFragment = new StandartFragment();
        mPreprintFragment = new PreprintFragment();
        mCatalogFragment = new CatalogFragment();
        mBibliographicPointerFragment = new BibliographicPointerFragment();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();

        switch (text) {
            case "Стаття" : Toast.makeText(parent.getContext(), "article", Toast.LENGTH_SHORT).show();
                ArticleFragment articleFragment = (ArticleFragment)mFragmentManager.findFragmentById(mArticleFragment.getId());
                showFragment(articleFragment, mArticleFragment);
            break;
            case "Книга": Toast.makeText(parent.getContext(), "книга", Toast.LENGTH_SHORT).show();
                BookFragment bookFragment = (BookFragment) mFragmentManager.findFragmentById(mBookFragment.getId());
                showFragment(bookFragment, mBookFragment);
            break;
            case "Дисертація":
                DissertationFragment dissertationFragment = (DissertationFragment) mFragmentManager.findFragmentById(mDissertationFragment.getId()  );
                showFragment(dissertationFragment, mDissertationFragment);
                break;
            case "Патент":
                PatentsFragment patentsFragment = (PatentsFragment) mFragmentManager.findFragmentById(mPatentsFragment.getId());
                showFragment(patentsFragment, mPatentsFragment);
                break;
            case "Тезис":
                ThesisFragment thesisFragment = (ThesisFragment) mFragmentManager.findFragmentById(mThesisFragment.getId());
                showFragment(thesisFragment, mThesisFragment);
                break;
            case "Електронний ресурс":
                ElResourceFragment elResourceFragment = (ElResourceFragment) mFragmentManager.findFragmentById(mElResourceFragment.getId());
                showFragment(elResourceFragment, mElResourceFragment);
                break;
            case "Нормативний документ":
                NormDocumentFragment normDocumentFragment = (NormDocumentFragment) mFragmentManager.findFragmentById(mNormDocumentFragment.getId());
                showFragment(normDocumentFragment, mNormDocumentFragment);
                break;
            case "Стандарт":
                StandartFragment standartFragment = (StandartFragment) mFragmentManager.findFragmentById(mStandartFragment.getId());
                showFragment(standartFragment, mStandartFragment);
                break;
            case "Препринт":
                PreprintFragment preprintFragment = (PreprintFragment) mFragmentManager.findFragmentById(mPreprintFragment.getId());
                showFragment(preprintFragment, mPreprintFragment);
                break;
            case "Каталог":
                CatalogFragment catalogFragment = (CatalogFragment) mFragmentManager.findFragmentById(mCatalogFragment.getId());
                showFragment(catalogFragment, mCatalogFragment);
                break;
            case "Бібліографічний покажчик":
                BibliographicPointerFragment bibliographicPointerFragment = (BibliographicPointerFragment) mFragmentManager.findFragmentById(mBibliographicPointerFragment.getId());
                showFragment(bibliographicPointerFragment, mBibliographicPointerFragment);
                break;
            default:
                Toast.makeText(parent.getContext(), "nothing", Toast.LENGTH_SHORT).show();
        }
    }

    private void showFragment(Fragment fragment, Fragment replacementFragment) {
        if (fragment == null) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, replacementFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, mArticleFragment).commit();
    }
}
