package com.example.starreview;

public class Items
{
    String CountryName;
    int logo;
    public Items(String CountryName,int logo)
    {
        this.CountryName=CountryName;
        this.logo=logo;
    }
    public Items(String CountryName)
    {
        this.CountryName=CountryName;
    }
    public String getCountryName()
    {
        return CountryName;
    }

    public int getLogo() {
        return logo;
    }

    public String show()
    {
        return "You selected "+CountryName;
    }
}
