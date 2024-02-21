import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bradf
 */
import java.util.ArrayList;
import org.json.simple.parser.JSONParser;

public class WeatherAPIDriver {
    
    public static CityData PopulateCityInfo(double latitude, double longitude) {
        JSONObject jsonObject = getWeatherApiResponse(latitude, longitude);

        if (jsonObject != null) {
            
            JSONObject current = (JSONObject)jsonObject.get("current");
            JSONArray weatherArray = (JSONArray) current.get("weather");

            JSONObject weatherObject = (JSONObject) weatherArray.get(0);
            
            Long weatherIdLong = (Long) weatherObject.get("id");
            int weatherId = weatherIdLong.intValue();
            String weatherMain = (String) weatherObject.get("main");
            String weatherDescription = (String) weatherObject.get("description");
            CityData cityData = new CityData(
                    getInt(current, "dt"),
                    getInt(current, "sunrise"),
                    getInt(current, "sunset"),
                    (Double) current.get("temp"),
                    (Double) current.get("feels_like"),
                    getInt(current, "pressure"),
                    getInt(current, "humidity"),
                    getInt(current, "dew_point"),
                    getInt(current, "uvi"),
                    getInt(current, "clouds"),
                    getInt(current, "visibility"),
                    getInt(current, "wind_speed"),
                    getInt(current, "wind_deg"),
                    getInt(current, "wind_gust"),
                    30, // placeholders
                    40,
                    weatherId,
                    weatherMain,
                    weatherDescription,
                    new ArrayList<>(), 
                    new ArrayList<>()  
            );

            JSONArray hourlyArray = (JSONArray) jsonObject.get("hourly");
           
            for (int i = 0; i < hourlyArray.size(); i++) {
                JSONObject hourlyForecast = (JSONObject) hourlyArray.get(i);
                weatherArray = (JSONArray) hourlyForecast.get("weather");

                weatherObject = (JSONObject) weatherArray.get(0);

                weatherIdLong = (Long) weatherObject.get("id");
                weatherId = weatherIdLong.intValue();
            
                weatherMain = (String) weatherObject.get("main");
                weatherDescription = (String) weatherObject.get("description");
                CityHourly cityHourly = new CityHourly(
                        getInt(hourlyForecast, "dt"),
                        (Double) hourlyForecast.get("temp"),
                        getInt(hourlyForecast, "feels_like"),
                        getInt(hourlyForecast, "pressure"),
                        getInt(hourlyForecast, "humidity"),
                        getInt(hourlyForecast, "dew_point"),
                        getInt(hourlyForecast, "uvi"),
                        getInt(hourlyForecast, "clouds"),
                        getInt(hourlyForecast, "visibility"),
                        getInt(hourlyForecast, "wind_speed"),
                        getInt(hourlyForecast, "wind_deg"),
                        (Double) hourlyForecast.get("wind_gust"),
                        weatherId,
                        weatherMain,
                        weatherDescription
                );
                cityData.getHourlyData().add(cityHourly);
            }

            JSONArray dailyArray = (JSONArray) jsonObject.get("daily");
            for (int i = 0; i < dailyArray.size(); i++) {
                JSONObject dailyForecast = (JSONObject) dailyArray.get(i);
                JSONObject tempObject = (JSONObject) dailyForecast.get("temp"); 
                
                Double tempday = (Double) tempObject.get("day");
                Double tempmin = (Double) tempObject.get("min");
                Double tempmax = (Double) tempObject.get("max");
                Double tempnight = (Double) tempObject.get("night");
                Double tempeve = (Double) tempObject.get("eve");
                Double tempmorn = (Double) tempObject.get("morn");
                
                JSONObject feelslikeObject = (JSONObject) dailyForecast.get("feels_like");
                Double feelslikeday = (Double) feelslikeObject.get("day");
                Double feelslikenight = (Double) feelslikeObject.get("night");
                Double feelslikeeve = (Double) feelslikeObject.get("eve");
                Double feelslikemorn = (Double) feelslikeObject.get("morn");
                
                JSONArray weather = (JSONArray) dailyForecast.get("weather");
                weatherObject = (JSONObject) weather.get(0);
                weatherMain = (String) weatherObject.get("main");
                weatherDescription = (String) weatherObject.get("description");
                CityDaily cityDaily = new CityDaily(
                        getInt(dailyForecast, "dt"),
                        getInt(dailyForecast, "sunrise"),
                        getInt(dailyForecast, "sunset"),
                        getInt(dailyForecast, "moonrise"),
                        getInt(dailyForecast, "moonset"),
                        (Double) dailyForecast.get("moon_phase"),
                        (String) dailyForecast.get("summary"),
                        tempday,
                        tempmin,
                        tempmax,
                        tempnight,
                        tempeve,
                        tempmorn,
                        feelslikeday,
                        feelslikenight,
                        feelslikeeve,
                        feelslikemorn,
                        getInt(dailyForecast, "pressure"),
                        getInt(dailyForecast, "humidity"),
                        (Double) dailyForecast.get("dew_point"),
                        (Double) dailyForecast.get("wind_speed"),
                        getInt(dailyForecast, "wind_deg"),
                        (Double) dailyForecast.get("wind_gust"),
                        weatherMain,
                        weatherDescription,
                        getInt(dailyForecast, "clouds"),
                        getInt(dailyForecast, "uvi")
                );
                cityData.getDailyData().add(cityDaily);
            }
        return cityData;

        } else {
            System.out.println("Failed to fetch weather data from the API.");
            return null;
        }
    }
    private static JSONObject getWeatherApiResponse(double latitude, double longitude) {
        try {
            String apiUrl = "https://api.openweathermap.org/data/3.0/onecall" +
                    "?lat=" + latitude +
                    "&lon=" + longitude +
                    "&exclude=minutely" +
                    "&appid=7c05796f88fd31c9a19e5cc4d7b951d7";
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString();
            System.out.println(jsonResponse);


            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);


            connection.disconnect();

            return jsonObject;
            
        } catch (Exception e) {
            System.out.println("API Error while retreiving: lat: " + latitude + " long: " + longitude);
        }
        return null;
    }
    private static int getInt(JSONObject obj, String key) {
        Object value = obj.get(key);
        if (value instanceof Number) {
            return ((Number) value).intValue();
        } else {
            return 0;
            //throw new IllegalArgumentException("Value for key '" + key + "' is not a number.");
        }
    }
    
}
