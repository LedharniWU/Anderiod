package com.example.guest.cm0104.android111u;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        button = (Button)findViewById(R.id.btnAgain);
        textView = (TextView)findViewById(R.id.txtMessage);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        final Intent intentBack = new Intent(this,MainActivity.class);

        textView.setText(message);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(intentBack);
            }
        });

    }



}
