package com.husenansari.boxoffice.helper;

import android.app.ProgressDialog;
import android.content.Context;


/**
 * Created by gulamhusen on 10-04-2017.
 */

public class ProgressBarHelper implements ProgressListener {

    ProgressDialog dialog;

    public ProgressBarHelper(Context context, boolean isCancelabe){
        dialog = new ProgressDialog(context);
        dialog.setCancelable(isCancelabe);
        dialog.setCanceledOnTouchOutside(isCancelabe);
        dialog.setMessage("Please wait..");
    }


    @Override
    public void showProgressDialog() {
        if (dialog != null){
            dialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if (dialog != null){
            dialog.dismiss();
        }
    }
}
