package com.kpi.scineticle.viewmodel.subsystemOfMakingDecisions;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.kpi.scineticle.R;

public class Alert {

    public static AlertDialog.Builder createAlert(Context context, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Увага!")
                .setMessage(text)
                .setIcon(R.drawable.ic_baseline_save_24);
        return builder;
    }
}
