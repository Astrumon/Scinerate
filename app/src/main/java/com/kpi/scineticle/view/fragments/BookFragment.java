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
import com.kpi.scineticle.databinding.BookFragmentBinding;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.ArticleViewModel;
import com.kpi.scineticle.viewmodel.subsystemUser.existingUser.BookViewModel;

public class BookFragment extends Fragment {

    private BookFragmentBinding mBookFragmentBinding;
    private BookViewModel.NewBook mNewBook;
    private Context mContext;
    private String userLogin;

    public static BookFragment newInstance() {
        return new BookFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        BookViewModel bookViewModel = new ViewModelProvider(requireActivity(),
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication())).get(BookViewModel.class);

        mBookFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.book_fragment, container, false);
        View view = mBookFragmentBinding.getRoot();
        mBookFragmentBinding.setBookViewModel(bookViewModel);
        mNewBook = bookViewModel.new NewBook();

        userLogin = getArguments().get("login").toString();
        Log.d("FRAGMENT: ", "onCreateView: " + userLogin);
        bookViewModel.setUserLogin(userLogin);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        mBookFragmentBinding.btnBookCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewBook.createNewBook();
                Toast.makeText(mContext, "Книга успішно створена", Toast.LENGTH_SHORT).show();
            }
        });
    }

}