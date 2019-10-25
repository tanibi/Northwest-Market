package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SellerHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);
        ImageView iv = findViewById(R.id.imageView4);
        ImageView iv1 = findViewById(R.id.imageView5);
        ImageView iv2= findViewById(R.id.imageView6);
        ImageView iv3= findViewById(R.id.imageView7);
        ImageView iv4 = findViewById(R.id.imageView8);
        ImageView iv5 = findViewById(R.id.imageView9);
        Button btn = findViewById(R.id.button7);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini=new Intent(SellerHome.this,Details.class);
                startActivity(ini);
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini=new Intent(SellerHome.this,Details.class);
                startActivity(ini);
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini=new Intent(SellerHome.this,Details.class);
                startActivity(ini);
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini=new Intent(SellerHome.this,Details.class);
                startActivity(ini);
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini=new Intent(SellerHome.this,Details.class);
                startActivity(ini);
            }
        });
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini=new Intent(SellerHome.this,Details.class);
                startActivity(ini);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini=new Intent(SellerHome.this,Login.class);
                startActivity(ini);
            }
        });

    }
}
