package com.example.guest.cm0104.android110;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.btnActivity);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnActivity){
            Toast.makeText(MainActivity.this,"Activityを実装した。",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, NextActivity.class);
            intent.putExtra("message","Activityを実装した。");

            startActivity(intent);

        }
    }
}

