package com.example.northwestmarket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ClothingProductsAdapter extends RecyclerView.Adapter<ClothingProductsAdapter.ItemsViewHolder> {
    private ArrayList<Container> itemListArray;
    private Context context;

    public ClothingProductsAdapter(ArrayList<Container> itemListArray, Context context) {
        this.itemListArray = itemListArray;
        this.context = context;
    }
    public static class ItemsViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView productName;
        public TextView cost;


        public LinearLayout linearLayout2;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.imageIV);
            productName = itemView.findViewById(R.id.iNameTV);
            cost = itemView.findViewById(R.id.priceTV);

            linearLayout2 = itemView.findViewById(R.id.linearLayout2);
        }
    }
    @NonNull
    @Override
    public ClothingProductsAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_container, viewGroup, false);
        ClothingProductsAdapter.ItemsViewHolder itemsVH = new ClothingProductsAdapter.ItemsViewHolder(v);
        return itemsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull final ClothingProductsAdapter.ItemsViewHolder itemsViewHolder, final int i) {

        final Container currentItem = itemListArray.get(i);

        //itemsViewHolder.itemImage.setImageResource(currentItem.getImage());
        Picasso.get().load(currentItem.getImageURL()).into(itemsViewHolder.productImage);
        itemsViewHolder.productName.setText(currentItem.getItemName());
        itemsViewHolder.cost.setText("Buying price :$" + currentItem.getCost());

        itemsViewHolder.linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Item_Details.class);
                intent.putExtra("imageURL", currentItem.getImageURL());
                intent.putExtra("documentId", currentItem.getDocumentId());
                intent.putExtra("description", currentItem.getDescription());
                intent.putExtra("itemId", currentItem.getItemID());
                intent.putExtra("category", currentItem.getCategory());
                intent.putExtra("itemName", currentItem.getItemName());
                intent.putExtra("unitPrice", currentItem.getCost());
                intent.putExtra("contactinfo",currentItem.getContactinfo());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemListArray.size();
    }


}
