package com.example.guest.cm0104.android114;

import android.content.ContentValues;
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

    public void getAllCardTitle(ArrayList<String> ary){
        ary.clear();
        SQLiteDatabase db = getReadableDatabase();
        if(db == null) return;
        try {
            Cursor cur = db.query("CARD",new String[]{"english"},null,null,null,null,null);
            while (cur.moveToNext()){
                ary.add(cur.getString(0));
            }
            cur.close();
        }finally {
            db.close();
        }
    }

    public ArrayList<String> getAllCardId(){
        ArrayList<String> ary = new ArrayList<String>();
        SQLiteDatabase db = getReadableDatabase();
        if(db == null) return null;
        try {
            Cursor cur = db.query("CARD",new String[]{"_id"},null,null,null,null,null);
            while (cur.moveToNext()){
                ary.add(cur.getString(0));
            }
            cur.close();
        }finally {
            db.close();
        }
        return ary;
    }



    public boolean insertCard(Card src){

        long ret = -1;

        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("japanese",src.getJapanese());
            values.put("english",src.getEnglish());

            ret = db.insert("CARD",null,values);
        }finally {
            db.close();
        }
        return ret != -1 ;
    }

    public void deleteCardById(int id){
        SQLiteDatabase db = getWritableDatabase();
        try {
            String sid = String.valueOf(id);
            db.delete("CARD","_id=?",new String[]{sid});
        }finally {
            db.close();
        }
    }
}
