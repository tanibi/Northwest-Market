package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClick_CLick_me(View v){
        Button btn = findViewById(R.id.button4);
        try{
        Intent in = new Intent(this,StartPage.class);
        startActivityForResult(in, 1);

    }
        catch (Exception e){


        }
    }

}
