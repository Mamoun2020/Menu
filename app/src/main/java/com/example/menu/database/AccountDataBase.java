package com.example.menu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class AccountDataBase extends SQLiteOpenHelper {
    // DB NAME IS USERS
    public static final String DB_NAME="users";
    public static final int DB_VERSION=29;
    //this section of variables to users Accounts
    public static final String TABLE_NAME="account";
    public static final String USERS_CLN_NAME="UserName";
    public static final String USERS_CLN_PHONE="NumberPhone";
    public static final String USERS_CLN_PASSWORD="Password";
    public static final String USERS_CLN_ADDRESS="Address";
    //this section of variables to Shopping Meals
    public static final String TABLE_NAME_CART="CartShop";
    public static final String CART_CLN_NAME="Name";
    public static final String CART_CLN_COUNT="Count";
    public static final String CART_CLN_PRICE="Price";
    public static final String CART_CLN_IMAGE="Image";
    //this section of variables to Shopping Drinks
    public static final String TABLE_NAME_Drink="CartDrink";
    public static final String CART_CLN_NAME_DRINK="Name";
    public static final String CART_CLN_COUNT_DRINK="Count";
    public static final String CART_CLN_PRICE_DRINK="Price";
    public static final String CART_CLN_IMAGE_DRINK="Image";



    public AccountDataBase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    // create tables in (users) DB
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+USERS_CLN_NAME+" TEXT PRIMARY KEY NOT NULL,"+USERS_CLN_PHONE+" TEXT,"+USERS_CLN_PASSWORD+" TEXT NOT NULL,"+USERS_CLN_ADDRESS+" TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_NAME_CART+" ("+CART_CLN_NAME+" TEXT NOT NULL,"+CART_CLN_COUNT+" INTEGER,"+CART_CLN_PRICE+" REAL NOT NULL,"+CART_CLN_IMAGE+" TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_NAME_Drink+" ("+CART_CLN_NAME_DRINK+" TEXT NOT NULL,"+CART_CLN_COUNT_DRINK+" INTEGER,"+CART_CLN_PRICE_DRINK+" REAL NOT NULL,"+CART_CLN_IMAGE_DRINK+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_CART);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_Drink);
        onCreate(db);
    }
    // insert account from object Account class in the same package to DB in account table
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

     // check if user exist in account table to login
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
    // to search on user name in account table
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
    // update password of user by user name
    public boolean updateAccount(String username, String password){
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERS_CLN_PASSWORD,password);
        String [] args = new String[]{username};
        int result= DB.update(TABLE_NAME,values,"UserName=?",args);

        return result > 0;
    }


    //insert Meals shopping when click on meal to buy
    public boolean insertMeal(CartMeal cartMeal){
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CART_CLN_NAME,cartMeal.getName_Meal());
        values.put(CART_CLN_COUNT,cartMeal.getCount());
        values.put(CART_CLN_PRICE,cartMeal.getPrice());
        values.put(CART_CLN_IMAGE,cartMeal.getImg_meal());
        long result= DB.insert(TABLE_NAME_CART,null,values);

        return result !=-1;
    }
    //read Meals shopping in shopping list after click on buy button
    public ArrayList<CartMeal>getAllCarts(){
        ArrayList<CartMeal> cartMeals =new ArrayList<>();
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM "+TABLE_NAME_CART,null);
        if(cursor!=null&&cursor.moveToFirst()){
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

    //insert Drinks shopping in drink table when click on drink to buy
    public boolean insertDrink(CartDrink cartDrink){
        SQLiteDatabase DB = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CART_CLN_NAME_DRINK,cartDrink.getName_Drink());
        values.put(CART_CLN_COUNT_DRINK,cartDrink.getCount());
        values.put(CART_CLN_PRICE_DRINK,cartDrink.getPrice());
        values.put(CART_CLN_IMAGE_DRINK,cartDrink.getImg_Drink());
        long result= DB.insert(TABLE_NAME_Drink,null,values);

        return result !=-1;
    }
    //read drinks shopping in shopping list after click on buy button from drink table in DB
    public ArrayList<CartDrink>getAllDrink(){
        ArrayList<CartDrink> cartDrinks =new ArrayList<>();
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor=DB.rawQuery("SELECT * FROM "+TABLE_NAME_Drink,null);
        if(cursor!=null&&cursor.moveToFirst()){
            do {
                String name_drink = cursor.getString(cursor.getColumnIndex(CART_CLN_NAME_DRINK));
                int count = cursor.getInt(cursor.getColumnIndex(CART_CLN_COUNT_DRINK));
                double price = cursor.getDouble(cursor.getColumnIndex(CART_CLN_PRICE_DRINK));
                int img = cursor.getInt(cursor.getColumnIndex(CART_CLN_IMAGE_DRINK));

                CartDrink cartDrink =new CartDrink(name_drink,count,price,img);
                cartDrinks.add(cartDrink);
            }while(cursor.moveToNext());
            cursor.close();
        }
        return  cartDrinks;
    }
}
