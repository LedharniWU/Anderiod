package com.example.guest.cm0104.android114;

import android.content.Intent;

import android.database.sqlite.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText edtEnglish;
    EditText edtJapanese;
    CardSQLiteOpenHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtEnglish = (EditText)findViewById(R.id.edtEnglish);
        edtJapanese = (EditText)findViewById(R.id.edtJapanese);
        helper = new CardSQLiteOpenHelper(this);

    }

    public void onClickAdd(View view){
        Card src = new Card(edtJapanese.getText().toString(),edtEnglish.getText().toString(),1);
        helper.insertCard(src);
        Toast.makeText(EditActivity.this,"追加完了",Toast.LENGTH_SHORT).show();
        edtJapanese.setText("");
        edtEnglish.setText("");
    }


    public void onClickClose(View view){
        Intent intent = new Intent(EditActivity.this,MainActivity.class);
        startActivity(intent);
    }


}
