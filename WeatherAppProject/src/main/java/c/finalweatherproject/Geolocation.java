/*********************************************************************************************************************************
* File: Geolocation.java                                                                                                         *
* Author: Bradford Torpey                                                                                                        *
* Purpose: This file is used to store the geolocation data of a city and return the data when needed.                            *
**********************************************************************************************************************************/
package c.finalweatherproject;


/**
 *
 * @author bradf
 */
public class Geolocation { // Geolocation data fields
    private String cityName;
    private String country;
    private String state = "";
    private double lat;
    private double lon;
    
    // Constructor
    public Geolocation(String cityName, String country, String state, double lat, double lon) {
        this.cityName = cityName;
        this.country = country;
        this.state = state;
        this.lat = lat;
        this.lon = lon;
    }
    
    // Getters
    public String getCityName() {return cityName;}
    public String getCountry() {return country;}
    public String getState() {return state;}
    public double getLat() {return lat;}
    public double getLon() {return lon;}
    
    /**
     * This method is used to get the geolocation data of a city
     */
    @Override
    public String toString() {
        return cityName + "\n"
               + country + "\n"
               + state + "\n"
               + lat + "\n"
               + lon + "\n";
    }
    
}
