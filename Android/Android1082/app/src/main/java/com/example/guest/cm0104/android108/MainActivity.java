package com.example.guest.cm0104.android108;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView txtPrice;
    TextView txtDiscount;
    TextView txtPay;
    String num;
    String numNum;
    private int discount;
    SeekBar skbDiscount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //宣言
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtDiscount = (TextView) findViewById(R.id.txtDiscount);
        txtPay = (TextView) findViewById(R.id.txtPay);
        skbDiscount = (SeekBar) findViewById(R.id.skbDiscount);
        //Button 宣言
        int[] numId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnClear, R.id.btn00};
        for (int i = 0; i < numId.length; i++) {
            Button btn = (Button) findViewById(Integer.valueOf(numId[i]));
            btn.setOnClickListener(new NumberClickListenerImple());
        }
        //Button 宣言

        skbDiscount.setOnSeekBarChangeListener(new SeekBarControl());

        //初期化
        num = "";
        numNum = "";
        txtPrice.setText("0");
        txtDiscount.setText("0");
        txtPay.setText("0");
        discount = 0;
    }

    class NumberClickListenerImple implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Button button = (Button) v;
            String value = button.getText().toString();

            switch (value) {
                    case "C":
                        txtPrice.setText("0");
                        txtDiscount.setText("0");
                        txtPay.setText("0");
                        num = "";
                        skbDiscount.setProgress(0);
                        break;
                    case "←":

                        if ((num.length() > 1 && num != null)) {
                            num = num.substring(0, num.length() - 1);
                            txtPrice.setText(String.format("￥" + "%,3d", Integer.valueOf(num)));
                        } else if (num.length() == 1) {
                            num = "";
                            txtPrice.setText("￥" + "0");
                        }
                        break;

                    case "0":

                        if(!txtPrice.getText().toString().equals("0")){
                            num += value;
                        }

                    default:

                        if(num.length() < 8) {
                            num += value;
                            txtPrice.setText(String.format("￥" + "%,3d", Integer.valueOf(num)));
                        }
                        break;
                }

                if (!txtPrice.getText().toString().equals("0") && !num.equals("")) {
                    toPrice(Integer.valueOf(num), discount);
                } else if (num.equals("")) {
                    txtPrice.setText("0");
                    txtDiscount.setText("0%");
                    txtPay.setText("0");
                    num = "";
                    skbDiscount.setProgress(0);
                }
            }
    }

    class SeekBarControl implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            discount = progress * 5;
            txtDiscount.setText(String.valueOf(discount) + "%");
            if (!txtPrice.getText().toString().equals("0")) {
                toPrice(Integer.valueOf(num), discount);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }


    public void toPrice(int price, int discount) {

        int pay = price - (price * discount / 100);
        txtPay.setText(String.valueOf("￥" + String.format("%,3d", pay)));


    }
}

