package com.example.guest.cm0104.roulettegamecon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView costTxt;
    private TextView winTxt;
    private TextView bateTxt;

    private int costTxtInt;
    private int winTxtInt;
    private int bateTxtInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        costTxt = (TextView)findViewById(R.id.costTxt);
        winTxt = (TextView)findViewById(R.id.winTxt);
        bateTxt = (TextView)findViewById(R.id.bateTxt);

        costTxt.setText("0");
        winTxt.setText("0");
        bateTxt.setText("0");

    }

    public void paymentAction(View view){
        costTxt.setText("100");
        bateTxt.setText("1");
    }

    public void winAction(View view){

        costTxtInt = Integer.valueOf(costTxt.getText().toString()) - Integer.valueOf(bateTxt.getText().toString()) + Integer.valueOf(bateTxt.getText().toString()) * 2;
        costTxt.setText(String.valueOf(costTxtInt));
        winTxt.setText(String.valueOf(Integer.valueOf(bateTxt.getText().toString()) * 2));
        bateTxt.setText("1");
    }

    public void loseAction(View view){

        costTxtInt = Integer.valueOf(costTxt.getText().toString()) - Integer.valueOf(bateTxt.getText().toString());
        costTxt.setText(String.valueOf(costTxtInt));
        winTxt.setText("0");
        bateTxtInt = Integer.valueOf(bateTxt.getText().toString()) * 2;
        bateTxt.setText(String.valueOf(bateTxtInt));

    }



//
//    winTxtInt = Integer.valueOf(winTxt.toString());
//    bateTxtInt = Integer.valueOf(bateTxt.toString());
//

}
