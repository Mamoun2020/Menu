package com.example.menu.menurestaurante;

// // to add item tab object in main tap to tab layout
public class ItemTab {
    private  int id_item;
    private  String name_item;
    private  int icon_item;

    public ItemTab(int id_item, String name_item, int icon_item) {
        this.id_item = id_item;
        this.name_item = name_item;
        this.icon_item = icon_item;
    }

    public ItemTab() {

    }


    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getName_item() {
        return name_item;
    }

    public void setName_item(String name_item) {
        this.name_item = name_item;
    }

    public int getIcon_item() {
        return icon_item;
    }

    public void setIcon_item(int icon_item) {
        this.icon_item = icon_item;
    }
}
