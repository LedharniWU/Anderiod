package com.example.guest.cm0104.android114;

import android.content.DialogInterface;
import android.content.Intent;

import android.database.sqlite.*;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText edtEnglish;
    EditText edtJapanese;
    CardSQLiteOpenHelper helper;
    private int id = -1;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtEnglish = (EditText) findViewById(R.id.edtEnglish);
        edtJapanese = (EditText) findViewById(R.id.edtJapanese);
        btn = (Button) findViewById(R.id.btnAdd);
        helper = new CardSQLiteOpenHelper(this);

        Intent intent = getIntent();
        String mode = intent.getStringExtra("mode");

        if ("update".equals(mode)) {

            id = intent.getIntExtra("id", -1);
            Card tmp = helper.findCardById(id);
            edtJapanese.setText(tmp.getJapanese());
            edtEnglish.setText(tmp.getEnglish());

            btn.setOnClickListener(new UpdateOnClickAction());
            btn.setText("Update");


            LinearLayout lay = (LinearLayout) findViewById(R.id.layEditHome);
            Button newBtn = new Button(this);
            newBtn.setText("Delete");
            newBtn.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            newBtn.setOnClickListener(new DeleteOnClickAction());
            lay.addView(newBtn);

        } else {
            btn.setOnClickListener(new AddOnClickAction());
            btn.setText("Add");
        }

    }

    private class AddOnClickAction implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String english = edtEnglish.getText().toString();
            String japanese = edtJapanese.getText().toString();

            Card src = new Card(english, japanese, -1);
            boolean ret = helper.insertCard(src);

            if (ret) {
                Toast.makeText(EditActivity.this, "追加完了！", Toast.LENGTH_SHORT).show();
                edtJapanese.setText("");
                edtEnglish.setText("");
            } else {
                Toast.makeText(EditActivity.this, "追加失敗！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickClose(View view) {
        Intent intent = new Intent(EditActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private class UpdateOnClickAction implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String english = edtEnglish.getText().toString();
            String japanese = edtJapanese.getText().toString();

            Card src = new Card(english, japanese, id);
            boolean ret = helper.updateCard(src);

            if (ret) {
                Toast.makeText(EditActivity.this, "編集成功！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditActivity.this, CardListActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(EditActivity.this, "編集失敗！", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class DeleteOnClickAction implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditActivity.this);
            // AlertDialogのタイトル設定します

            alertDialogBuilder.setTitle("削除");

            // AlertDialogのメッセージ設定
            alertDialogBuilder.setMessage("本当に削除しますか？");

            // AlertDialogのYesボタンのコールバックリスナーを登録
            alertDialogBuilder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            helper.deleteCardById(id);
                            Intent intent = new Intent(EditActivity.this, CardListActivity.class);
                            startActivity(intent);

                        }
                    });
            // AlertDialogのNoボタンのコールバックリスナーを登録
            alertDialogBuilder.setNeutralButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            // AlertDialogのキャンセルができるように設定
            alertDialogBuilder.setCancelable(true);

            AlertDialog alertDialog = alertDialogBuilder.create();
            // AlertDialogの表示
            alertDialog.show();
        }
    }
}

