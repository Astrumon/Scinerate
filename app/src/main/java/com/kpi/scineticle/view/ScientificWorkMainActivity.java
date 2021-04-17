package com.kpi.scineticle.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kpi.scineticle.R;

public class ScientificWorkMainActivity extends AppCompatActivity {
    public static final int ADD_ARTICLE_REQUEST = 4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_work);

        FloatingActionButton button = findViewById(R.id.button_add_article);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScientificWorkMainActivity.this, AddEditScientificWorkActivity.class);
                startActivityForResult(intent, ADD_ARTICLE_REQUEST);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_scientific_work, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAllArticles:
                //TODO delete article
                Toast.makeText(this, "All articles deleted", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sortByName:
                //TODO sort by name article
                Toast.makeText(this, "All arcticles sorted by name", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sortByDate:
                //TODO sort by date article
                Toast.makeText(this, "All articles sorted by date", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
