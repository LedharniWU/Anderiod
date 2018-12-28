package com.example.guest.cm0104.android109test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toastPopup("onCreate",0,0);
    }

    @Override
    protected void onDestroy(){
        toastPopup("onDestroy",0,300);
        super.onDestroy();
    }


    private void toastPopup(String msg,int xOffset,int yOffset){
        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,xOffset,yOffset + 100 );
        toast.show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main,menu);
//        return true;
//    }

    @Override
    protected void onStart() {
        toastPopup("onStart",0,50);
        super.onStart();
    }

    @Override
    protected void onPostResume() {
        toastPopup("onPostResume",0,100);
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        toastPopup("onPause",0,150);
        super.onPause();
    }
}
