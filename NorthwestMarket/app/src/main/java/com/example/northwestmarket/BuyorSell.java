package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BuyorSell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyor_sell);
    }

    public void onClick_sell(View v) {

        try {
            Intent in = new Intent(this, SellerHome.class);
            startActivityForResult(in, 1);

        } catch (Exception e) {


        }


    }
}
