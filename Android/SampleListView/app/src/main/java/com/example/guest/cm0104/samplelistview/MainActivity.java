package com.example.guest.cm0104.samplelistview;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button btnTitle;
    ListView listView;
    TitleAdapter adapter;

    ArrayList<String> countries = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //宣言
        editText = (EditText)findViewById(R.id.titleEdit);
        btnTitle = (Button)findViewById(R.id.btnTitleInput);
        //listView set
        listView = (ListView)findViewById(R.id.listView);

        //Button
        btnTitle.setOnClickListener(new onCilckAction());

        //Load
        countries = loadList(MainActivity.this,"title");
        adapter = new TitleAdapter(getApplicationContext(),R.layout.title_list_layout,countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new onItemClick());
    }

    class onCilckAction implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(!(editText.getText().toString().equals(""))) {
                String str = editText.getText().toString();
                countries.add(str);
                editText.setText("");
                saveList(MainActivity.this, "title", countries);
                listView.setAdapter(adapter);
                // listView.deferNotifyDataSetChanged();
            }
            //itemClick
            listView.setOnItemClickListener(new onItemClick());
        }
    }

    // 設定値 ArrayList<String> を保存
    public static void saveList(Context ctx, String key, ArrayList<String> list) {
        JSONArray jsonAry = new JSONArray();
        for(int i=0; i<list.size(); i++) {
            jsonAry.put(list.get(i));
        }
        SharedPreferences prefs = ctx.getSharedPreferences("SampleListView", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, jsonAry.toString());
        editor.apply();
    }

    // 設定値 ArrayList<String> を取得
    public static ArrayList<String> loadList(Context ctx, String key) {
        ArrayList<String> list = new ArrayList<String>();
        SharedPreferences prefs = ctx.getSharedPreferences("SampleListView", Context.MODE_PRIVATE);
        String strJson = prefs.getString(key, ""); // 第２引数はkeyが存在しない時に返す初期値
        if(!strJson.equals("")) {
            try {
                JSONArray jsonAry = new JSONArray(strJson);
                for(int i=0; i<jsonAry.length(); i++) {
                    list.add(jsonAry.getString(i));
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
    //onItemClick
    class onItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (view.getId()) {
                case R.id.btnEDIT:
                    Intent intent = new Intent(MainActivity.this, MemoActivity.class);
                    intent.putExtra("Memo",countries.get(position));
                    startActivity(intent);
                    // Toast.makeText(MainActivity.this, countries.get(position) + "の編集ボタンが押されました", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnDelete:
                    countries.remove(position);
                    saveList(MainActivity.this,"title",countries);
                    listView.setAdapter(adapter);
                    // Toast.makeText(MainActivity.this, countries.get(position) + "の削除ボタンが押されました", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}

