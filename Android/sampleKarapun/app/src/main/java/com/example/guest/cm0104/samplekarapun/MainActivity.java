package com.example.guest.cm0104.samplekarapun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

     // implements AdapterView.OnItemSelectedListener{

    int gatyaInt = 0;
    int starOneInt = 0;
    int starTwoInt = 0;
    int starThreeInt = 0;
    int starFourInt = 0;
    int starFiveInt = 0;

    //宣言
    Spinner spinner;
    RadioButton rbnOnce;
    RadioButton rbnTen;

    EditText starOneEdit;
    EditText starTwoEdit;
    EditText starThreeEdit;
    EditText starFourEdit;
    EditText starFiveEdit;

    TextView GatyaTxt;

    TextView starOneTxt;
    TextView starTwoTxt;
    TextView starThreeTxt;
    TextView starFourTxt;
    TextView starFiveTxt;
    //宣言


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //変数あける
        spinner = (Spinner) findViewById(R.id.spinner);
        rbnOnce = (RadioButton) findViewById(R.id.rbnOnce);
        rbnTen = (RadioButton) findViewById(R.id.rbnTen);

        starOneEdit = (EditText) findViewById(R.id.starOneEdit);
        starTwoEdit = (EditText) findViewById(R.id.starTwoEdit);
        starThreeEdit = (EditText) findViewById(R.id.starThreeEdit);
        starFourEdit = (EditText) findViewById(R.id.starFourEdit);
        starFiveEdit = (EditText) findViewById(R.id.starFiveEdit);

        GatyaTxt = (TextView) findViewById(R.id.GatyaTxt);

        starOneTxt = (TextView) findViewById(R.id.starOneTxt);
        starTwoTxt = (TextView) findViewById(R.id.starTwoTxt);
        starThreeTxt = (TextView) findViewById(R.id.starThreeTxt);
        starFourTxt = (TextView) findViewById(R.id.starFourTxt);
        starFiveTxt = (TextView) findViewById(R.id.starFiveTxt);
        //変数あける

       // spinner.setOnItemSelectedListener(this);
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//        if(spinnerStr.equals("フレンドガチャ")){
//
//            starOneEdit.setFocusable(true);
//            starTwoEdit.setFocusable(true);
//            starOneEdit.setFocusableInTouchMode(true);
//            starTwoEdit.setFocusableInTouchMode(true);
//            starOneEdit.setEnabled(true);
//            starTwoEdit.setEnabled(true);
//            starFourEdit.setFocusable(false);
//            starFiveEdit.setFocusable(false);
//
//        }else if (spinnerStr.equals("レアガチャ")){
//
//            starOneEdit.setFocusable(false);
//            starTwoEdit.setFocusable(false);
//            starFourEdit.setFocusableInTouchMode(true);
//            starFiveEdit.setFocusableInTouchMode(true);
//            starFourEdit.setFocusable(true);
//            starFiveEdit.setFocusable(true);
//            starFourEdit.setEnabled(true);
//            starFiveEdit.setEnabled(true);
//
//        }

