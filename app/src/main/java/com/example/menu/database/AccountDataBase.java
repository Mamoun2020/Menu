package com.example.menu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class AccountDataBase extends SQLiteOpenHelper {
    public static final String DB_NAME="users";
    public static final int DB_VERSION=15;
    public static final String TABLE_NAME="account";
    public static final String USERS_CLN_NAME="UserName";
    public static final String USERS_CLN_PHONE="NumberPhone";
    public static final String USERS_CLN_PASSWORD="Password";
    public static final String USERS_CLN_ADDRESS="Address";
    public AccountDataBase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+USERS_CLN_NAME+" TEXT PRIMARY KEY NOT NULL,"+USERS_CLN_PHONE+" TEXT,"+USERS_CLN_PASSWORD+" TEXT NOT NULL,"+USERS_CLN_ADDRESS+" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
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
}
