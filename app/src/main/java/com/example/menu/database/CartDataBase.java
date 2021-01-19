package com.example.menu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class CartDataBase extends SQLiteOpenHelper {
    public static final String DB_NAME="cart";
    public static final int DB_VERSION=2;
    public static final String TABLE_NAME="cartMeal";
    public static final String CART_CLN_NAME="MealName";
    public static final String CART_CLN_COUNT="NumberMeal";
    public static final String CART_CLN_PRICE="Price";
    public static final String CART_CLN_IMAGE="Image";

    public CartDataBase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+CART_CLN_NAME+" TEXT NOT NULL,"+CART_CLN_COUNT+" INTEGER,"+CART_CLN_PRICE+" REAL NOT NULL,"+CART_CLN_IMAGE+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertAccount(CartMeal cartMeal){
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CART_CLN_NAME,cartMeal.getName_Meal());
        values.put(CART_CLN_COUNT,cartMeal.getCount());
        values.put(CART_CLN_PRICE,cartMeal.getPrice());
        values.put(CART_CLN_IMAGE,cartMeal.getImg_meal());
        Log.i("mmm",cartMeal.getName_Meal());
        Log.i("mmm", String.valueOf(cartMeal.getPrice()));
        Log.i("mmm", String.valueOf(cartMeal.getImg_meal()));
        long result= DB.insert(TABLE_NAME,null,values);

        return result !=-1;
    }
    public ArrayList<CartMeal>getAllCarts(){
        ArrayList<CartMeal> cartMeals =new ArrayList<>();
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        if(cursor.moveToFirst()){
            do {
                String name_meal = cursor.getString(0);
                int count = cursor.getInt(1);
                double price = cursor.getDouble(2);
                int img = cursor.getInt(3);

                CartMeal cartMeal =new CartMeal(name_meal,count,price,img);
                cartMeals.add(cartMeal);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return  cartMeals;
    }
}
