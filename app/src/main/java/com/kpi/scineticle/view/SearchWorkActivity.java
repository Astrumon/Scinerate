package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.kpi.scineticle.R;

public class SearchWorkActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Context mContext;
    public static final String DATA_FOR_SEARCH = "DATA_FOR_SEARCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_search_work);
        setTitle("Пошук");
        getIntent();
        initSpinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_close, menu);
        return true;
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

    private void initSpinner() {
        Spinner spinner = findViewById(R.id.spinner_searcher);
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
            case "Автори":
                Toast.makeText(mContext, "AUTHORS", Toast.LENGTH_SHORT).show();
                break;
            case "Типи робіт":
                Toast.makeText(mContext, "TYPE", Toast.LENGTH_SHORT).show();
                break;
            case "Дата публікації":
                Toast.makeText(mContext, "DatePublish", Toast.LENGTH_SHORT).show();
                break;
            case "Назва роботи":
                Toast.makeText(mContext, "Name", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}