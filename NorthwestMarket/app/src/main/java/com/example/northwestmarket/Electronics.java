package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

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
    }
}
