package com.inducesmile.androidsearchfunctionality;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBObject {
    private static DatabaseConfig dbHelper;
    private SQLiteDatabase db;
    public DBObject(Context context) {
        dbHelper = new DatabaseConfig(context);
        this.db = dbHelper.getReadableDatabase();
    }
    public SQLiteDatabase getDbConnection(){
        return this.db;
    }
    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }
}
