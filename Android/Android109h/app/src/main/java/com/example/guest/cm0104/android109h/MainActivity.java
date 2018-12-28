package com.example.guest.cm0104.android109h;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtCounter;
    TextView txtEnter;
    TextView txtJudge;
    Button checkBtn;
    Button giveUpBtn;
    String numString;
    Button btnSet;
    int[] numList;
    int answerInt;
    int enterInt;
    int[] makeAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtCounter = (TextView)findViewById(R.id.txtCounter);
        txtEnter = (TextView)findViewById(R.id.txtEnter);
        txtJudge = (TextView)findViewById(R.id.txtJudge);

        //Button 宣言
        int[] numId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnClr};
        for (int i = 0; i < numId.length; i++) {
            btnSet = (Button) findViewById(Integer.valueOf(numId[i]));
            btnSet.setOnClickListener(new NumberClickListenerImple());
        }
        checkBtn = (Button)findViewById(R.id.btnCheck);
        giveUpBtn = (Button)findViewById(R.id.btnGiveUp);
        //Button 宣言

        //初期化
        makeAnswer = makeAnswer();
        Toast.makeText(MainActivity.this, String.valueOf(makeAnswer[0])+String.valueOf(makeAnswer[1])+String.valueOf(makeAnswer[2])+String.valueOf(makeAnswer[3]),Toast.LENGTH_SHORT).show();
        numString = "";
        answerInt = 0;
        enterInt = 0;
    }

    class NumberClickListenerImple implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Button btn = (Button)v;
            String value = btn.getText().toString();

            switch (value){
                case "CLR":
                    numString = "";
                    txtEnter.setText("XXXX");
                    answerInt = 0;
                    enterInt = 0;
                    buttonOpen();
                    break;
                default:
                    if(numString.length() < 4){
                        numString += value;
                        txtEnter.setText(numString);
                        btn.setEnabled(false);
                    }
                    break;
            }
        }
    }

    public void checkAction(View view){



    }

    public void buttonOpen(){
        int[] numId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0, R.id.btnClr};
        for (int i = 0; i < numId.length; i++) {
            btnSet = (Button) findViewById(Integer.valueOf(numId[i]));
            btnSet.setEnabled(true);
        }
    }

    public void giveUpAction(View view){
        finish();
    }

    private int[] makeAnswer(){
        int[] result = new int[4];
        int[] numArray = {0,1,2,3,4,5,6,7,8,9};
        int bottom = numArray.length;
        for(int i = 0;i<result.length;i++){
            int sel = (int)(Math.random()*bottom);
            result[i] = numArray[sel];
            numArray[sel] = numArray[--bottom];
        }
        return result;
    }
}
