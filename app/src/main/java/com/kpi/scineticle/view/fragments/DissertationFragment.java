package com.kpi.scineticle.view.fragments;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
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
import com.kpi.scineticle.databinding.DissertationFragmentBinding;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.DissertationViewModel;

public class DissertationFragment extends Fragment {

    private DissertationFragmentBinding mDissertationFragmentBinding;
    private DissertationViewModel.NewDissertation mNewDissertation;
    private Context mContext;
    private String userLogin;

    public static DissertationFragment newInstance() {
        return new DissertationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DissertationViewModel dissertationViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(DissertationViewModel.class);

        mDissertationFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.dissertation_fragment, container, false);
        View view = mDissertationFragmentBinding.getRoot();
        mDissertationFragmentBinding.setDissertetionViewModel(dissertationViewModel);
        mNewDissertation = dissertationViewModel.new NewDissertation();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        dissertationViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mDissertationFragmentBinding.btnDissertationCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewDissertation.createNewDissertation();
                Toast.makeText(mContext, "Дисертацію успішно створено", Toast.LENGTH_SHORT).show();
            }
        });
    }

}