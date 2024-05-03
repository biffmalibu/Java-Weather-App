/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c.finalweatherproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bradf
 */
public class SaveState {
    private static Geolocation homeTown;
    private static String degreeUnits;
    private static boolean using24Hour;
    private static String distance;
    private static ArrayList<Geolocation> savedCities;
    
    public SaveState(Geolocation homeTown, String degreeUnits, boolean using24Hour, String distance, ArrayList<Geolocation> savedCities) {
        this.homeTown = homeTown;
        this.degreeUnits = degreeUnits;
        this.using24Hour = using24Hour;
        this.distance = distance;
        this.savedCities = savedCities;
    }
    
    public Geolocation getGeolocation() {return homeTown;}
    public String getDegreeUnits() {return degreeUnits;}
    public boolean getUsing24Hour() {return using24Hour;}
    public String getDistance() {return distance;}
    public ArrayList<Geolocation>  getSavedCities() {return savedCities;}
    
    public void setGeolocation(Geolocation homeTown) {
        this.homeTown = homeTown;
    }
    public void setDegreeUnits(String degreeUnits) {
        this.degreeUnits = degreeUnits;
    }
    public void setUsing24Hour(boolean using24Hour) {
        this.using24Hour = using24Hour;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    public void setSavedCities(ArrayList<Geolocation> savedCities) {
        this.savedCities = savedCities;
    }
    @Override
    public String toString() {
        return (homeTown.getCityName() + " ," + degreeUnits + " ," + using24Hour);
    }
    
    public static void updateFile()  {
        BufferedWriter writer = null;
        try {
            File file = new File("src\\main\\resources\\c\\finalweatherproject\\save.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(homeTown.toString());
            writer.write(degreeUnits);
            writer.write("\n" + using24Hour);
            writer.write("\n" + distance +"\n");
            for (int i = 0; i < 3; i++) {
                writer.write(savedCities.get(i).toString());
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file save.txt");
        } 
        
    }
}
