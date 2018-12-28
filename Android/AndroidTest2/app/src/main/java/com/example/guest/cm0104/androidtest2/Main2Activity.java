package com.example.guest.cm0104.androidtest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void onClickAction(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
