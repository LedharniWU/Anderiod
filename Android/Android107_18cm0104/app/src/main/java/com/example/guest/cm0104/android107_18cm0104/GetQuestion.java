package com.example.guest.cm0104.android107_18cm0104;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by guest on 2018/12/06.
 */

public class GetQuestion {

    private String answer;


    GetQuestion(TextView txtNorth,TextView txtSouth,TextView txtWest,TextView txtEast,int nowNo ,ArrayList<String> ary){

        txtNorth.setText(ary.get(nowNo).substring(0, 1));
        txtSouth.setText(ary.get(nowNo).substring(3, 4));
        txtWest.setText(ary.get(nowNo).substring(4, 5));
        txtEast.setText(ary.get(nowNo).substring(7, 8));
    }
    public String getAnswer(int nowNo,ArrayList<String> ary) {
        answer = ary.get(nowNo).substring(1, 2);
        return answer;
    }
}
