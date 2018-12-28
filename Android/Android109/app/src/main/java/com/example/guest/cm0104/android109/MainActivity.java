package com.example.guest.cm0104.android109;

import android.content.Context;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView txtMemoList;
    EditText edtMemo;
    Button btnAdd;
    Button btnSave;
    Button btnLoad;
    SharedPreferences sp;
    SharedPreferences.Editor edtr;
    String memo;
    String newMemo;
    String oldMemo;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMemo = (EditText) findViewById(R.id.edtMemo);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        txtMemoList = (TextView) findViewById(R.id.txtMemoList);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnSave.setOnClickListener(new SaveClickListenerImple());
        btnLoad.setOnClickListener(new LoadClickListenerImple());
        btnAdd.setOnClickListener(new AddClickListenerImple());

        sp = getSharedPreferences("android109", Context.MODE_PRIVATE);
        memo = sp.getString("MEMO", "");
        txtMemoList.setText(memo);
        list = new ArrayList<String>();

    }

    class SaveClickListenerImple implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            edtr = sp.edit();
            edtr.putString("MEMO",txtMemoList.getText().toString().replaceFirst("最終保存日時："+"[0-9]{4}"+"年"+"[0-9]{2}"+"月"+"[0-9]{2}"+"日",DateMemo())
                   );
            edtr.commit();

            Toast.makeText(MainActivity.this, "保存しました。", Toast.LENGTH_SHORT).show();

        }
    }

    class LoadClickListenerImple implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            sp = getSharedPreferences("android109", Context.MODE_PRIVATE);
            memo = sp.getString("MEMO", "");
            txtMemoList.setText(memo);

        }
    }

    class AddClickListenerImple implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            newMemo = edtMemo.getText().toString();
            oldMemo = txtMemoList.getText().toString();

            txtMemoList.setText(oldMemo + "\n・" + newMemo);
            edtMemo.setText("");

        }
    }

    private String DateMemo() {

        Calendar rightNow = Calendar.getInstance();
        String data = rightNow.get(Calendar.YEAR) + "年"+ (rightNow.get(Calendar.MONTH)+1) + "月" + rightNow.get(Calendar.DAY_OF_MONTH) + "日";

        return "最終保存日時：" + data;
    }

    private void saveArrayList(){}
}
