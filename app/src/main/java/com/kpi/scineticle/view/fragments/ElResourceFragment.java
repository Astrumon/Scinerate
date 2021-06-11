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
import com.kpi.scineticle.databinding.ElResourceFragmentBinding;
import com.kpi.scineticle.view.ScientificWorkMainActivity;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ElResourceViewModel;

import java.util.Objects;

public class ElResourceFragment extends Fragment {

    private ElResourceFragmentBinding mElResourceFragmentBinding;
    private ElResourceViewModel.NewElectronicResource mNewElectronicResource;
    private Context mContext;
    private String userLogin;

    public static final String ID = "com.kpi.scienticle.electronic_resource.ID";
    public static final String SCIENT_WORK = "com.kpi.scienticle.electronic_resource.SCIENT_WORK";

    public static ElResourceFragment newInstance() {
        return new ElResourceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ElResourceViewModel elResourceViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(ElResourceViewModel.class);

        mElResourceFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.el_resource_fragment, container, false);
        View view = mElResourceFragmentBinding.getRoot();
        mElResourceFragmentBinding.setElResourceViewModel(elResourceViewModel);
        mNewElectronicResource = elResourceViewModel.new NewElectronicResource();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        elResourceViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mElResourceFragmentBinding.btnElResourceCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNewElectronicResource.createNewElectronicResource()) {
                    Toast.makeText(mContext, "Електронний ресурс успішно створено", Toast.LENGTH_SHORT).show();
                    Objects.requireNonNull(getActivity()).finish();
                }
            }
        });
    }

}