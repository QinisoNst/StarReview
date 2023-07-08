package com.example.starreview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class movi extends AppCompatActivity {
    VideoView moviese;
    TextView namr;
    TextView nam;
    Intent intent;
    MediaController mediaController;
    VideoView videoView;
    int currentPo;
    String nt;
    String bt;
    Uri nu;
    int oo;
    int bn;

    boolean isPaused;
    ArrayList<Movieaction> aCountryList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        namr = (TextView) findViewById(R.id.countryName);
        videoView = (VideoView) findViewById(R.id.Videoview);
        nam= (TextView) findViewById(R.id.textView1);
        intent = getIntent();
        nt = intent.getStringExtra("Name");
        bt = intent.getStringExtra("Descrition");
        nu = Uri.parse(intent.getStringExtra("Movie"));

        if (mediaController == null) {
            mediaController = new MediaController(movi.this);
            mediaController.setAnchorView(videoView);
            Toast.makeText(getApplicationContext(),"Thanks for choosing Us",Toast.LENGTH_SHORT).show();

        }
        videoView.setMediaController(mediaController);
        namr.setText(nt);
        nam.setText(bt);
        videoView.setVideoURI(nu);
        videoView.start();
    //----------------------------------------------------------------------------------------------
    //videoURL
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigtion);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_movie:
                        startActivity(new Intent(getApplicationContext(), action.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_setting:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_search:
                        startActivity(new Intent(getApplicationContext(),search.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });

     //----------------------------------------------------------------------------------------------

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Action");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}



