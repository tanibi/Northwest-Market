package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class Item_Details extends AppCompatActivity {
    private ImageView imageIV;
    private TextView itemNameTV, priceTV, detailsTV,contact;
    private FirebaseFirestore db;
    private String imageURL,docId;
    private DocumentReference itemRef;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__details);
        contact = findViewById(R.id.detailsTV2);
        imageIV = findViewById(R.id.imageIV);
        itemNameTV = findViewById(R.id.itemNameTV);

        priceTV = findViewById(R.id.priceTV);
        detailsTV = findViewById(R.id.detailsTV);
        db = FirebaseFirestore.getInstance();
//      Get data from the Intent
        Intent i = getIntent();
        docId = i.getStringExtra("documentId");
        imageURL = i.getStringExtra("imageURL");
        //imageIV.setImageResource(i.getIntExtra("image",0));
        Picasso.get().load(imageURL).into(imageIV);
        itemNameTV.setText(i.getStringExtra("itemName"));
        priceTV.setText("Buying price :$" + i.getDoubleExtra("unitPrice",0));
        contact.setText(i.getStringExtra("contactinfo"));

//        Get an instance of the items
        itemRef = db.collection("products").document(docId);
        itemRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                detailsTV.setText(documentSnapshot.get("itemDetails").toString());
            }
        });
    }
}
