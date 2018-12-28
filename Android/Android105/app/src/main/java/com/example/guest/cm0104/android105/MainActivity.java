package com.example.guest.cm0104.android105;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAction(View view){
        CheckBox cbx = (CheckBox)findViewById(R.id.cbxSample);

        if(cbx.isChecked()){
            Log.i("android105", "チェックされている");
        }else{
            Log.i("android105", "チェックされていない");
        }
        ToggleButton tbtn = (ToggleButton)findViewById(R.id.tbtnSample);

        if(tbtn.isChecked() == true){
            Log.i("android105","トグルボタンが押されている");
        }

        RadioButton rbtA = (RadioButton)findViewById(R.id.rbtAndroid);
        RadioButton rbtO = (RadioButton)findViewById(R.id.rbtIOS);

        if(rbtA.isChecked() == true){
            Log.i("android105","あなたはAndroidが得意なのですね！");
        }else if(rbtO.isChecked() == true){
            Log.i("android105","あなたはiOSが得意なのですね！");
        }

        Toast.makeText(this,"色々わかりました！",Toast.LENGTH_SHORT).show();
    }
}
