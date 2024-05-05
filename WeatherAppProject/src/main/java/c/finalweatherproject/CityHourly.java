package c.finalweatherproject;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bradf
 */
public class CityHourly {
    private int dt;
    private double curTemp;
    private double feelsLike;
    private int pressure;
    private int humidity;
    private double dewPoint;
    private double uvi;
    private int clouds;
    private double windSpeed;
    private int windDegrees;
    private double windGust;

    private int weatherId;
    private String weatherMain;
    private String weatherDesc;
    private double pop;

    // Constructor
    public CityHourly(int dt, double curTemp, double feelsLike, int pressure, int humidity, double dewPoint, double uvi,
                      int clouds, double windSpeed, int windDegrees, double windGust,
                      int weatherId, String weatherMain, String weatherDesc, double pop) {
        this.dt = dt;
        this.curTemp = curTemp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.uvi = uvi;
        this.clouds = clouds;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
        this.windGust = windGust;
        this.weatherId = weatherId;
        this.weatherMain = weatherMain;
        this.weatherDesc = weatherDesc;
        this.pop = pop;
    }
    @Override
    public String toString() {
        return "CityHourly{" +
                "dt=" + resolveHourFromEpoch(dt) + " " + dt + 
                ", curTemp=" + getFahrenheit(curTemp) +
                ", feelsLike=" + getFahrenheit(feelsLike) +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", dewPoint=" + getFahrenheit(dewPoint) +
                ", uvi=" + uvi +
                ", clouds=" + clouds +
                ", windSpeed=" + windSpeed +
                ", windDegrees=" + windDegrees +
                ", windGust=" + windGust +
                ", weatherId=" + weatherId +
                ", weatherMain='" + weatherMain + '\'' +
                ", weatherDesc='" + weatherDesc + '\'' +
                ", pop=" + pop +
                '}';
    }
    private int getFahrenheit(double k) {
        return (int) Math.rint((k - 273.15) * 9/5 + 32);
    }
    
    private String resolveHourFromEpoch(int epoch) {
        // Convert epoch time to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());
        
        // Format the hour part only
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:00");
        String hour = dateTime.format(formatter);
        
        return hour;
    }
    // Getters
    
    public double getPop() {return pop;}
    
    public int getDt() { return dt; }

    public double getCurTemp() { return curTemp; }

    public double getFeelsLike() { return feelsLike; }

    public int getPressure() { return pressure; }

    public int getHumidity() { return humidity; }

    public double getDewPoint() { return dewPoint; }

    public double getUvi() { return uvi; }

    public int getClouds() { return clouds; }

    public double getWindSpeed() { return windSpeed; }

    public int getWindDegrees() { return windDegrees; }

    public double getWindGust() { return windGust; }

    public int getWeatherId() { return weatherId; }

    public String getWeatherMain() { return weatherMain; }

    public String getWeatherDesc() { return weatherDesc; }
}

