package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClick_forgot_pwd(View v){
        try{
            Intent in = new Intent(this,ForgotPassword.class);
            startActivityForResult(in, 1);

        }
        catch (Exception e){


        }
    }

    public void onClick_Login_success(View v){

        try{
            Intent in = new Intent(this,BuyorSell.class);
            startActivityForResult(in, 1);

        }
        catch (Exception e){


        }
    }
}
