package com.example.starreview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
private static int TIMEOUT = 3000;

@Override

protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //to hide the status bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //To create a Delayed Welcome Screen
         new Handler().postDelayed(new Runnable() {
             @Override
             //Move from this layout to login
             public void run() {
                 Intent intent = new Intent(MainActivity.this,login.class);
                 startActivity(intent);
                 finish();
             }
         },TIMEOUT);
    }
}
