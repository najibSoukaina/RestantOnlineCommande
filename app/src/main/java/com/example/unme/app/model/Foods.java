package com.example.unme.app.model;

public class Foods {
    //variables
    private int id;
    private String desination;
    private float price;
    private int image;

    //const sans param
    public Foods() {
    }

    //const avec param
    public Foods(int id, String desination, float price, int image) {
        this.id=id;
        this.desination = desination;
        this.price=price;
        this.image =image;
    }
    public Foods(String desination,int image) {
        this.desination = desination;
        this.image =image;
    }
    public Foods(String desination) {
        this.desination = desination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesination() {
        return desination;
    }

    public void setDesination(String desination) {
        this.desination = desination;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString(){
        return getDesination() +" : "+ getPrice()+" DH";
    }
}
