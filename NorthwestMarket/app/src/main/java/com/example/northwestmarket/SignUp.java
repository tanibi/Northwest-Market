package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void onClick_createAccount(View v) {
        Intent in = new Intent(this, Login.class);
        startActivity(in);
    }
    public void onClick_back(View v) {
        Intent in = new Intent(this, StartPage.class);
        startActivity(in);
    }
}
