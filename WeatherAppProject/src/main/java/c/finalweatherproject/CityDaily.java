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
public class CityDaily {
    private int dt;
    private int sunrise;
    private int sunset;
    private int moonrise;
    private int moonset;
    private double moonphase;
    private String summary;
    private double temp;
    private double tempMin;
    private double tempMax;
    private double tempNight;
    private double tempEve;
    private double tempMorn;
    private double feelsLikeDay;
    private double feelsLikeNight;
    private double feelsLikeEve;
    private double feelsLikeMorn;
    private int pressure;
    private int humidity;
    private double dewPoint;
    private double windSpeed;
    private int windDeg;
    private double windGust;
    private String weatherMain;
    private String weatherDesc;
    private int clouds;
    private double uvi;

    // Constructor
    public CityDaily(int dt, int sunrise, int sunset, int moonrise, int moonset, double moonphase, String summary,
                     double temp, double tempMin, double tempMax, double tempNight, double tempEve,
                     double tempMorn, double feelsLikeDay, double feelsLikeNight, double feelsLikeEve,
                     double feelsLikeMorn, int pressure, int humidity, double dewPoint, double windSpeed,
                     int windDeg, double windGust, String weatherMain, String weatherDesc, int clouds, double uvi) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moonrise = moonrise;
        this.moonset = moonset;
        this.moonphase = moonphase;
        this.summary = summary;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.tempNight = tempNight;
        this.tempEve = tempEve;
        this.tempMorn = tempMorn;
        this.feelsLikeDay = feelsLikeDay;
        this.feelsLikeNight = feelsLikeNight;
        this.feelsLikeEve = feelsLikeEve;
        this.feelsLikeMorn = feelsLikeMorn;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.windGust = windGust;
        this.weatherMain = weatherMain;
        this.weatherDesc = weatherDesc;
        this.clouds = clouds;
        this.uvi = uvi;
    }
    
    @Override
    public String toString() {
        return "CityDaily{" +
                "dt=" + resolveHourFromEpoch(dt) +
                ", sunrise=" + resolveHourFromEpoch(sunrise) + " " + sunrise +
                ", sunset=" + resolveHourFromEpoch(sunset) + " " + sunset +
                ", moonrise=" + resolveHourFromEpoch(moonrise) +
                ", moonset=" + resolveHourFromEpoch(moonset) +
                ", moonphase=" + moonphase +
                ", summary='" + summary + '\'' +
                ", temp=" + getFahrenheit(temp) +
                ", tempMin=" + getFahrenheit(tempMin) +
                ", tempMax=" + getFahrenheit(tempMax) +
                ", tempNight=" + getFahrenheit(tempNight) +
                ", tempEve=" + getFahrenheit(tempEve) +
                ", tempMorn=" + getFahrenheit(tempMorn) +
                ", feelsLikeDay=" + getFahrenheit(feelsLikeDay) +
                ", feelsLikeNight=" + getFahrenheit(feelsLikeNight) +
                ", feelsLikeEve=" + getFahrenheit(feelsLikeEve) +
                ", feelsLikeMorn=" + getFahrenheit(feelsLikeMorn) +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", dewPoint=" + dewPoint +
                ", windSpeed=" + windSpeed +
                ", windDeg=" + windDeg +
                ", windGust=" + windGust +
                ", weatherMain='" + weatherMain + '\'' +
                ", weatherDesc='" + weatherDesc + '\'' +
                ", clouds=" + clouds +
                ", uvi=" + uvi +
                '}';
    }
    private String resolveHourFromEpoch(int epoch) {
        // Convert epoch time to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(epoch),
                ZoneId.systemDefault()
        );
        
        // Format the hour and minute parts
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm");
        String hour = dateTime.format(formatter);
        
        return hour;
    }
    private int getFahrenheit(double k) {
        return (int) Math.rint((k - 273.15) * 9/5 + 32);
    }
    // Getters
    public int getSunrise() { return sunrise; }

    public int getSunset() { return sunset; }

    public int getMoonrise() { return moonrise; }

    public int getMoonset() { return moonset; }

    public double getMoonphase() { return moonphase; }

    public String getSummary() { return summary; }

    public double getTemp() { return temp; }

    public double getTempMin() { return tempMin; }

    public double getTempMax() { return tempMax; }

    public double getTempNight() { return tempNight; }

    public double getTempEve() { return tempEve; }

    public double getTempMorn() { return tempMorn; }

    public double getFeelsLikeDay() { return feelsLikeDay; }

    public double getFeelsLikeNight() { return feelsLikeNight; }

    public double getFeelsLikeEve() { return feelsLikeEve; }

    public double getFeelsLikeMorn() { return feelsLikeMorn; }

    public int getPressure() { return pressure; }

    public int getHumidity() { return humidity; }

    public double getDewPoint() { return dewPoint; }

    public double getWindSpeed() { return windSpeed; }

    public int getWindDeg() { return windDeg; }

    public double getWindGust() { return windGust; }

    public String getWeatherMain() { return weatherMain; }

    public String getWeatherDesc() { return weatherDesc; }

    public int getClouds() { return clouds; }

    public double getUvi() { return uvi; }
}

