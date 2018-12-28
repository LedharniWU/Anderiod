package com.example.guest.cm0104.android111u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button ;
    Spinner spinner;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.btnNext);
        spinner = (Spinner)findViewById(R.id.spBloodType);
        intent = new Intent(this, NextActivity.class);
    }

    public void onClickAction(View view){



     switch (spinner.getSelectedItem().toString()){

            case "A型":
                intent.putExtra("message","A型の人のモチベーションは完璧主義。");
                break;
            case "B型":
                intent.putExtra("message","B型の人のモチベーションは天邪鬼。");
                break;
            case "AB型":
                intent.putExtra("message","AB型の人のモチベーションは猫みたいに気分屋。");
                break;
            case "O型":
                intent.putExtra("message","O型の人のモチベーションは基本的に低空飛行。楽に生きる。");
                break;
        }

        startActivity(intent);
    }

}
