package com.kpi.scineticle.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.CatalogFragmentBinding;
import com.kpi.scineticle.view.ScientificWorkMainActivity;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.CatalogViewModel;

public class CatalogFragment extends Fragment {

    private CatalogFragmentBinding mCatalogFragmentBinding;
    private CatalogViewModel.NewCatalog mNewCatalog;
    private Context mContext;
    private String userLogin;

    public static CatalogFragment newInstance() {
        return new CatalogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        CatalogViewModel catalogViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(CatalogViewModel.class);

        mCatalogFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.catalog_fragment, container, false);
        View view = mCatalogFragmentBinding.getRoot();
        mCatalogFragmentBinding.setCatalogViewModel(catalogViewModel);
        mNewCatalog = catalogViewModel.new NewCatalog();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        catalogViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mCatalogFragmentBinding.btnCatalogCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewCatalog.createNewCatalog();
                Toast.makeText(mContext, "Каталог успішно створено", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });
    }

}