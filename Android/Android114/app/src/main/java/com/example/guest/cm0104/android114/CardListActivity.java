package com.example.guest.cm0104.android114;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CardListActivity extends ListActivity{

    CardSQLiteOpenHelper helper;
    private ArrayList<String> ary = new ArrayList<>() ;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        helper = new CardSQLiteOpenHelper(this);
        helper.getAllCardTitle(ary);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ary);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, final int position, long id) {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // AlertDialogのタイトル設定します

        alertDialogBuilder.setTitle("削除");

        // AlertDialogのメッセージ設定
        alertDialogBuilder.setMessage("本当に削除しますか？");

        // AlertDialogのYesボタンのコールバックリスナーを登録
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        helper.deleteCardById(Integer.valueOf(helper.getAllCardId().get(position)));
                        helper.getAllCardTitle(ary);
                        adapter = new ArrayAdapter<String>(CardListActivity.this,android.R.layout.simple_list_item_1,ary);
                        setListAdapter(adapter);

                    }
                });
        // AlertDialogのNoボタンのコールバックリスナーを登録
        alertDialogBuilder.setNeutralButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        // AlertDialogのキャンセルができるように設定
        alertDialogBuilder.setCancelable(true);

        AlertDialog alertDialog = alertDialogBuilder.create();
        // AlertDialogの表示
        alertDialog.show();
    }
}
