package com.example.guest.cm0104.android102;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int nowQuestionNo;
    private String quesrion;
    private int ans;
    private long time = 0;
    private int nowAnsmate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btnStop);
        btn.setEnabled(false);


    }

        public void onClickAction(View view) {
            Chronometer chronometer = (Chronometer)findViewById(R.id.chrono);
            Button btnS = (Button)findViewById(R.id.btnStart);
            Button btn = (Button)findViewById(R.id.btnStop);
            TextView txtMassage = (TextView)findViewById(R.id.txtMessage);



            Button btn1 = (Button)findViewById(R.id.button10);
            Button btn2 = (Button)findViewById(R.id.button11);
            Button btn3 = (Button)findViewById(R.id.button12);
            Button btn4 = (Button)findViewById(R.id.button13);
            Button btn5 = (Button)findViewById(R.id.button14);
            Button btn6 = (Button)findViewById(R.id.button15);
            Button btn7 = (Button)findViewById(R.id.button16);
            Button btn8 = (Button)findViewById(R.id.btn2);
            Button btn9 = (Button)findViewById(R.id.btn1);




            if (view.getId() == R.id.btnStart) {
                chronometer.setBase(SystemClock.elapsedRealtime() - time);
                chronometer.start();

                btnS.setEnabled(false);
                btn.setEnabled(true);
                nowAnsmate = 0;
                nowQuestionNo = 0;
                time = 0;
                txtMassage.setText("それでは問題です。");
                getQuestion();

                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);




            }else if (view.getId() == R.id.btnStop){
                chronometer.stop();
                time = SystemClock.elapsedRealtime() - chronometer.getBase();

                btnS.setEnabled(true);
                btn.setEnabled(false);

            }else if (view.getId() == R.id.btnReset){
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                time = 0;
                nowAnsmate = 0;
                nowQuestionNo = 0;
                btn.setEnabled(false);
                btnS.setEnabled(true);
                txtMassage.setText("");

                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);



            }
        }

        public void ansClick(View v){
            Button btn = (Button)v;
            String enterNumStr = btn.getText().toString();
            int enterNum = Integer.parseInt(enterNumStr);
            TextView txtMassage = (TextView)findViewById(R.id.txtMessage);
            TextView txt = (TextView)findViewById(R.id.txtQuestion);
            Button btnStop = (Button)findViewById(R.id.btnStop);

            Button btn1 = (Button)findViewById(R.id.button10);
            Button btn2 = (Button)findViewById(R.id.button11);
            Button btn3 = (Button)findViewById(R.id.button12);
            Button btn4 = (Button)findViewById(R.id.button13);
            Button btn5 = (Button)findViewById(R.id.button14);
            Button btn6 = (Button)findViewById(R.id.button15);
            Button btn7 = (Button)findViewById(R.id.button16);
            Button btn8 = (Button)findViewById(R.id.btn2);
            Button btn9 = (Button)findViewById(R.id.btn1);

            if(nowQuestionNo < 9) {

                if (ans == enterNum) {
                    getQuestion();
                    nowQuestionNo += 1;
                    nowAnsmate += 1;

                } else {
                    getQuestion();
                    nowQuestionNo += 1;
                }

            }else{
                txtMassage.setText(nowAnsmate + "問正解でした。");
                txt.setText("");
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btnStop.callOnClick();
            }
        }

        public void getQuestion(){
            int a = (int)(Math.random()*9) + 1;
            ans = 10 - a;
            quesrion = "10 - " + a + " = ";
            TextView txt = (TextView)findViewById(R.id.txtQuestion);
            txt.setText(quesrion);
        }


}