package com.example.guest.cm0104.android106test;

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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,0,Menu.NONE,"yahoo");
        menu.add(Menu.NONE,1,Menu.NONE,"Google");
        menu.add(Menu.NONE,2,Menu.NONE,"終了");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()){
            case 0:
                Toast.makeText(this,"Yahooを表示する？",Toast.LENGTH_SHORT).show();
                return true;
            case 1:
                Toast.makeText(this,"Googleを表示する？",Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                finish();
                return true;
        }
        return false;
    }


    public void onClickAction(View view){

        WebView wView = (WebView)findViewById(R.id.wView);
        wView.setWebViewClient(new WebViewClient());
        wView.getSettings().setJavaScriptEnabled(true);
        wView.loadUrl("http://headlines.yahoo.co.jp");

    }



}