//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }

    public void onClickAction(View view) {


            //getString to Integer -->
            Integer starOneInte = Integer.valueOf(starOneEdit.getText().toString());
            Integer starTwoInte = Integer.valueOf(starTwoEdit.getText().toString());
            Integer starThreeInte = Integer.valueOf(starThreeEdit.getText().toString());
            Integer starFourInte = Integer.valueOf(starFourEdit.getText().toString());
            Integer starFiveInte = Integer.valueOf(starFiveEdit.getText().toString());
            // <-- getString to Integer

            String spinnerStr = (String)spinner.getSelectedItem();


            Map<Integer, Integer> kaChaMap = new HashMap<Integer, Integer>();
            kaChaMap.put(1, starOneInte);
            kaChaMap.put(2, starTwoInte);
            kaChaMap.put(3, starThreeInte);
            kaChaMap.put(4, starFourInte);
            kaChaMap.put(5, starFiveInte);
            Lottery lottery = new Lottery(kaChaMap);

            if (spinnerStr.equals("フレンドガチャ")) {

                if (rbnOnce.isChecked() == true) {

                    gatyaInt += 1;

                    switch (lottery.drawLots()) {

                        case 1:
                            starOneInt += 1;
                            break;
                        case 2:
                            starTwoInt += 1;
                            break;
                        case 3:
                            starThreeInt += 1;
                            break;
                    }

                } else if (rbnTen.isChecked() == true) {

                    gatyaInt += 10;

                    for (int j = 0; j < 10; j++) {

                        switch (lottery.drawLots()) {

                            case 1:
                                starOneInt += 1;
                                break;
                            case 2:
                                starTwoInt += 1;
                                break;
                            case 3:
                                starThreeInt += 1;
                                break;
                        }
                    }
                }
                GatyaTxt.setText(gatyaInt + "回ガチャした。");
                starOneTxt.setText(starOneInt + "回 :" + String.format("%,.1f", Calculation(starOneInt, gatyaInt)) + "%");
                starTwoTxt.setText(starTwoInt + "回 :" + String.format("%,.1f", Calculation(starTwoInt, gatyaInt)) + "%");
                starThreeTxt.setText(starThreeInt + "回 :" + String.format("%,.1f", Calculation(starThreeInt, gatyaInt)) + "%");

            } else if (spinnerStr.equals("レアガチャ")) {

                gatyaInt += 1;

                if (rbnOnce.isChecked() == true) {

                    switch (lottery.drawLots()) {

                        case 3:
                            starThreeInt += 1;
                            break;
                        case 4:
                            starFourInt += 1;
                            break;
                        case 5:
                            starFiveInt += 1;
                            break;
                    }

                } else if (rbnTen.isChecked() == true) {

                    gatyaInt += 10;

                    for (int j = 0; j < 9; j++) {

                        switch (lottery.drawLots()) {

                            case 3:
                                starThreeInt += 1;
                                break;
                            case 4:
                                starFourInt += 1;
                                break;
                            case 5:
                                starFiveInt += 1;
                                break;
                        }
                    }
                }
                GatyaTxt.setText(gatyaInt + "回ガチャした。");
                starFourTxt.setText(starFourInt + "回 :" + String.format("%,.1f", Calculation(starFourInt, gatyaInt)) + "%");
                starFiveTxt.setText(starFiveInt + "回 :" + String.format("%,.1f", Calculation(starFiveInt, gatyaInt)) + "%");
                starThreeTxt.setText(starThreeInt + "回 :" + String.format("%,.1f", Calculation(starThreeInt, gatyaInt)) + "%");
            }
        }

    public Double Calculation(int i , int j){

        Double d = (double) i / j * 100 ;

        return d;
    }

    public void resetAction(View view){

        gatyaInt = 0;
        starOneInt = 0;
        starTwoInt = 0;
        starThreeInt = 0;
        starFourInt = 0;
        starFiveInt = 0;

        starOneTxt.setText("0 回 :" + "0 %");
        starTwoTxt.setText("0 回 :" + "0 %");
        starThreeTxt.setText("0 回 :" + "0 %");
        starFourTxt.setText("0 回 :" + "0 %");
        starFiveTxt.setText("0 回 :" + "0 %");
        GatyaTxt.setText("0回ガチャ");

    }

    public static class Lottery {
        // メンバ変数 - ガラポン(抽選BOX)
        private List<Integer> mLotBallList;

        //map key 入れる
        public Lottery(Map<Integer, Integer> lotteryMap) {
            mLotBallList = createLotteryBox(lotteryMap);
        }

        //ガチャ取る
        public int drawLots() {
            Collections.shuffle(mLotBallList);
            return (int) mLotBallList.get(0);
        }

        //回るmethod
        private List<Integer> createLotteryBox(Map<Integer, Integer> lotteryMap) {
            List<Integer> lotBalls = new ArrayList<Integer>();
            for (Integer key : lotteryMap.keySet()) {
                for (int i = 0; i < lotteryMap.get(key); i++) {
                    lotBalls.add(key);
                }
            }
            return lotBalls;
        }
    }
}
