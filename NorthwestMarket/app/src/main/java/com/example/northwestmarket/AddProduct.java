package com.example.northwestmarket;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class AddProduct extends AppCompatActivity {
    private Spinner spinner;
    private static final String[] paths = {"clothing","sports","automobile","electronics","books","footwear"};
    private FirebaseFirestore db;
    private StorageReference storage, storg;
    private CollectionReference itemCollection;
    private DocumentReference itemDoc;
    private static final int PICK_IMG_REQUEST = 1;
    Button uploadbtn;
    private Uri imageURI;
    private Long imageName;
    private String imageURL;
    ImageView prodimage;
    String id,name,description, category,contact;
    Double cost;
    EditText productid,productname,productdes,productcost,contactinfo;
    Spinner productcate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        productid=findViewById(R.id.editText6);
        productname=findViewById(R.id.editText9);
        productdes=findViewById(R.id.editText12);
        productcate=findViewById(R.id.spinner);
        productcost=findViewById(R.id.editText13);
        contactinfo = findViewById(R.id.editText);
        prodimage=findViewById(R.id.imageView3);
        uploadbtn=findViewById(R.id.button13);

        Button addprod=findViewById(R.id.button12);
        Button cancel=findViewById(R.id.button14);


        storage = FirebaseStorage.getInstance().getReference("productimages");
        storg = FirebaseStorage.getInstance().getReference();
        db = FirebaseFirestore.getInstance();
        itemCollection = db.collection("products");

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        addprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id=productid.getText().toString();
                name=productname.getText().toString();
                description=productdes.getText().toString();
                category=productcate.getSelectedItem().toString();
                cost=Double.parseDouble(productcost.getText().toString());
                contact=contactinfo.getText().toString();

                if(id.equals("")||name.equals("")||description.equals("") || category.equals("") || imageURL.equals("") ||   cost<=0 || contact.equals("")){
                    Toast.makeText(AddProduct.this, "All the field needs to be filled ", Toast.LENGTH_SHORT).show();
                }
                else {
                    Map<String, Object> addproduct = new HashMap<>();
                    addproduct.put("itemId", id);
                    addproduct.put("itemName", name);
                    addproduct.put("itemDetails", description);
                    addproduct.put("category", category);
                    addproduct.put("cost", cost);
                    addproduct.put("imageURL", imageURL);
                    addproduct.put("contactinfo",contact);

                    itemCollection.document().set(addproduct);
                    Toast.makeText(AddProduct.this, "Item added to the list", Toast.LENGTH_SHORT).show();

                    finish();


                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(AddProduct.this,BuyorSell.class);
                startActivity(in);
            }
        });

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddProduct.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMG_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMG_REQUEST && resultCode == RESULT_OK
                && data !=null && data.getData()!=null){
            imageURI = data.getData();
            Log.d("clck", "inside onactivity");
            uploadImage();
        }

    }

    private String getFileExtension(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    private void uploadImage() {
        Log.d("clck", "inside uploadimage");
        if (imageURI != null) {
            imageName = System.currentTimeMillis();
            final StorageReference fileRef = storage.child(imageName + "." + getFileExtension(imageURI));
            fileRef.putFile(imageURI).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            imageURL = uri.toString();
                            Log.d("clck", "image inserted");
                            Picasso.get().load(imageURL).into(prodimage);
                            Log.d("clck", "image displayed");
                        }
                    });
                }
            });

        }
    }
}
