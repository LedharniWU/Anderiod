package com.example.guest.cm0104.android107;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> ary;
    private int nowNo;
    private int yesAns;
    private int noAns;
    private int key;
    private TextView txtNorth;
    private TextView txtSouth;
    private TextView txtWest;
    private TextView txtEast;
    private TextView endTxt;
    private String answer = "対";
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ary = new ArrayList<String>();
        nowNo = 0;
        yesAns = 0;
        noAns = 0;
        key = 0;


        ary.add("会計計算総計計量");
        ary.add("会釈釈明解釈釈然");
        ary.add("地峡峡谷山峡峡湾");
        ary.add("変装装束外装装着");
        ary.add("徴募募兵公募募金");
        ary.add("七八八日尺八八九");
        ary.add("英語語別言語語学");

        endTxt = (TextView)findViewById(R.id.endTxt);
        txtNorth = (TextView)findViewById(R.id.txtUp);
        txtSouth = (TextView)findViewById(R.id.txtRight);
        txtWest = (TextView)findViewById(R.id.txtLeft);
        txtEast = (TextView)findViewById(R.id.txtDown);
        edt = (EditText)findViewById(R.id.edtAnswer);
    }


    public void onCheckAction(View view){
        Button btn = (Button)findViewById(R.id.comBtn);

        String enter = edt.getText().toString();

        if(!enter.equals("")) {
            if (answer.equals(enter)) {
                getAnswer();
                endTxt.setText("正解！");
                yesAns++;
            } else {
                getAnswer();
                endTxt.setText("不正解！");
                noAns++;
            }
        }else{
            Toast.makeText(this,"回答を入力してください",Toast.LENGTH_SHORT).show();
        }

        if(ary.size() < nowNo){
            endTxt.setText(nowNo+"問、"+yesAns+"問正解,すごい！漢字博士か?!");
            Toast.makeText(this,"おつかれさまでした",Toast.LENGTH_SHORT).show();
            btn.setEnabled(false);
        }
    }

    public void giveUpAction(View view){

        key++;
        Toast.makeText(this,"ゲーム終了です。",Toast.LENGTH_SHORT).show();
        if(nowNo == yesAns){
            endTxt.setText(nowNo+"問、"+yesAns+"問正解,すごい！漢字博士か?!");
        }else{
            endTxt.setText(nowNo+"問、"+yesAns+"問正解、"+noAns+"問不正解"+",満点まで頑張って！");
        }

        if(key == 2){
            finish();
        }

    }


    public void getAnswer(){

        if(ary.size() > nowNo) {
            txtNorth.setText(ary.get(nowNo).substring(0, 1));
            txtSouth.setText(ary.get(nowNo).substring(3, 4));
            txtWest.setText(ary.get(nowNo).substring(4, 5));
            txtEast.setText(ary.get(nowNo).substring(7, 8));
            answer = ary.get(nowNo).substring(1, 2);
        }
        edt.setText("");
        nowNo++;

    }
}
