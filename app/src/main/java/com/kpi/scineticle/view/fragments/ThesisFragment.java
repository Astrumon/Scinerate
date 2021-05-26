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
import com.kpi.scineticle.databinding.ThesisFragmentBinding;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ThesisViewModel;

public class ThesisFragment extends Fragment {

    private ThesisFragmentBinding mThesisFragmentBinding;
    private ThesisViewModel.NewThesis mNewThesis;
    private Context mContext;
    private String userLogin;

    public static ThesisFragment newInstance() {
        return new ThesisFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ThesisViewModel thesisViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(ThesisViewModel.class);

        mThesisFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.thesis_fragment, container, false);
        View view = mThesisFragmentBinding.getRoot();
        mThesisFragmentBinding.setThesisViewModel(thesisViewModel);
        mNewThesis = thesisViewModel.new NewThesis();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        thesisViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mThesisFragmentBinding.btnThesisCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewThesis.createNewThesis();
                Toast.makeText(mContext, "Тезис успішно створено", Toast.LENGTH_SHORT).show();
            }
        });
    }

}