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
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ArticleViewModel;

public class ArticleFragment extends Fragment {

    public final static String ARTICLE = "ARTICLE";
    private ArticleFragmentBinding mArticleFragmentBinding;
    private ArticleViewModel.NewArticle mNewArticle;
    private Context mContext;
    private String userLogin;

    public static ArticleFragment newInstance() {
        return new ArticleFragment();
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
        mArticleFragmentBinding.btnCreateArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewArticle.createNewArticle();
                Toast.makeText(mContext, "Стаття успішно створена", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });
    }


}