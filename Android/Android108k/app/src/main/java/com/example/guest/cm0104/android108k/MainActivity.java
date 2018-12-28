package com.example.guest.cm0104.android108k;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.SeekableByteChannel;

public class MainActivity extends AppCompatActivity {

    private  String num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] btnIds = {R.id.btn1,R.id.btn2,R.id.btn3};
        for(int i = 0 ;i<btnIds.length;i++){
            Button btn = (Button)findViewById(btnIds[i]);
            btn.setOnClickListener(new NumberClickListenerImple());
        }

        SeekBar seekBar = (SeekBar)findViewById(R.id.skbDiscount);
        seekBar.setOnSeekBarChangeListener(new SeekBarControl());

    }

    class NumberClickListenerImple implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            TextView txt = (TextView)findViewById(R.id.textPrice);
            Button button = (Button)v;
            String value = button.getText().toString();
            num += value;
            txt.setText(num);


        }
    }

    class SeekBarControl implements SeekBar.OnSeekBarChangeListener{

        private  int discount = 0;

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            TextView text = (TextView)findViewById(R.id.txtDiscount);
            discount = progress * 10;
            text.setText(String.valueOf(discount));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

            Toast.makeText(MainActivity.this,discount + "%の割引をします。",Toast.LENGTH_SHORT).show();

        }
    }
}
