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
import com.kpi.scineticle.databinding.NormDocumentFragmentBinding;
import com.kpi.scineticle.view.ScientificWorkMainActivity;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.NormDocumentViewModel;

import java.util.Objects;

public class NormDocumentFragment extends Fragment {

    private NormDocumentFragmentBinding mNormDocumentFragmentBinding;
    private NormDocumentViewModel.NewLegisNormDocuments mNewLegisNormDocuments;
    private Context mContext;
    private String userLogin;


    public static final String ID = "com.kpi.scienticle.documents.ID";
    public static final String SCIENT_WORK = "com.kpi.scienticle.documents.SCIENT_WORK";


    public static NormDocumentFragment newInstance() {
        return new NormDocumentFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NormDocumentViewModel normDocumentViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(NormDocumentViewModel.class);

        mNormDocumentFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.norm_document_fragment, container, false);
        View view = mNormDocumentFragmentBinding.getRoot();
        mNormDocumentFragmentBinding.setNormDocumentsViewModel(normDocumentViewModel);
        mNewLegisNormDocuments = normDocumentViewModel.new NewLegisNormDocuments();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        normDocumentViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mNormDocumentFragmentBinding.btnNormDocumentsCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNewLegisNormDocuments.createNewLegisNormDocuments()) {
                    Toast.makeText(mContext, "Документ успішно створено", Toast.LENGTH_SHORT).show();
                    Objects.requireNonNull(getActivity()).finish();
                }
            }
        });
    }

}