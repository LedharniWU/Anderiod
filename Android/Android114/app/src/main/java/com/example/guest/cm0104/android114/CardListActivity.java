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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CardListActivity extends ListActivity {

    CardSQLiteOpenHelper helper;
    private ArrayList<String> ary = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        helper = new CardSQLiteOpenHelper(this);
        helper.getAllCardTitle(ary);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ary);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, final int position, long id) {

        String eng = ((TextView) v).getText().toString();
        Card tmp = helper.findCardByName(eng);

        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("mode", "update");
        intent.putExtra("id", tmp.getId());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CardSQLiteOpenHelper helper = new CardSQLiteOpenHelper(this);
        helper.getAllCardTitle(ary);
        ((ArrayAdapter<String>)getListAdapter()).notifyDataSetChanged();
    }
}