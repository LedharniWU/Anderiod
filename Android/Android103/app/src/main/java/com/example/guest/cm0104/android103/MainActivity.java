package com.example.guest.cm0104.android103;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int selectedItem = -1;
    Button btnReset;
    Button btnStart;
    private int win = 0;
    private int game = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReset = (Button)findViewById(R.id.btnReset);
        btnStart = (Button)findViewById(R.id.btnStart);

        btnReset.setEnabled(false);
        btnStart.setEnabled(false);

        ImageView cpu = (ImageView)findViewById(R.id.imgCpu);
        cpu.setVisibility(View.INVISIBLE);
    }

    public void itemSelectAction(View view) {
        ImageView[] items = new ImageView[3];
        items[0] = (ImageView) findViewById(R.id.imgGu);
        items[1] = (ImageView) findViewById(R.id.imgCh);
        items[2] = (ImageView) findViewById(R.id.imgPa);

        for (int i = 0; i < items.length; i++) {
            if (items[i] == view) {
                items[i].setBackgroundColor(Color.RED);
                if(game == 0) {
                    btnStart.setEnabled(true);
                }
                selectedItem = i;
            } else {
                items[i].setBackgroundColor(Color.WHITE);
            }
        }

    }

    public void startClickAction(View view) {
        int[] item = {R.drawable.j_gu02, R.drawable.j_ch02, R.drawable.j_pa02};
        Random rd = new Random();
        int cpu = rd.nextInt(3);
        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);

        ImageView src = (ImageView) findViewById(R.id.imgCpu);
        src.setVisibility(view.VISIBLE);
        src.setImageResource(item[cpu]);

        btnReset = (Button)findViewById(R.id.btnReset);
        btnStart = (Button)findViewById(R.id.btnStart);

        if (selectedItem == -1){

        }else if (selectedItem == 0){
            switch (cpu) {
                case 0:
                    txtInfo.setText("引き分け！");
                    break;
                case 1:
                    txtInfo.setText("あなたの勝ち！");
                    win += 1;
                    break;
                case 2:
                    txtInfo.setText("あなたの負け！");
                    win = 0;
                    break;

            }
        }else if (selectedItem == 1){
            switch (cpu) {
                case 1:
                    txtInfo.setText("引き分け！");
                    break;
                case 2:
                    txtInfo.setText("あなたの勝ち！");
                    win += 1;
                    break;
                case 0:
                    txtInfo.setText("あなたの負け！");
                    win = 0;
                    break;
            }
        }else{
            switch (cpu) {
                case 2:
                    txtInfo.setText("引き分け！");
                    break;
                case 0:
                    txtInfo.setText("あなたの勝ち！");
                    win += 1;
                    break;
                case 1:
                    txtInfo.setText("あなたの負け！");
                    win = 0;
                    break;
            }

        }
        btnStart.setEnabled(false);
        btnReset.setEnabled(true);
        game = 1;
    }

    public void resetClickAction(View view){

        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);

        btnReset = (Button)findViewById(R.id.btnReset);
        btnStart = (Button)findViewById(R.id.btnStart);

        ImageView src = (ImageView) findViewById(R.id.imgCpu);
        src.setVisibility(view.VISIBLE);
        if(win == 0){
            txtInfo.setText("今勝ってありません");
        }else if(win == 1){
            txtInfo.setText("まつ1勝です。");
        }else {
            txtInfo.setText("ただ今" + win + "連勝中！");
        }

        btnReset.setEnabled(false);
        btnStart.setEnabled(false);

        ImageView[] items = new ImageView[3];
        items[0] = (ImageView) findViewById(R.id.imgGu);
        items[1] = (ImageView) findViewById(R.id.imgCh);
        items[2] = (ImageView) findViewById(R.id.imgPa);

        for (int i = 0; i < items.length; i++){
            items[i].setBackgroundColor(Color.WHITE);
        }

        game = 0;

    }

}