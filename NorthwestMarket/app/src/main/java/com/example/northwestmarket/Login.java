package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public Button btn;
    public Button btn1;
    public EditText email,password;
    String em,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.editText3);
    password=findViewById(R.id.editText2);
    em=email.getText().toString();
    pass=password.getText().toString();
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
        pass=password.getText().toString().trim();
        if(TextUtils.isEmpty(em)){
            email.setError("Email should not be empty");

            return;
        }
        if(TextUtils.isEmpty(pass)){
            password.setError("password should not be empty");

            return;
        }

        if (em.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
            if (pass.length() >= 6) {
                Intent in = new Intent(this, BuyorSell.class);
                startActivityForResult(in, 1);

            }
            else{
                Toast.makeText(this,"Password limit not reached",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this, "Email pattern not matched", Toast.LENGTH_SHORT).show();
            return;
        }

    }
}

