package com.example.guest.cm0104.android112;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private String userName = "名無し";
    private static int CODE_SETTING = 123;
    private static int CODE_QUIZ = 456;
    Intent intent;
    Intent intentQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,SettingActivity.class);
        intentQ = new Intent(this, QuizActivity.class);

        if(!(userName.equals(""))) {
            intent.putExtra("nowName", userName);
        }else{
            userName = "名無し";
            intent.putExtra("nowName", userName);
        }
    }

    public void onClickUserSetting(View view){

        startActivityForResult(intent, CODE_SETTING);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //setUserName
        if(requestCode == CODE_SETTING){

            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("userName");
                TextView txt = (TextView)findViewById(R.id.txtWelcome);
                if(name.equals("")){
                    txt.setText("ようこそ「名無し」さん");
                }else {
                    txt.setText("ようこそ「"+ name +"」さん");
                    userName = name.toString();
                    intent.putExtra("nowName", userName);
                }
            }else if (resultCode == RESULT_CANCELED){

            }
        }

        //setQuiz
        if(requestCode == CODE_QUIZ){

        }

    }

    public void onStartAction(View view){
        startActivityForResult(intentQ,CODE_QUIZ);
    }
}
