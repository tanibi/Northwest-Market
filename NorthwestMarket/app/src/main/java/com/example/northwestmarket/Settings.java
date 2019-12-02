package com.example.northwestmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Settings extends AppCompatActivity {
    private FirebaseUser user;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        String useremail= user.getEmail().toString();

        EditText et= findViewById(R.id.editText23);
        et.setText(useremail);

        et1 = findViewById(R.id.editText24);
        et2 = findViewById(R.id.editText25);
        String newp= et1.getText().toString();
        String conp= et2.getText().toString();
        Button btn = findViewById(R.id.button22);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changePassword();
            }
        });

    }
    public void changePassword(){
        et1=findViewById(R.id.editText24);
        et2=findViewById(R.id.editText25);
        String newpassword = et1.getText().toString();
        String confirmpass = et2.getText().toString();
        Log.d("check",newpassword);
        Log.d("check",confirmpass);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        user.updatePassword(newpassword).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Settings.this, "Password updated", Toast.LENGTH_SHORT).show();
                    Log.d("success","password updated");
                    Intent i = new Intent(Settings.this, Login.class);
                    startActivity(i);

                } else {
                    Toast.makeText(Settings.this, "Password not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
