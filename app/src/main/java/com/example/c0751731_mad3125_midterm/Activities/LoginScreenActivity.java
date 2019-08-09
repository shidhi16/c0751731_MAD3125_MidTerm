package com.example.c0751731_mad3125_midterm.Activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.c0751731_mad3125_midterm.BaseActivity;
import com.example.c0751731_mad3125_midterm.R;

public class LoginScreenActivity extends BaseActivity {

    BaseActivity mActivity = LoginScreenActivity.this;
    private static final String TAG = "LoginScreenActivity";

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: ");
                login();
            }
        });
    }

    private void initView() {

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    private boolean login() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (email.isEmpty() || email.trim().length() == 0) {
            edtEmail.setError("Enter Email ID");
            return false;
        }

        if (password.isEmpty() || password.trim().length() == 0) {
            edtPassword.setError("Enter Password");
            return false;
        }


        return true;

    }

}
