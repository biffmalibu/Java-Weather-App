
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
    private int windGust;
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
                    int windGust, double tempMin, double tempMax, int weatherId, String weatherMain, String weatherDesc,
                    ArrayList<CityHourly> hourlyData, ArrayList<CityDaily> dailyData) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.curTemp = curTemp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.dewPoint = dewPoint;
        this.uvi = uvi;
        this.clouds = clouds;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windDegrees = windDegrees;
        this.windGust = windGust;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.weatherId = weatherId;
        this.weatherMain = weatherMain;
        this.weatherDesc = weatherDesc;
        this.hourlyData = hourlyData;
        this.dailyData = dailyData;
    }
    public void printCityData() {
        System.out.println("City Data:");
        System.out.println("----------");
        System.out.println("Date and Time (dt): " + dt);
        System.out.println("Sunrise: " + sunrise);
        System.out.println("Sunset: " + sunset);
        System.out.println("Current Temperature: " + curTemp);
        System.out.println("Feels Like: " + feelsLike);
        System.out.println("Pressure: " + pressure);
        System.out.println("Humidity: " + humidity);
        System.out.println("Dew Point: " + dewPoint);
        System.out.println("UV Index (uvi): " + uvi);
        System.out.println("Cloud Cover: " + clouds);
        System.out.println("Visibility: " + visibility);
        System.out.println("Wind Speed: " + windSpeed);
        System.out.println("Wind Degrees: " + windDegrees);
        System.out.println("Wind Gust: " + windGust);
        System.out.println("Minimum Temperature: " + tempMin);
        System.out.println("Maximum Temperature: " + tempMax);
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

    public int getWindGust() { return windGust; }
    
    public double getTempMin() { return tempMin; }
    
    public double getTempMax() { return tempMax; }

    public int getWeatherId() { return weatherId; }

    public String getWeatherMain() { return weatherMain; }

    public String getWeatherDesc() { return weatherDesc; }

    public ArrayList<CityHourly> getHourlyData() { return hourlyData; }
    
    public ArrayList<CityDaily> getDailyData() { return dailyData; }
    
}

