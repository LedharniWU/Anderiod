package com.example.guest.cm0104.android112;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    TextView textView;

    private int nowIdx;

    private String[] question = {"1", "2", "3"};
    private boolean[] answer = {false, false, true};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        nowIdx = 0;
        textView = (TextView)findViewById(R.id.txtQuiz);
        textView.setText(question[nowIdx]);

    }

    public void onYesClick(View view){
        getAnswer(true);
    }

    public void onNoClick(View view){
        getAnswer(false);
    }

    public void getAnswer(boolean ex){

        if(question.length <= nowIdx){
            finish();
        }
        
        if(answer[nowIdx] == ex){

            Toast.makeText(this,"正解",Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this,"不正解",Toast.LENGTH_SHORT).show();

        }

        textView.setText(question[nowIdx]);
        nowIdx++;


    }
}
