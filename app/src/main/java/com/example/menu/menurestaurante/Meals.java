package com.example.menu.menurestaurante;

public class Meals {
    String Name_Meal;
    String components;
    double price;
    int img_meal;
    int count;

    public Meals(String name_Meal, String components, double price, int img_meal,int count) {
        Name_Meal = name_Meal;
        this.components = components;
        this.price = price;
        this.img_meal = img_meal;
        this.count=count;
    }

    public Meals() {

    }

    public String getName_Meal() {
        return Name_Meal;
    }

    public void setName_Meal(String name_Meal) {
        Name_Meal = name_Meal;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
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
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
