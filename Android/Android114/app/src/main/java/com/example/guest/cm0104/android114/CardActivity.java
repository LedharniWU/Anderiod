package com.example.guest.cm0104.android114;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CardActivity extends AppCompatActivity {

    private ArrayList<Card> ary = new ArrayList<Card>();
    private int pos;
    private boolean bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        TextView txt = (TextView)findViewById(R.id.txtJapanese);

        pos = 0;
        CardSQLiteOpenHelper helper = new CardSQLiteOpenHelper(this);
        ary = helper.getAllCard();
        bool = true;
        dispOneCard();
        txt.setVisibility(View.INVISIBLE);
    }

    private void dispOneCard(){
        Card tmp = ary.get(pos);
        TextView txt1 = (TextView)findViewById(R.id.txtEnglish);
        txt1.setText(tmp.getEnglish());
        TextView txt2 = (TextView)findViewById(R.id.txtJapanese);
        txt2.setText(tmp.getJapanese());
    }

    public void onClickNext(View view){
        if(pos >= ary.size()-1) {
            Toast.makeText(CardActivity.this,"お疲れ様",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            pos++;
            dispOneCard();
        }
    }
    public void onClickPrev(View view){
        if(!(pos == 0)){
            pos--;
        }else{
            Toast.makeText(CardActivity.this,"最初のカードです。",Toast.LENGTH_SHORT).show();
        }
        dispOneCard();
    }
    public void onClickShowAnswer(View view){
        TextView txt2 = (TextView)findViewById(R.id.txtJapanese);
        if (bool) {
            txt2.setVisibility(view.VISIBLE);
            bool = false;
        }else {
            txt2.setVisibility(view.INVISIBLE);
            bool = true;
        }
    }
}
