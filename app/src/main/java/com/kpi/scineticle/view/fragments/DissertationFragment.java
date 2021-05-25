package com.kpi.scineticle.view.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kpi.scineticle.R;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.DissertationViewModel;

public class DissertationFragment extends Fragment {

    private DissertationViewModel mViewModel;

    public static DissertationFragment newInstance() {
        return new DissertationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dissertation_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  mViewModel = new ViewModelProvider(this).get(DissertationViewModel.class);
        // TODO: Use the ViewModel
    }

}