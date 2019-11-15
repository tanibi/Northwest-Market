package com.example.northwestmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    public Button btn;
    public Button btn1;
    public EditText email,password;
    String em,pwd;
    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        email=findViewById(R.id.editText3);
    password=findViewById(R.id.editText2);
    em=email.getText().toString();
    pwd=password.getText().toString();
    Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onClick_Login_success();
        }
    });
    }

    public void onClick_forgot_pwd(View v){
        try{
            Intent in = new Intent(this,ForgotPassword.class);
            startActivityForResult(in, 1);

        }
        catch (Exception e){


        }
    }



    public void onClick_Login_success() {
        em=email.getText().toString().trim();
        pwd=password.getText().toString().trim();
        if(TextUtils.isEmpty(em)){
            email.setError("Email should not be empty");
            //Toast.makeText(this,"Email should not be empty",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            password.setError("password should not be empty");
            // Toast.makeText(this,"password should not be empty",Toast.LENGTH_LONG).show();
            return;
        }

        if(em.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            if(pwd.length()>=6) {

            }
            else{
                Toast.makeText(this,"Password limit not reached",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"Email pattern not matched",Toast.LENGTH_LONG).show();
        }
    }
}

