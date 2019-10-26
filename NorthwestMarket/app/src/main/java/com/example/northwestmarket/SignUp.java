package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    EditText et, et1, et2, et3;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        et = findViewById(R.id.name);
        et1 = findViewById(R.id.enterEmail);
        et2 = findViewById(R.id.pWord);
        et3 = findViewById(R.id.rePass);
        btn = findViewById(R.id.createBTN);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick_createAccount();
            }
        });
    }

    public void onClick_createAccount() {
        String uname = et.getText().toString();
        String em = et1.getText().toString();
        String pw = et2.getText().toString();
        String repw = et3.getText().toString();


        //int phone = Integer.parseInt(phno.getText().toString());
        if ((TextUtils.isEmpty(uname)) && (TextUtils.isEmpty(em)) && (TextUtils.isEmpty(pw)) && (TextUtils.isEmpty(em))) {
            // Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show();
            et.setError("user Name should not be empty");
            et1.setError("Email should not be empty");
            et2.setError("Password should not be empty");
            et3.setError("Re-Password should not be empty");
        } else {
            if (TextUtils.isEmpty(uname)) {
                et.setError("user Name should not be empty");
                //Toast.makeText(this, "User Name should not be empty", Toast.LENGTH_LONG).show();

            } else if (TextUtils.isEmpty(em)) {
                et1.setError("Email should not be empty");
                //Toast.makeText(this, "Email should not be empty", Toast.LENGTH_LONG).show();

            } else if (!em.contains("@") || !em.contains(".")) {
                et1.setError("Enter a valid email address");
                //Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty(pw)) {
                et2.setError("Password should not be empty");
                // Toast.makeText(this, "Password should not be empty", Toast.LENGTH_LONG).show();

            } else if (TextUtils.isEmpty(repw)) {
                et3.setError("Re-Password should not be empty");
                // Toast.makeText(this, "Re-Password should not be empty", Toast.LENGTH_LONG).show();

            } else if (pw.length() < 6) {
                et2.setError("Password should have a minimum length of 6 characters");
                // Toast.makeText(this, "Password should have a minimum length of 8 characters", Toast.LENGTH_LONG).show();

            } else if (!(pw.equals(repw))) {
                et3.setError("Password and Confirm Passwords does not match");
                //Toast.makeText(this,"Password and Confirm Passwords does not match",Toast.LENGTH_LONG).show();

            } else if (!(pw.matches(repw))) {
                et2.setError("Password doesnot match");


            }
            else{
                Intent in = new Intent(this, Login.class);
                startActivity(in);
            }
        }
    }
            public void onClick_back (View v){
                Intent in = new Intent(this, StartPage.class);
                startActivity(in);
            }


}

