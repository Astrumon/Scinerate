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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.model.WorkSearcher;

public class SearchWorkActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Context mContext;
    public static final String DATA_FOR_SEARCH = "DATA_FOR_SEARCH";
    public static final String VALUE_FOR_SEARCH = "VALUE_FOR_SEARCH";
    private String typeSearch;
    private Button mButton;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_search_work);
        setTitle("Пошук");
        initSpinner();

        mButton = findViewById(R.id.btn_search);
        mEditText = findViewById(R.id.edit_text_search);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(DATA_FOR_SEARCH, typeSearch );
                intent.putExtra(VALUE_FOR_SEARCH, mEditText.getText().toString());
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
            case "-":
                typeSearch = "NONE";
                mEditText.setVisibility(View.INVISIBLE);
                break;
            case "Автори":
                mEditText.setVisibility(View.VISIBLE);
                Toast.makeText(mContext, "AUTHORS", Toast.LENGTH_SHORT).show();
                typeSearch = WorkSearcher.SEARCH_BY_AUTHORS;
                break;
            case "Типи робіт":
                mEditText.setVisibility(View.VISIBLE);
                Toast.makeText(mContext, "TYPE", Toast.LENGTH_SHORT).show();
                typeSearch = WorkSearcher.SEARCH_BY_TYPE;
                break;
            case "Дата публікації":
                mEditText.setVisibility(View.VISIBLE);
                Toast.makeText(mContext, "DatePublish", Toast.LENGTH_SHORT).show();
                typeSearch = WorkSearcher.SEARCH_BY_DATE;
                break;
            case "Назва роботи":
                mEditText.setVisibility(View.VISIBLE);
                Toast.makeText(mContext, "Name", Toast.LENGTH_SHORT).show();
                typeSearch = WorkSearcher.SEARCH_BY_NAME;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}