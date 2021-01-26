package com.example.menu.database;

// to add drink object when bought it
public class CartDrink {
    String Name_Drink;
    double price;
    int count;
    int Img_Drink;
    public CartDrink(String name_Drink,int count ,double price, int img_Drink) {
        Name_Drink = name_Drink;
        this.price = price;
        this.count = count;
        Img_Drink = img_Drink;
    }

    public String getName_Drink() {
        return Name_Drink;
    }

    public void setName_Drink(String name_Drink) {
        Name_Drink = name_Drink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getImg_Drink() {
        return Img_Drink;
    }

    public void setImg_Drink(int img_Drink) {
        Img_Drink = img_Drink;
    }
}
