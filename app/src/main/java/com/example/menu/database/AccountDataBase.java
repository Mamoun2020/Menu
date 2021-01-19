package com.example.menu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class AccountDataBase extends SQLiteOpenHelper {
    public static final String DB_NAME="users";
    public static final int DB_VERSION=16;
    public static final String TABLE_NAME="account";
    public static final String USERS_CLN_NAME="UserName";
    public static final String USERS_CLN_PHONE="NumberPhone";
    public static final String USERS_CLN_PASSWORD="Password";
    public static final String USERS_CLN_ADDRESS="Address";

    public static final String TABLE_NAME_CART="cartMeal";
    public static final String CART_CLN_NAME="MealName";
    public static final String CART_CLN_COUNT="NumberMeal";
    public static final String CART_CLN_PRICE="Price";
    public static final String CART_CLN_IMAGE="Image";
    public AccountDataBase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+USERS_CLN_NAME+" TEXT PRIMARY KEY NOT NULL,"+USERS_CLN_PHONE+" TEXT,"+USERS_CLN_PASSWORD+" TEXT NOT NULL,"+USERS_CLN_ADDRESS+" TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_NAME_CART+" ("+CART_CLN_NAME+" TEXT NOT NULL,"+CART_CLN_COUNT+" INTEGER,"+CART_CLN_PRICE+" REAL NOT NULL,"+CART_CLN_IMAGE+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_CART);
        onCreate(db);
    }
    public boolean insertAccount(Account account){
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERS_CLN_NAME,account.getName());
        values.put(USERS_CLN_PHONE,account.getPhone());
        values.put(USERS_CLN_PASSWORD,account.getPassword());
        values.put(USERS_CLN_ADDRESS,account.getAddress());
        long result= DB.insert(TABLE_NAME,null,values);

        return result !=-1;
    }


    public boolean checkUserExist(String username, String password){
        SQLiteDatabase DB = getReadableDatabase();
        String[] columns = {USERS_CLN_NAME};
        String selection = "UserName=? AND Password=?";
        String[] selectionArgs = {username,password};
        Cursor cursor = DB.query(TABLE_NAME,columns,selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
    public boolean searchonUser(String username){
        SQLiteDatabase DB = getReadableDatabase();
        String[] columns = {USERS_CLN_NAME};
        String selection = "UserName=?";
        String[] selectionArgs = {username};
        Cursor cursor = DB.query(TABLE_NAME,columns,selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }
    public boolean updateAccount(String username, String password){
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERS_CLN_PASSWORD,password);
        String [] args = new String[]{username};
        int result= DB.update(TABLE_NAME,values,"UserName=?",args);

        return result > 0;
    }

    public boolean insertAccount(CartMeal cartMeal){
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CART_CLN_NAME,cartMeal.getName_Meal());
        values.put(CART_CLN_COUNT,cartMeal.getCount());
        values.put(CART_CLN_PRICE,cartMeal.getPrice());
        values.put(CART_CLN_IMAGE,cartMeal.getImg_meal());
        long result= DB.insert(TABLE_NAME_CART,null,values);

        return result !=-1;
    }
    public ArrayList<CartMeal>getAllCarts(){
        ArrayList<CartMeal> cartMeals =new ArrayList<>();
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM "+TABLE_NAME_CART,null);
        if(cursor.moveToFirst()){
            do {
                String name_meal = cursor.getString(cursor.getColumnIndex(CART_CLN_NAME));
                int count = cursor.getInt(cursor.getColumnIndex(CART_CLN_COUNT));
                double price = cursor.getDouble(cursor.getColumnIndex(CART_CLN_PRICE));
                int img = cursor.getInt(cursor.getColumnIndex(CART_CLN_IMAGE));

                CartMeal cartMeal =new CartMeal(name_meal,count,price,img);
                cartMeals.add(cartMeal);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return  cartMeals;
    }
}
