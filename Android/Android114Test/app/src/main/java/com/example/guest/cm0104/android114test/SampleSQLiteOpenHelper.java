package com.example.guest.cm0104.android114test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by guest on 2018/12/18.
 */

public class SampleSQLiteOpenHelper extends SQLiteOpenHelper {

    public SampleSQLiteOpenHelper(Context context){
        super(context, "SAMPLE_DB",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SAMPLE_TABLE(_id INTEGER,name TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

