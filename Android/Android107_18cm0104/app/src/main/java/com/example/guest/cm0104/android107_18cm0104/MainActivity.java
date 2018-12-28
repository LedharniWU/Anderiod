package com.example.guest.cm0104.android107_18cm0104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //宣言
    private TextView txtNorth;
    private TextView txtSouth;
    private TextView txtWest;
    private TextView txtEast;
    private TextView heroHp;
    private TextView enemyHp;
    int heroHeal;
    int enemyHeal;
    TextView mag;
    GetQuestion question;
    int nowNo;
    Question que;
    int kill;
    int ran;
    TextView massage;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    //宣言

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nowNo = 0;
        heroHeal = 20;
        enemyHeal = 20;
        kill = 0;
        txtNorth = (TextView)findViewById(R.id.txtUp);
        txtSouth = (TextView)findViewById(R.id.txtRight);
        txtWest = (TextView)findViewById(R.id.txtLeft);
        txtEast = (TextView)findViewById(R.id.txtDown);
        heroHp = (TextView)findViewById(R.id.heroHpTxt);
        enemyHp = (TextView)findViewById(R.id.enemyHptxt);
        mag = (TextView)findViewById(R.id.txtMassage);
        massage = (TextView)findViewById(R.id.txtMassage);
        que = new Question();
        question = new GetQuestion(txtNorth,txtSouth,txtWest,txtEast,nowNo,que.qusestion());
        ran = (int)(Math.random() * que.qusestion().size());

        //Button
        btn1 = (Button)findViewById(R.id.btnAnsw1);
        btn2 = (Button)findViewById(R.id.btnAnsw2);
        btn3 = (Button)findViewById(R.id.btnAnsw3);
        btn4 = (Button)findViewById(R.id.btnAnsw4);
        getRanNum(btn1,que);
        getRanNum(btn2,que);
        getRanNum(btn3,que);
        getRanNum(btn4,que);
        btn1.setOnClickListener(new onClick());
        btn2.setOnClickListener(new onClick());
        btn3.setOnClickListener(new onClick());
        btn4.setOnClickListener(new onClick());

        heroHp.setText(String.valueOf(heroHeal) + "/ 20");
        enemyHp.setText(String.valueOf(enemyHeal) + "/ 20");
    }

    class onClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            if(btn.getText().toString().equals(question.getAnswer(nowNo,que.qusestion()))){
                //正解
                clickAction();
                if(enemyHeal > 0){
                    enemyHeal--;
                    enemyHp.setText(String.valueOf(enemyHeal) + "/ 20");
                }else {
                    enemyHeal = 20;
                    kill++;
                    enemyHp.setText(String.valueOf(enemyHeal) + "/ 20");
                    massage.setText("モンスター" + kill + "一匹を倒した。");
                }
            }else{
                //不正解
                clickAction();
                if(heroHeal > 0) {
                    heroHeal--;
                    heroHp.setText(String.valueOf(heroHeal) + "/ 20");
                }else{
                    finish();
                }
            }

        }
    }

    public void getRanNum(Button btn,Question que){
        int i = (int)(Math.random() * que.qusestion().size());
        btn.setText(question.getAnswer(i,que.qusestion()));
    }

    public void clickAction(){
        nowNo++;
        question = new GetQuestion(txtNorth,txtSouth,txtWest,txtEast,nowNo,que.qusestion());
        question.getAnswer(nowNo,que.qusestion());
        getRanNum(btn1,que);
        getRanNum(btn2,que);
        getRanNum(btn3,que);
        getRanNum(btn4,que);
    }
}
