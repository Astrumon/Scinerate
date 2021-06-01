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
import com.kpi.scineticle.databinding.PatentsFragmentBinding;
import com.kpi.scineticle.view.ScientificWorkMainActivity;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.PatentsViewModel;

public class PatentsFragment extends Fragment {

    private PatentsFragmentBinding mPatentsFragmentBinding;
    private PatentsViewModel.NewPatent mNewPatent;
    private Context mContext;
    private String userLogin;

    public static PatentsFragment newInstance() {
        return new PatentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        PatentsViewModel patentsViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(PatentsViewModel.class);

        mPatentsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.patents_fragment, container, false);
        View view = mPatentsFragmentBinding.getRoot();
        mPatentsFragmentBinding.setPatentsViewModel(patentsViewModel);
        mNewPatent = patentsViewModel.new NewPatent();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        patentsViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mPatentsFragmentBinding.btnPatentCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewPatent.createNewPatent();
                Toast.makeText(mContext, "Патент успішно створено", Toast.LENGTH_SHORT).show();
                getActivity().finish();
            }
        });
    }

}