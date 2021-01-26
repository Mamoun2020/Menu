package com.example.menu.database;

// to add meals object when bought it
public class CartMeal {
    String name_Meal;
    int count;
    double price;
    int img_meal;

    public CartMeal(String name_Meal, int count, double price, int img_meal) {
        this.name_Meal = name_Meal;
        this.count = count;
        this.price = price;
        this.img_meal = img_meal;
    }


    public String getName_Meal() {
        return name_Meal;
    }

    public void setName_Meal(String name_Meal) {
        this.name_Meal = name_Meal;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImg_meal() {
        return img_meal;
    }

    public void setImg_meal(int img_meal) {
        this.img_meal = img_meal;
    }
}
