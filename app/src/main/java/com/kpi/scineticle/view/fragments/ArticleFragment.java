package com.kpi.scineticle.view.fragments;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ArticleFragmentBinding;
import com.kpi.scineticle.view.ScientificWorkMainActivity;
import com.kpi.scineticle.viewmodel.subsystemOutputData.UserOutputInfo;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ArticleViewModel;

import java.util.Objects;

public class ArticleFragment extends Fragment {

    public static final String SCIENT_WORK = "com.kpi.scienticle.article.SCIENT_WORK";
    public static final String ID = "com.kpi.scienticle.article.ID";

    private ArticleFragmentBinding mArticleFragmentBinding;
    private ArticleViewModel.NewArticle mNewArticle;
    private Context mContext;
    private String userLogin;
    private boolean flag = true;

    public static ArticleFragment newInstance() {
        return new ArticleFragment();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArticleViewModel articleViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(ArticleViewModel.class);

        mArticleFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.article_fragment, container, false);
        View view = mArticleFragmentBinding.getRoot();
        mArticleFragmentBinding.setArticleViewModel(articleViewModel);
        mNewArticle = articleViewModel.new NewArticle();

        userLogin = getArguments().get("login").toString();
        articleViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mContext = getContext();
        if (flag) {
            mArticleFragmentBinding.btnCreateArticle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mNewArticle.createNewArticle()) {
                        Toast.makeText(mContext, "Стаття успішно створена", Toast.LENGTH_SHORT).show();
                        Objects.requireNonNull(getActivity()).finish();
                    }

                }
            });
        } else {
            mArticleFragmentBinding.btnCreateArticle.setVisibility(View.INVISIBLE);
        }
    }

    public ArticleFragmentBinding getArticleFragmentBinding() {
        return mArticleFragmentBinding;
    }


}