package com.example.northwestmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Container extends AppCompatActivity {

    private String itemID;
    private String itemName;
    private double cost;
    private String description;
    private String category;
    private String documentId;
    private String imageURL;
    private String contactinfo;

    public Container(String itemID, String itemName, double cost, String description, String category, String documentId, String imageURL,String contactinfo) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.cost = cost;
        this.description = description;
        this.category = category;
        this.documentId = documentId;
        this.imageURL = imageURL;
        this.contactinfo = contactinfo;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getContactinfo() {
        return contactinfo;
    }
}