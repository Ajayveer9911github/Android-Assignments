package com.example.q7db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.BlackLevelPattern;

public class DBHandler extends SQLiteOpenHelper {


    private String name;
    private String mobile;

    public DBHandler(Context context) {
        super(context, "COLLEGE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE STUDENT (SID INTEGER PRIMARY KEY "
                + "AUTOINCREMENT, NAME TEXT, MOBILE TEXT)";

        db.execSQL(query);
    }

    public Boolean addStudent(String name, String mobile){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("NAME", name);
        values.put("MOBILE", mobile);

        Long result = db.insert("STUDENT",null, values);
        db.close();
        if  (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean delStudent(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete("STUDENT","NAME='"+name+"'", null);

        if  (result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor ShowData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM STUDENT",null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
    }

}
