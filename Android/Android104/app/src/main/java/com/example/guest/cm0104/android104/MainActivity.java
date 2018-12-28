package com.example.guest.cm0104.android104;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAction(View view) {

       pay();

    }

    public void pay() {

        int collectMoney;
        double myPay;

        EditText edtTotalpay = (EditText) findViewById(R.id.edtTotalpay);
        Spinner spNumber = (Spinner) findViewById(R.id.spNumber);
        // txt
        TextView txtCollectMoney = (TextView) findViewById(R.id.txtCollectMoney);
        TextView txtMyPay = (TextView) findViewById(R.id.txtMyPay);
        TextView txtZankin = (TextView)findViewById(R.id.txtZankin);

        ToggleButton tbtnToku = (ToggleButton) findViewById(R.id.tbtnToku);

        RadioButton rbt100 = (RadioButton) findViewById(R.id.rbt100);
        RadioButton rbt500 = (RadioButton) findViewById(R.id.rbt500);
        RadioButton rbt1000 = (RadioButton) findViewById(R.id.rbt1000);

        CheckBox cbx2Jikai = (CheckBox)findViewById(R.id.cbx2Jikai);

        String msg = edtTotalpay.getText().toString();
        String spn = (String) spNumber.getSelectedItem();




        if (!edtTotalpay.getText().toString().equals("")) {

            // intに変更
            collectMoney = Integer.valueOf(msg) / Integer.valueOf(spn);

            double money100 = (double)collectMoney;
            double money100D = Math.ceil(money100 / 100) * 100;
            double money100F = Math.floor(money100 / 100) * 100;

            double money500 = (double)collectMoney;
            double money500D = Math.ceil(money500 / 500) * 500;
            double money500F = Math.floor(money500 / 500) * 500;


            double money1000 = (double)collectMoney;
            double money1000D = Math.ceil(money1000 / 1000) * 1000;
            double money1000F = Math.floor(money1000 / 1000) * 1000;



            if(cbx2Jikai.isChecked() == false) {

                txtZankin.setText("");
                txtZankin.setText("");
                if (tbtnToku.isChecked() == true) {

                    if (rbt100.isChecked() == true) {

                        txtCollectMoney.setText(String.format("%,.0f",money100D));
                        myPay = Double.valueOf(msg) - (money100D * (Double.valueOf(spn) - 1));
                        //              String.valueOf(myPay) = 750.0
                        txtMyPay.setText(String.format("%,.0f",myPay));

                    } else if (rbt500.isChecked() == true) {

                        txtCollectMoney.setText(String.format("%,.0f",money500D));
                        myPay = Double.valueOf(msg) - (money500D * (Double.valueOf(spn) - 1));
                        txtMyPay.setText(String.format("%,.0f",myPay));

                    } else if (rbt1000.isChecked() == true) {

                        txtCollectMoney.setText(String.format("%,.0f",money1000D));
                        myPay = Double.valueOf(msg) - (money1000D * (Double.valueOf(spn) - 1));
                        txtMyPay.setText(String.format("%,.0f",myPay));

                    }

                } else if (tbtnToku.isChecked() == false) {

                    if (rbt100.isChecked() == true) {

                        txtCollectMoney.setText(String.format("%,.0f",money100F));
                        myPay = Double.valueOf(msg) - (money100F * (Double.valueOf(spn) - 1));
                        txtMyPay.setText(String.format("%,.0f",myPay));

                    } else if (rbt500.isChecked() == true) {

                        txtCollectMoney.setText(String.format("%,.0f",money500F));
                        myPay = Double.valueOf(msg) - (money500F * (Double.valueOf(spn) - 1));
                        txtMyPay.setText(String.format("%,.0f",myPay));

                    } else if (rbt1000.isChecked() == true) {

                        txtCollectMoney.setText(String.format("%,.0f",money1000F));
                        myPay = Double.valueOf(msg) - (money1000F * (Double.valueOf(spn) - 1));
                        txtMyPay.setText(String.format("%,.0f",myPay));

                    }
                }
            }else{

                if (rbt100.isChecked() == true) {

                    txtCollectMoney.setText(String.format("%,.0f",money100D));
                    txtMyPay.setText(String.format("%,.0f",money100D));
                    double zankin = (money100D * Double.valueOf(spn)) -  Double.valueOf(msg);
                    txtZankin.setText(String.format("%,.0f",zankin));


                } else if (rbt500.isChecked() == true) {
                    txtCollectMoney.setText(String.format("%,.0f",money500D));
                    txtMyPay.setText(String.format("%,.0f",money500D));
                    double zankin = (money500D * Double.valueOf(spn)) -  Double.valueOf(msg);
                    txtZankin.setText(String.format("%,.0f",zankin));

                } else if (rbt1000.isChecked() == true) {

                    txtCollectMoney.setText(String.format("%,.0f",money1000D));
                    txtMyPay.setText(String.format("%,.0f",money1000D));
                    double zankin = (money1000D * Double.valueOf(spn)) -  Double.valueOf(msg);
                    txtZankin.setText(String.format("%,.0f",zankin));
                }

            }
        }else{
            Toast.makeText(this,"金額を入力してください。",Toast.LENGTH_SHORT).show();
        }
    }
}





//if (Integer.valueOf(msg) % Integer.valueOf(spn) == 0) {
//        txtCollectMoney.setText(collectMoneyS);
//        txtMyPay.setText(collectMoneyS);
//        } else {
//        txtCollectMoney.setText(collectMoneyS);
//        int myPay = collectMoney + (Integer.valueOf(msg) % Integer.valueOf(spn));
//        String myPayStr = String.valueOf(myPay);
//        txtMyPay.setText(myPayStr);
//        }
