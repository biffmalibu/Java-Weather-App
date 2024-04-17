package c.finalweatherproject;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bradf
 */
import java.util.ArrayList;

public class CityData {
    private int dt;
    private int sunrise;
    private int sunset;
    private double curTemp;
    private double feelsLike;
    private int pressure;
    private int humidity;
    private double dewPoint;
    private double uvi;
    private int clouds;
    private int visibility;
    private double windSpeed;
    private int windDegrees;
    private double windGust;
    private double tempMin;
    private double tempMax;
    

    private int weatherId;
    private String weatherMain;
    private String weatherDesc;

    private ArrayList<CityHourly> hourlyData;
    private ArrayList<CityDaily> dailyData;

    // Constructor
    public CityData(int dt, int sunrise, int sunset, double curTemp, double feelsLike, int pressure, int humidity,
                    double dewPoint, double uvi, int clouds, int visibility, double windSpeed, int windDegrees,
                    double windGust, double tempMin, double tempMax, int weatherId, String weatherMain, String weatherDesc,
                    ArrayList<CityHourly> hourlyData, ArrayList<CityDaily> dailyData) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        
        CityHourly currentHour = hourlyData.get(0);
        this.curTemp = currentHour.getCurTemp();
        this.feelsLike = currentHour.getFeelsLike();
        this.pressure = currentHour.getPressure();
        this.humidity = currentHour.getHumidity();
        this.dewPoint = currentHour.getDewPoint();
        this.uvi = currentHour.getUvi();
        this.clouds = currentHour.getClouds();
        this.visibility = visibility;
        this.windSpeed = currentHour.getWindSpeed();
        this.windDegrees = currentHour.getWindDegrees();
        this.windGust = currentHour.getWindGust();
        
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.weatherId = weatherId;
        this.weatherMain = currentHour.getWeatherMain();
        this.weatherDesc = weatherDesc;
        this.hourlyData = hourlyData;
        this.dailyData = dailyData;
    }
    public void printCityData() {
        System.out.println("City Data:");
        System.out.println("----------");
        System.out.println("Date and Time (dt): " + resolveHourFromEpoch(dt));
        System.out.println("Sunrise: " + resolveHourFromEpoch(sunrise) + " " + sunrise);
        System.out.println("Sunset: " + resolveHourFromEpoch(sunset) + " " + sunset);
        System.out.println("Current Temperature: " + getFahrenheit(curTemp));
        System.out.println("Feels Like: " + getFahrenheit(feelsLike));
        System.out.println("Pressure: " + pressure);
        System.out.println("Humidity: " + humidity);
        System.out.println("Dew Point: " + getFahrenheit(dewPoint));
        System.out.println("UV Index (uvi): " + uvi);
        System.out.println("Cloud Cover: " + clouds);
        System.out.println("Visibility: " + visibility);
        System.out.println("Wind Speed: " + windSpeed);
        System.out.println("Wind Degrees: " + windDegrees);
        System.out.println("Wind Gust: " + windGust);
        System.out.println("Minimum Temperature: " + getFahrenheit(tempMin));
        System.out.println("Maximum Temperature: " + getFahrenheit(tempMax));
        System.out.println("Weather ID: " + weatherId);
        System.out.println("Weather Main: " + weatherMain);
        System.out.println("Weather Description: " + weatherDesc);
        System.out.println("Hourly Data:");
        for (CityHourly hourly : hourlyData) {
            System.out.println(hourly);
        }
        System.out.println("Daily Data:");
        for (CityDaily daily : dailyData) {
            System.out.println(daily);
        }
    }

    private String resolveHourFromEpoch(int epoch) {
        // Convert epoch time to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());
        
        // Format the hour part only
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm");
        String hour = dateTime.format(formatter);
        
        return hour;
    }
    private int getFahrenheit(double k) {
        return (int) Math.rint((k - 273.15) * 9/5 + 32);
    }
    // Getters
    public int getDt() { return dt; }

    public int getSunrise() { return sunrise; }

    public int getSunset() { return sunset; }

    public double getCurTemp() { return curTemp; }

    public double getFeelsLike() { return feelsLike; }

    public int getPressure() { return pressure; }

    public int getHumidity() { return humidity; }

    public double getDewPoint() { return dewPoint; }

    public double getUvi() { return uvi; }

    public int getClouds() { return clouds; }

    public int getVisibility() { return visibility; }

    public double getWindSpeed() { return windSpeed; }

    public int getWindDegrees() { return windDegrees; }

    public double getWindGust() { return windGust; }
    
    public double getTempMin() { return tempMin; }
    
    public double getTempMax() { return tempMax; }

    public int getWeatherId() { return weatherId; }

    public String getWeatherMain() { return weatherMain; }

    public String getWeatherDesc() { return weatherDesc; }

    public ArrayList<CityHourly> getHourlyData() { return hourlyData; }
    
    public ArrayList<CityDaily> getDailyData() { return dailyData; }
    
}

