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
import com.kpi.scineticle.databinding.PreprintFragmentBinding;
import com.kpi.scineticle.view.ScientificWorkMainActivity;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.PreprintViewModel;

import java.util.Objects;

public class PreprintFragment extends Fragment {

    private PreprintFragmentBinding mPreprintFragmentBinding;
    private PreprintViewModel.NewPreprint mNewPreprint;
    private Context mContext;
    private String userLogin;

    public static final String ID = "com.kpi.scienticle.preprints.ID";
    public static final String SCIENT_WORK = "com.kpi.scienticle.preprints.SCIENT_WORK";

    public static PreprintFragment newInstance() {
        return new PreprintFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        PreprintViewModel preprintViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(PreprintViewModel.class);

        mPreprintFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.preprint_fragment, container, false);
        View view = mPreprintFragmentBinding.getRoot();
        mPreprintFragmentBinding.setPreprintViewModel(preprintViewModel);
        mNewPreprint = preprintViewModel.new NewPreprint();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        preprintViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mPreprintFragmentBinding.btnPreprintCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mNewPreprint.createNewPreprint()) {
                   Toast.makeText(mContext, "Препринт успішно створено", Toast.LENGTH_SHORT).show();
                   Objects.requireNonNull(getActivity()).finish();
               }
            }
        });
    }

}