/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c.finalweatherproject;


/**
 *
 * @author bradf
 */
public class Geolocation {
    private String cityName;
    private String country;
    private String state = "";
    private double lat;
    private double lon;
    
    public Geolocation(String cityName, String country, String state, double lat, double lon) {
        this.cityName = cityName;
        this.country = country;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
    }
    
    public String getCityName() {return cityName;}
    public String getCountry() {return country;}
    public String getState() {return state;}
    public double getLat() {return lat;}
    public double getLon() {return lon;}
    
    @Override
    public String toString() {
        return cityName + "\n"
               + country + "\n"
               + state + "\n"
               + lat + "\n"
               + lon + "\n";
    }
    
}
