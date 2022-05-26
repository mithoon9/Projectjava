package com.example.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DBhelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME="user.db";
    private static  final String TABLE_NAME="record";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_ADDRESS = "ADDRESS";
    private static final String COL_EMAIL = "EMAIL";
    private static final String COL_PASSWORD = "PASSWORD";
    private static final String COL_PHONE = "PHONE";



    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ADDRESS TEXT, EMAIL TEXT, PASSWORD TEXT,PHONE TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String address, String email, String password, String phone) {
        // query to insert data into database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_NAME, name);
        values.put(COL_ADDRESS, address);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);
        values.put(COL_PHONE, phone);


        long result =  db.insert(TABLE_NAME, null , values);

        if (result == -1) {
            // error inserting value
            return false;
        } else {
            // value successfully inserted
            return true;
        }
    }
    public boolean getdata(String email,String password){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cur=db.rawQuery("SELECT * FROM "+ TABLE_NAME + " WHERE " + TABLE_NAME + "." + COL_EMAIL + " = "+ "email" + " AND "
                + TABLE_NAME + "." + COL_PASSWORD + " = "+ "password"  ,null);
        int count = cur.getCount();
        if(count>0)
        {
            return true;
        }
        return false;
    }


}
