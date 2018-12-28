package com.example.guest.cm0104.android108test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new SampleClickListenerImple());

    }

    class SampleClickListenerImple implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Button button = (Button)findViewById(R.id.button);
            button.setText("Button clicked!");
        }
    }

}
