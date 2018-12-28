package com.example.guest.cm0104.android114test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void onClick(View view){

        SampleSQLiteOpenHelper helper = new SampleSQLiteOpenHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();

        try {
            Cursor cursor = database.query("SAMPLE_TABLE", null, null, null, null, null, null);

            if (cursor != null) {
                Log.v("Android114", "データ件数:" + cursor.getCount() + "件");
                textView.setText( "データ件数:" + cursor.getCount() + "件");
                cursor.close();
            }

        } finally {
            helper.close();
        }
    }

    public void onClick2(View view){

        SampleSQLiteOpenHelper helper = new SampleSQLiteOpenHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", editText.getText().toString());

        long result = database.insert("SAMPLE_TABLE", null, values);
        Log.v("Android114","result:" + result);
        textView2.setText("result:" + result);
        helper.close();

        if(result != -1){
            Log.v("Android114","追加完了！");
            textView3.setText("追加完了！");
        }
    }
}
