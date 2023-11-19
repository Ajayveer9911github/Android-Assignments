package com.example.q18;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context context) {
        super(context, "COLLEGE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE COMPANIES (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, ADDRESS TEXT, PHNO TEXT)";
        db.execSQL(query);
    }

    public Boolean addCompany(String name, String address, String phno){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("ADDRESS", address);
        values.put("PHNO", phno);
        long res = db.insert("COMPANIES",null, values);
        return res != -1;
    }

    public Cursor showCompany(){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM COMPANIES",null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String str = "DROP TABLE IF EXISTS COMPANIES";
        db.execSQL(str);
    }
}
