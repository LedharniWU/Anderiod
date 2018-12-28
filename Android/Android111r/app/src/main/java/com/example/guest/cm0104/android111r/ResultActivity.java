package com.example.guest.cm0104.android111r;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String year = intent.getStringExtra("inputYear");
        String month = intent.getStringExtra("inputMonth");
        TextView txt = (TextView)findViewById(R.id.txtMyHistory);
        txt.setText(year + "年" + month + "日は誕生日です");
    }
}
