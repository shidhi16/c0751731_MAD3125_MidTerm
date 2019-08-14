package com.example.c0751731_mad3125_midterm.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0751731_mad3125_midterm.MySharedPref;
import com.example.c0751731_mad3125_midterm.R;
import com.example.c0751731_mad3125_midterm.Utilities.Validation;
import com.example.c0751731_mad3125_midterm.pojoUsers.Users;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoginScreenActivity extends AppCompatActivity {

    AppCompatActivity mActivity = LoginScreenActivity.this;
    private static final String TAG = "LoginScreenActivity";

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;


    String userFile;

    private ArrayList<Users> usersArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);
        initView();
        try {
          userFile =  readUsers("users");
        }catch (Exception e){
            e.printStackTrace();
        }
        readFromString();

        for (int i =0 ; i< usersArrayList.size() ; i++){
            Log.e(TAG, "email: "+usersArrayList.get(i).getUserEmail() );
            Log.e(TAG, "password: "+usersArrayList.get(i).getUserPassword() );
            Log.e(TAG, "............................." );
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: ");
                if (isValid()){
                    if (checkFromList(edtEmail.getText().toString(),
                            edtPassword.getText().toString())) {

                        MySharedPref.writeString(mActivity,MySharedPref.isLogin,"True");
                        MySharedPref.writeString(mActivity,MySharedPref.emailId,edtEmail.getText().toString());
                        startActivity(new Intent(mActivity , SatelliteActivity.class));
                    }else {
                        Toast.makeText(mActivity,"Wrong Credentials Entered",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void readFromString() {
            try {
                JSONArray userJsonArray = new JSONArray(userFile);
                for (int i =0 ; i<userJsonArray.length() ;i++){
                    Users users = new Users();
                    JSONObject userObject = userJsonArray.getJSONObject(i);
                    users.setUserID(userObject.getInt("userID"));
                    users.setUserEmail(userObject.getString("userEmail"));
                    users.setUserPassword(userObject.getString("userPassword"));
                    usersArrayList.add(users);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public String readUsers(String fileName) throws IOException
        {
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(getAssets().open(fileName), "UTF-8"));

            String content = "";
            String line;
            while ((line = reader.readLine()) != null)
            {
                content = content + line;
            }

            return content;

        }



    private boolean checkFromList(String email, String password) {
        Log.e(TAG, "email: "+email );
        Log.e(TAG, "password: "+password );
        for (int i =0 ; i<usersArrayList.size(); i++) {
            if (usersArrayList.get(i).getUserEmail().equalsIgnoreCase(email)) {
                Log.e(TAG, "email found: " );
                if (usersArrayList.get(i).getUserPassword().equalsIgnoreCase(password)) {
                    Log.e(TAG, "password found: ." );
                    return true;
                }
            }
        }
        return false;
    }


    private void initView() {

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    private boolean isValid() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (email.isEmpty() || email.trim().length() == 0) {
            edtEmail.setError("Enter Email ID");
            return false;
        }else if (!Validation.isValidEmail(email)){
            edtEmail.setError("Enter Valid Email ID");
            return false;
        }
       else if (password.isEmpty() || password.trim().length() == 0) {
            edtPassword.setError("Enter Password");
            return false;
        }else if (!Validation.isValidPassword(password)){
            edtPassword.setError("Enter Valid Password");
        }
        return true;

    }


}
