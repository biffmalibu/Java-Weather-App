/*********************************************************************************************************************************
* File: SaveState.java                                                                                                           *
* Author: Bradford Torpey                                                                                                        *
* Purpose: This file is used to store the save state of the application and return the data when needed.                         *
**********************************************************************************************************************************/
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
public class SaveState { // Save state fields
    private static Geolocation homeTown;
    private static String degreeUnits;
    private static String distance;
    private static ArrayList<Geolocation> savedCities;

    // Constructor
    public SaveState(Geolocation homeTown, String degreeUnits, String distance, ArrayList<Geolocation> savedCities) { 
        this.homeTown = homeTown;
        this.degreeUnits = degreeUnits;
        this.distance = distance;
        this.savedCities = savedCities;
    }
    
    // Getters
    public Geolocation getGeolocation() {return homeTown;}
    public String getDegreeUnits() {return degreeUnits;}
    public String getDistance() {return distance;}
    public ArrayList<Geolocation>  getSavedCities() {return savedCities;}
    
    // Setters
    public void setGeolocation(Geolocation homeTown) {
        this.homeTown = homeTown;
    }
    public void setDegreeUnits(String degreeUnits) {
        this.degreeUnits = degreeUnits;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
    public void setSavedCities(ArrayList<Geolocation> savedCities) {
        this.savedCities = savedCities;
    }
    
    /**
     *  To string method to get the save state data
     */
    @Override
    public String toString() {
        return (homeTown.getCityName() + " ," + degreeUnits);
    }
    /**
     * This method is used to add a saved city to the saved cities list
     * @param location - The geolocation of the city to be saved
     */
    public static void addSavedCity(Geolocation location) {
        boolean duplicateLocation = false; 
        for (int i = 0; i < 3; i++) { // Check for duplicate location
            if (location.getLat() == savedCities.get(i).getLat() && location.getLon() == savedCities.get(i).getLon()) {
                duplicateLocation = true;
            }
        }
        if (!duplicateLocation) { // Add location to saved cities if not a duplicate
            savedCities.remove(0);
            savedCities.add(location);
            updateFile(); // Update the save file
        }
        
    }

    /**
     * This method is used to update the save file with the new save state
     */
    public static void updateFile()  {
        BufferedWriter writer = null;
        try {
            File file = new File("src\\main\\resources\\c\\finalweatherproject\\save.txt"); // Write to save file
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(homeTown.toString());
            writer.write(degreeUnits);
            writer.write("\n" + distance +"\n");
            for (int i = 0; i < 3; i++) { // Write saved cities to file
                writer.write(savedCities.get(i).toString());
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file save.txt");
        } 
        
    }
}
