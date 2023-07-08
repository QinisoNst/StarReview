package com.example.starreview;

import android.net.Uri;

public class Movieaction
{
    String Name;
    Uri movie;
    int postar;
    String Relase;
    String description;

    public Movieaction(String Name, String Relase, Uri movie, int postar,String description)
    {
        this.Name=Name;
        this.Relase=Relase;
        this.movie=movie;
        this.postar=postar;
        this.description=description;
    }
    public void setMovie(Uri movie) {
        this.movie = movie;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPostar(int postar) {
        this.postar = postar;
    }

    public void setRelase(String relase) {
        Relase = relase;
    }
    public String getRelase() {
        return Relase;
    }

    public Uri getMovie()
    {
        return movie;
    }

    public String getName() {
        return Name;
    }

    public int getPostar() {
        return postar;
    }

    public String show()
    {
        return "You selected "+Name;
    }
}
