package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }
        public void onClick_Signup (View view){
        try{
        Intent intent = new Intent(this, SignUp.class);
        startActivityForResult(intent, 2);
    }
    catch(Exception e){

    }
    }
}
