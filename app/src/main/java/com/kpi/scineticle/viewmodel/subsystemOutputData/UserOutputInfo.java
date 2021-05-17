package com.kpi.scineticle.viewmodel.subsystemOutputData;

import android.content.Context;
import android.widget.Toast;

public class UserOutputInfo {
    private Context mContext;

    public UserOutputInfo(Context context) {
        mContext = context;
    }

    public void showError(String text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }

}
