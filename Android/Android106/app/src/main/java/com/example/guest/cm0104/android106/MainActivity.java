package com.example.guest.cm0104.android106;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final WebView webView = (WebView)findViewById(R.id.wView);
        final EditText editText = (EditText)findViewById(R.id.editText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://headlines.yahoo.co.jp");
        editText.setText("http://headlines.yahoo.co.jp");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,0,Menu.NONE,"yahoo");
        menu.add(Menu.NONE,1,Menu.NONE,"Google");
        menu.add(Menu.NONE,2,Menu.NONE,"Udemy");
        menu.add(Menu.NONE,3,Menu.NONE,"終了");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        WebView wView = (WebView)findViewById(R.id.wView);
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        EditText editText = (EditText)findViewById(R.id.editText);

        if(checkBox.isChecked() == true){
            wView.getSettings().setJavaScriptEnabled(true);
            Toast.makeText(this,"true",Toast.LENGTH_SHORT).show();
        }else if(checkBox.isChecked() == false){
            wView.getSettings().setJavaScriptEnabled(false);
            Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
        }

        wView.setWebViewClient(new WebViewClient());
        switch (item.getItemId()){
            case 0:
                wView.loadUrl("http://headlines.yahoo.co.jp");
                editText.setText("http://headlines.yahoo.co.jp");
                return true;
            case 1:
                wView.loadUrl("http://www.google.co.jp");
                editText.setText("http://www.google.co.jp");
                return true;
            case 2:
                wView.loadUrl("http://www.udemy.com/?utm_source=adwords-brand&utm_medium=udemyads&utm_campaign=NEW-AW-PROS-Branded-Search-JP-JAP_._ci__._sl_JAP_._vi__._sd_All_._la_JP_._&tabei=7&utm_term=_._ag_55807532797_._ad_303816807526_._de_c_._dm__._pl__._ti_aud-297589596425:kwd-310556426868_._li_1009310_._pd__._&gclid=EAIaIQobChMI7ujWzJat3gIVFR4rCh1C9AQlEAAYASAAEgJFf_D_BwE");
                editText.setText("http://www.udemy.com/?utm_source=adwords-brand&utm_medium=udemyads&utm_campaign=NEW-AW-PROS-Branded-Search-JP-JAP_._ci__._sl_JAP_._vi__._sd_All_._la_JP_._&tabei=7&utm_term=_._ag_55807532797_._ad_303816807526_._de_c_._dm__._pl__._ti_aud-297589596425:kwd-310556426868_._li_1009310_._pd__._&gclid=EAIaIQobChMI7ujWzJat3gIVFR4rCh1C9AQlEAAYASAAEgJFf_D_BwE");
                return true;
            case 3:
                finish();
                return true;
        }
        return false;
    }

    public void onClickAction(View view){

        WebView webView = (WebView)findViewById(R.id.wView);
        EditText editText = (EditText)findViewById(R.id.editText);
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);

        webView.setWebViewClient(new WebViewClient());

        if(checkBox.isChecked() == true){
            webView.getSettings().setJavaScriptEnabled(true);
            Toast.makeText(this,"JavaScript is ON",Toast.LENGTH_SHORT).show();
        }else if(checkBox.isChecked() == false){
            webView.getSettings().setJavaScriptEnabled(false);
            Toast.makeText(this,"JavaScript is OFF",Toast.LENGTH_SHORT).show();
        }

        if(!editText.getText().toString().equals("") == false){
            Toast.makeText(this,"URLを入力してください！",Toast.LENGTH_SHORT).show();
        }else {

            webView.loadUrl(editText.getText().toString());

        }

    }

}
