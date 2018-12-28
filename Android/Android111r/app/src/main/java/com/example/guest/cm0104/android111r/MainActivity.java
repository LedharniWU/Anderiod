package com.example.guest.cm0104.android111r;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btnSel);
        btn.setOnClickListener(this);
        Button btnOK = (Button)findViewById(R.id.btnSubmit);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                EditText edt = (EditText)findViewById(R.id.editText);
                String date = edt.getText().toString();
                String year = date.split("/")[0];
                String month = date.split("/")[1];
                intent.putExtra("inputYear", year );
                intent.putExtra("inputMonth", month);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(
                this,
                new DialogDataSetEvent(),
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }

    class DialogDataSetEvent implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            EditText editText = (EditText)findViewById(R.id.editText);
            editText.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
        }
    }
}
