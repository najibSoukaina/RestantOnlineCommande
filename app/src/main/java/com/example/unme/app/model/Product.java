package com.example.unme.app.model;

public class Product {
    private String designation;
    private String description;
    private int image;
    private String category;
    private float price;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product(String designation, String description, int image, String category, float price) {
        this.designation = designation;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category=category;
    }

    public Product() {
        super();
    }

    public String getDesignation() {
        
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
