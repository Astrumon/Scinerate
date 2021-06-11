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
import com.kpi.scineticle.databinding.StandartFragmentBinding;
import com.kpi.scineticle.view.ScientificWorkMainActivity;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.StandartViewModel;

import java.util.Objects;

public class StandartFragment extends Fragment {

    private StandartFragmentBinding mStandartFragmentBinding;
    private StandartViewModel.NewStandart mNewStandart;
    private Context mContext;
    private String userLogin;

    public static final String ID = "com.kpi.scienticle.standart.ID";
    public static final String SCIENT_WORK = "com.kpi.scienticle.standart.SCIENT_WORK";

    public static StandartFragment newInstance() {
        return new StandartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        StandartViewModel standartViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(StandartViewModel.class);

        mStandartFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.standart_fragment, container, false);
        View view = mStandartFragmentBinding.getRoot();
        mStandartFragmentBinding.setStandartViewModel(standartViewModel);
        mNewStandart = standartViewModel.new NewStandart();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        standartViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mStandartFragmentBinding.btnStandartCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNewStandart.createNewStandart()) {
                    Toast.makeText(mContext, "Стандарт успішно створено", Toast.LENGTH_SHORT).show();
                    Objects.requireNonNull(getActivity()).finish();
                }
            }
        });
    }

}