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
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class action extends AppCompatActivity {
    ListView CountryNames;
    ArrayList<Movieaction> Movie= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        CountryNames =(ListView)findViewById(R.id.ListView);

        //generating date for the ArrayList
        Movie.add(new Movieaction("Deadpool","2019",Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.iko),R.drawable.deadpool,"Deadpool is a 2016 American superhero film Wade Wilson is a dishonorably discharged special forces operative working as a mercenary when he meets Vanessa, a prostitute. They become romantically involved, and a year later she accepts his marriage proposal"));
        Movie.add(new Movieaction("Ready Player One","2018",Uri.parse("android.resource://"+getPackageName()+ "/" + R.raw.iko),R.drawable.readyplayerone,"Ready Player One is a 2018 American science fiction action-adventure film directed by Steven Spielberg, t takes place in 2045, when much of humanity uses the virtual reality software OASIS (Ontologically Anthropocentric Sensory Immersive Simulation) to escape the desolation of the real world."));
        Movie.add(new Movieaction("Bad Boys II","2003",null,R.drawable.badboys,"Bad Boys II is a 2003 American action comedy film directed by Michael Bay, Eight years after the events of the first film, Miami Police Department (MPD) narcotics division detectives Marcus Burnett and Mike Lowrey are investigating a flow of ecstasy into the city, leading them to a KKK meeting and drug drop."));
        Movie.add(new Movieaction("Fast Five","2019",null,R.drawable.fastfive,"Kingsman The Secret Service is a 2014 action spy comedy film The film follows the recruitment and training of Gary \"Eggsy\" Unwin (Taron Egerton), into a secret spy organisation."));
        Movie.add(new Movieaction("Kingsman","2014",null,R.drawable.kingsman,"Fast Five is a 2011 American heist action film directed by Justin Lin Fast Five follows Dominic Toretto (Diesel), Brian O'Conner (Walker) and Mia Toretto (Brewster) as they plan a heist to steal $100 million"));
//moving data from Movie to the Adapter
        moviea countryAdapter = new moviea (this,R.layout.movielist_layout,Movie);
        CountryNames.setAdapter(countryAdapter);
        CountryNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View view , final int position , long id) {

                {

                 Intent intent = new Intent(action.this,movie.class);
                 String noo = Movie.get(position).getName();
                 String nuri = Movie.get(position).getMovie().toString();
                 String me = Movie.get(position).getDescription();

                 intent.putExtra("Name",noo);
                 intent.putExtra("Descrition",me);
                 intent.putExtra("Movie",nuri);

                 startActivity(intent);
                }
            }
        });

        //----------------------------------------------------------------------------------------------
        //set BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigtion);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
  //use switch to direct users where to go depending on the cash

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
//setTitle ,lniialize Toolbar and overrideActionbar
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
