/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c.finalweatherproject;

/**
 *
 * @author bradf
 */
public class SaveState {
    private static Geolocation homeTown;
    private static String degreeUnits = "F";
    private static boolean using24Hour = false;
    
    public SaveState(Geolocation homeTown, String degreeUnits, boolean using24Hour) {
        this.homeTown = homeTown;
        this.degreeUnits = degreeUnits;
        this.using24Hour = using24Hour;
    }
    
    public Geolocation getGeolocation() {return homeTown;}
    public String getDegreeUnits() {return degreeUnits;}
    public boolean getUsing24Hour() {return using24Hour;}
    
    public void setGeolocation(Geolocation homeTown) {
        this.homeTown = homeTown;
    }
    public void setDegreeUnits(String degreeUnits) {
        this.degreeUnits = degreeUnits;
    }
    public void setUsing24Hour(boolean using24Hour) {
        this.using24Hour = using24Hour;
    }
    @Override
    public String toString() {
        return (homeTown.getCityName() + " ," + degreeUnits + " ," + using24Hour);
    }
}
