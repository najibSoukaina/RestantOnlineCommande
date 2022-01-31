package com.example.unme.app.model;

public class Menu {
    private int item_icon;
    private String item_text;

    public Menu(int item_icon, String item_text) {
        this.item_icon = item_icon;
        this.item_text = item_text;
    }

    public int getItem_icon() {
        return item_icon;
    }
    public String getItem_text() {
        return item_text;
    }

}
