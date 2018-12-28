package com.example.guest.cm0104.samplelistview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MemoActivity extends AppCompatActivity {

    TextView txtTitle;
    TextView txtMemo;
    TextView txtCal;
    EditText edt;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        //宣言
        txtTitle = (TextView)findViewById(R.id.txtT);
        txtMemo = (TextView)findViewById(R.id.txtMemo);
        txtCal = (TextView)findViewById(R.id.txtCal);
        edt = (EditText)findViewById(R.id.editMemoText);
        btn = (Button)findViewById(R.id.btnMemoInPut);

        //Intent
        Intent intent = getIntent();
        //Title set
        String message = intent.getStringExtra("Memo");
        txtTitle.setText(message);

        //Button set
        btn.setOnClickListener(new onClickAction());

        //Loading
        String memo = loadString(MemoActivity.this,txtTitle.getText().toString());
        txtMemo.setText(memo);
        String date = loadString(MemoActivity.this,txtTitle.getText().toString()+"date");
        txtCal.setText(date);
    }

    class onClickAction implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(!(edt.getText().toString().equals(""))) {
                String newStr = edt.getText().toString();
                String oldStr = txtMemo.getText().toString();
                txtMemo.setText(oldStr + "\n・" + newStr);
                txtCal.setText(dateMemo());
                saveString(MemoActivity.this,txtTitle.getText().toString(),txtMemo.getText().toString());
                saveString(MemoActivity.this,txtTitle.getText().toString()+"date",txtCal.getText().toString());
                edt.setText("");
            }else{

            }
        }
    }

    // 設定値 String を保存
    public static void saveString(Context ctx, String key, String val) {
        SharedPreferences prefs = ctx.getSharedPreferences("SampleListView", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, val);
        editor.apply();
    }

    // 設定値 String を取得
    public static String loadString(Context ctx, String key) {
        SharedPreferences prefs = ctx.getSharedPreferences("SampleListView", Context.MODE_PRIVATE);
        return prefs.getString(key, ""); // 第２引数はkeyが存在しない時に返す初期値
    }

    private String dateMemo() {

        Calendar rightNow = Calendar.getInstance();
        String data = rightNow.get(Calendar.YEAR) + "年"+ (rightNow.get(Calendar.MONTH)+1) + "月" + rightNow.get(Calendar.DAY_OF_MONTH) + "日";

        return data + "更新";
    }


}
