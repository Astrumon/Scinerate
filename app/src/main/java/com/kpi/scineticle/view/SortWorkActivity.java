package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.model.Data;
import com.kpi.scineticle.model.WorkSorter;

import java.util.ArrayList;

public class SortWorkActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button mButton;
    public static final String DATA_FOR_SORT = "DATA_FOR_SORT";
    private String typeOfSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort_work);
        mButton = findViewById(R.id.btn_sort);
        setTitle("Сортування");

        initSpinner();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(DATA_FOR_SORT, typeOfSort );
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_close, menu);
        return true;
    }

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.spinner_sorter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.searcher, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        switch (text) {
            case "-":
                typeOfSort = "NONE";
                break;
            case "Автори":
                typeOfSort = WorkSorter.SORT_BY_AUTHORS;
                break;
            case "Типи робіт":
                typeOfSort = WorkSorter.SORT_BY_TYPE;
                break;
            case "Дата публікації":
                typeOfSort = WorkSorter.SORT_BY_DATE;
                break;
            case "Назва роботи":
                typeOfSort = WorkSorter.SORT_BY_NAME;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.close) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}