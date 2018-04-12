package com.inducesmile.androidsearchfunctionality;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class DbBackend extends DBObject {
    public DbBackend(Context context) {
        super(context);
    }
    public List<SearchAdapter.ItemObject> searchDictionaryWords(String searchWord){
        List<SearchAdapter.ItemObject> mItems = new ArrayList<SearchAdapter.ItemObject>();
        String query = "Select * from dictionary where word like " + "'%" + searchWord + "%'";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> wordTerms = new ArrayList<String>();
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String word = cursor.getString(cursor.getColumnIndexOrThrow("word"));
                mItems.add(new SearchAdapter.ItemObject(id, word));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return mItems;
    }
}
