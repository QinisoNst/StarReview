package com.example.starreview;

public class MovieItem
{
    String Name;
    int movie;
    String Relase;

    public MovieItem(String Name, String Relase, int movie )
    {
        this.Name=Name;
        this.Relase=Relase;
        this.movie=movie;

    }

    public String getRelase() {
        return Relase;
    }

    public int getMovie() {
        return movie;
    }

    public String getName() {
        return Name;
    }

    public String show()
    {
        return "You selected "+Name;
    }
}
