package com.example.guest.cm0104.android112;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.data;

public class SettingActivity extends AppCompatActivity {

    String nowName;
    EditText txt;
    String name;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        txt = (EditText)findViewById(R.id.editName);
        intent = getIntent();
        nowName = intent.getStringExtra("nowName");
        txt.setText(nowName);

        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    public void onClickOk(View view){
        name = txt.getText().toString();
        intent.putExtra("userName",name);
        setResult(RESULT_OK, intent);
        finish();
    }

}
