package com.example.northwestmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Electronics extends AppCompatActivity {
    private RecyclerView productLV;
    private RecyclerView.Adapter productsAdapter;
    private RecyclerView.LayoutManager productLayoutManager;

    private FirebaseFirestore db;
    private StorageReference StorageRef;
    private CollectionReference productCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        db = FirebaseFirestore.getInstance();
        StorageRef = FirebaseStorage.getInstance().getReference().child("productimages");
        productCollection = db.collection("products");

        Intent i = getIntent();

        final ArrayList<Container> itemListArray = new ArrayList<>();

        productCollection.orderBy("itemId", Query.Direction.DESCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    int i = 0;
                    for (QueryDocumentSnapshot doc : task.getResult()) {

                        if (doc.getString("category").equals("electronics")) {
                            itemListArray.add(new Container(doc.getString("itemId"), doc.getString("itemName"), doc.getDouble("cost"), doc.getString("itemDetails"),
                                    doc.getString("category"), doc.getId(), doc.getString("imageURL"),doc.getString("contactinfo")));
                            i++;
                        }
                    }

                    productLV = findViewById(R.id.productsLV);
                    productLV.setHasFixedSize(true);
                    productLayoutManager = new LinearLayoutManager(Electronics.this);
                    productsAdapter = new ClothingProductsAdapter(itemListArray, Electronics.this);
                    productLV.setLayoutManager(productLayoutManager);
                    productLV.setAdapter(productsAdapter);
                }
            }
        });
    }
}
