package com.example.guest.cm0104.android110test;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickAction());


    }

    class OnClickAction implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle("確認");
            builder.setMessage("アプリ制作を理解しましたか？");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(MainActivity.this,"素晴らしい！",Toast.LENGTH_SHORT).show();

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
                }
            });

            builder.show();

            Toast.makeText(MainActivity.this,"完了",Toast.LENGTH_SHORT).show();
        }
    }
}
