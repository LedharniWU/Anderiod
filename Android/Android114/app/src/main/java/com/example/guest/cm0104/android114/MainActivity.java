package com.example.guest.cm0104.android114;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnStartClick(View view){
        Intent intent = new Intent(MainActivity.this,CardActivity.class);
        startActivity(intent);
    }

    public void btnEditClick(View view){
        Intent intent = new Intent(MainActivity.this,EditActivity.class);
        startActivity(intent);
    }

    public void getListAction(View view){
        Intent intent = new Intent(MainActivity.this,CardListActivity.class);
        startActivity(intent);
    }

}
