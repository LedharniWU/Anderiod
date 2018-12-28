package com.example.guest.cm0104.android108;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button resetBtn;
    private TextView txtMassage;
    private ImageView img;

    private int nowStare = 0;
    private int bakudan1 = 0;
    private int bakudan2 = 0;
    private int curia = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //宣言
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        resetBtn = (Button)findViewById(R.id.resetBtn);
        txtMassage = (TextView)findViewById(R.id.txtMassage);
        img = (ImageView)findViewById(R.id.imgDynamite);
        Random random = new Random();

        //setOnClick
        btn1.setOnClickListener(new BtnClickEvent());
        btn2.setOnClickListener(new BtnClickEvent());
        btn3.setOnClickListener(new BtnClickEvent());
        btn4.setOnClickListener(new BtnClickEvent());
        btn5.setOnClickListener(new BtnClickEvent());
        btn6.setOnClickListener(new BtnClickEvent());
        btn7.setOnClickListener(new BtnClickEvent());
        btn8.setOnClickListener(new BtnClickEvent());
        btn9.setOnClickListener(new BtnClickEvent());

        //処理
        resetBtn.setEnabled(false);

        bakudan1 = random.nextInt(9)+1;
        bakudan2 = random.nextInt(9)+1;

        if(bakudan1 == bakudan2){
            bakudan2 = random.nextInt(9);
        }

        Toast.makeText(MainActivity.this,String.valueOf(bakudan1),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,String.valueOf(bakudan2),Toast.LENGTH_SHORT).show();

    }

    class BtnClickEvent implements View.OnClickListener{

        @Override
        public void onClick(View v) {


            Button btn = (Button)v;

            if(btn.getText().toString().equals(String.valueOf(bakudan1))){
                curia--;
                nowStare++;
            }
            if(btn.getText().toString().equals(String.valueOf(bakudan2))){
                curia--;
                nowStare++;
            }

            switch (nowStare){
                case 1 :
                    img.setImageResource(R.drawable.dynamite2);
                    break;
                case 2:
                    img.setImageResource(R.drawable.dynamite3);
                    btnSwitch(false);
                    txtMassage.setText("残念だ！再挑戦するか？");
                    resetBtn.setEnabled(true);
                    break;
            }
            btn.setEnabled(false);

            curia++;

            if(curia == 8 && nowStare != 2){
                btnSwitch(false);
                txtMassage.setText("クリア！！");
                resetBtn.setEnabled(true);
            }
        }
    }

    public void onClickAction(View view){
        nowStare = 0;
        curia = 1;
        img.setImageResource(R.drawable.dynamite1);
        btnSwitch(true);
        txtMassage.setText("どれか押してみよう！");
        resetBtn.setEnabled(false);

        Random random = new Random();
        bakudan1 = random.nextInt(9)+1;
        bakudan2 = random.nextInt(9)+1;

        if(bakudan1 == bakudan2){
            bakudan2 = random.nextInt(9);
        }

        Toast.makeText(MainActivity.this,String.valueOf(bakudan1),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,String.valueOf(bakudan2),Toast.LENGTH_SHORT).show();

    }


    public void btnSwitch(boolean b){
        if(b == true) {
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
        }else {
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
        }
    }

}
