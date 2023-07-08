package com.example.starreview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class sifis extends AppCompatActivity {
    ListView MovieNames;
    ArrayList<Movieaction> Movie= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        MovieNames =(ListView)findViewById(R.id.ListView);


        Movie.add(new Movieaction("Star Wars","1986", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lkoa),R.drawable.starwarsmovie,"Star Wars American epic space opera film written and directed by George Lucas, The galaxy is in a period of civil war. Rebel spies have stolen plans to the Galactic Empire's Death Star, a moon-sized space station capable of destroying an entire planet. Princess Leia, secretly one of the Rebellion's leaders, has obtained its schematics,"));
        Movie.add(new Movieaction("Avengers","2016",Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.lkoa),R.drawable.avengers,"Avengers, is a 2012 American superhero film he Asgardian Loki encounters the Other, the leader of an extraterrestrial race known as the Chitauri. In exchange for retrieving the Tesseract,[N 2] a powerful energy source of unknown potential, the Other promises Loki an army with which he can subjugate Earth."));
        Movie.add(new Movieaction("Blade Runner","2018",null,R.drawable.blade,"Blade Runner is a 1982 science fiction film directed by Ridley Scott, the film is set in a dystopian future Los Angeles of 2019, in which synthetic humans known as replicants are bio-engineered by the powerful Tyrell Corporation to work at space colonies.1)\tBlade Runner is a 1982 science fiction film directed by Ridley Scott, the film is set in a dystopian future Los Angeles of 2019, in which synthetic humans known as replicants are bio-engineered by the powerful Tyrell Corporation to work at space colonies."));
        Movie.add(new Movieaction("Mad Max","2015",null,R.drawable.mad,"Mad Max: Fury Road is a 2015 Australian post-apocalyptic action film co-written, co-produced, and directed by George Miller  It follows Max Rockatansky (Tom Hardy), who joins forces with Imperator Furiosa (Charlize Theron) to flee from cult leader Immortan Joe (Hugh Keays-Byrne) and his army in an armoured tanker truck,"));
        Movie.add(new Movieaction("District 9","2009",null,R.drawable.district,"District 9 is a 2009 science fiction action film directed by Neill Blomkamp, The story, which explores themes of humanity, xenophobia and social segregation, begins in an alternate 1982, when an alien spaceship appears over Johannesburg, South Africa"));

        moviea countryAdapter = new moviea (this,R.layout.movielist_layout,Movie);

        MovieNames.setAdapter(countryAdapter);
        MovieNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View view , final int position , long id) {

                {

                    Intent intent = new Intent(sifis.this,movies.class);
                    String noo = Movie.get(position).getName();
                    String nuri =Movie.get(position).getMovie().toString();
                    String me   =Movie.get(position).getDescription();

                    intent.putExtra("Name",noo);
                    intent.putExtra("Descrition",me);
                    intent.putExtra("Movie",nuri);

                    startActivity(intent);
                }
            }
        });
        //----------------------------------------------------------------------------------------------

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigtion);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_movie:
                        startActivity(new Intent(getApplicationContext(), home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_setting:
                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),nana.class));
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
        toolbar.setTitle("t SI-FI");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
