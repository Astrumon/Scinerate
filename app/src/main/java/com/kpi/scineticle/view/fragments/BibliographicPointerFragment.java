package com.kpi.scineticle.view.fragments;

import android.content.Context;
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
import com.kpi.scineticle.databinding.BibliographicPointerFragmentBinding;
import com.kpi.scineticle.model.subsystemOfDataBase.bibliographic_pointers.BibliographicPointer;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ArticleViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BibliographicPointerViewModel;

public class BibliographicPointerFragment extends Fragment {

    private Context mContext;
    private String userLogin;
    private BibliographicPointerViewModel.NewBibliographicPointer mNewBibliographicPointer;
    private BibliographicPointerFragmentBinding mBibliographicPointerFragmentBinding;

    public static BibliographicPointerFragment newInstance() {
        return new BibliographicPointerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        BibliographicPointerViewModel bibliographicPointerViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(BibliographicPointerViewModel.class);

        mBibliographicPointerFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.bibliographic_pointer_fragment, container, false);
        View view = mBibliographicPointerFragmentBinding.getRoot();
        mBibliographicPointerFragmentBinding.setBibliographiPointerViewModel(bibliographicPointerViewModel);
        mNewBibliographicPointer = bibliographicPointerViewModel.new NewBibliographicPointer();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        bibliographicPointerViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mContext = getContext();
        mBibliographicPointerFragmentBinding.btnCreateBibliographicPointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewBibliographicPointer.createNewBibliographicPointer();
                Toast.makeText(mContext, "Бібліографічний покажчик успішно створено", Toast.LENGTH_SHORT).show();
            }
        });
    }

}