package com.kpi.scineticle.view.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kpi.scineticle.R;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.PatentsViewModel;

public class PatentsFragment extends Fragment {

    private PatentsViewModel mViewModel;

    public static PatentsFragment newInstance() {
        return new PatentsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.patents_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = new ViewModelProvider(this).get(PatentsViewModel.class);
        // TODO: Use the ViewModel
    }

}