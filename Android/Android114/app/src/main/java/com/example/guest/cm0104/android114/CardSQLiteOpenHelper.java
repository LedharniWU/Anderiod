package com.example.guest.cm0104.android114;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by guest on 2019/01/08.
 */

public class CardSQLiteOpenHelper extends SQLiteOpenHelper {
    public CardSQLiteOpenHelper(Context context) {
        super(context, "CARD_DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CARD(_id INTEGER PRIMARY KEY AUTOINCREMENT,english TEXT,japanese TEXT)");
        db.execSQL("INSERT INTO CARD VALUES(1,'apple','リンゴ')");
        db.execSQL("INSERT INTO CARD VALUES(2,'banana','バナナ')");
        db.execSQL("INSERT INTO CARD VALUES(3,'lemon','レモン')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

    public ArrayList<Card> getAllCard(){
        ArrayList<Card> ary = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        if(db == null) return null;
        try{
            String[] column = new String[]{"japanese","english","_id"};
            Cursor cur = db.query("CARD",column,null,null,null,null,null);
            while (cur.moveToNext()){
                Card tmp = new Card(cur.getString(0),cur.getString(1),cur.getInt(2));
                ary.add(tmp);
            }
            cur.close();
        }finally {
            db.close();
        }
        return ary;
    }
}
