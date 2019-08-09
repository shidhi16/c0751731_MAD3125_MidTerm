package com.example.c0751731_mad3125_midterm.Utilities;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.example.c0751731_mad3125_midterm.BaseActivity;
import com.example.c0751731_mad3125_midterm.R;

    public class Utility {

        public static void showAlertDialog(BaseActivity mActivity, String message){
            AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
            builder.setTitle(mActivity.getString(R.string.app_name));
            builder.setMessage(message);
            builder.setPositiveButton(R.string.dismiss, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            builder.create();
            builder.show();
        }

    }

