package com.kpi.scineticle.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.kpi.scineticle.R;
import com.kpi.scineticle.databinding.ActivityAuthenticationBinding;
import com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions.Alert;

public class AuthenticationActivity extends AppCompatActivity {

    public static final int CREATE_NEW_USER = 1;
    public static final int LOGIN_USER = 2;
    private ActivityAuthenticationBinding mBinding;
    private Context mContext;
    public final static int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL = 100;
    public static boolean permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        permision();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);



        mContext = this;
        initDataBinding();

        mBinding.buttonNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthenticationActivity.this, CreateNewUserActivity.class);
                startActivityForResult(intent, CREATE_NEW_USER);
            }
        });

        mBinding.buttonExistingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthenticationActivity.this, LoginUserActivity.class);
                startActivityForResult(intent, LOGIN_USER);
            }
        });

    }

    private void permision() {
        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            permission = true;
        }
        else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL);
            permission = false;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permission = false;
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permission = true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL);
                permission = true;
            }
        } else {
            permission = true;
        }
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_authentication);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_close, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.close) {
            alertAboutExit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void closeApp() {
        this.finishAffinity();
    }
    @Override
    public void onBackPressed() {
       alertAboutExit();

    }

    public void alertAboutExit() {
        Alert.createAlert(this, "Ви дійсно хочете вийти з програми?")
                .setPositiveButton("Так",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeApp();
                    }
                })
                .setNegativeButton("Ні", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case AuthenticationActivity.MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permission = true;
                } else {
                    permission = false;
                }
            }
        }
    }

}