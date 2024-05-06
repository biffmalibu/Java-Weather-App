/*********************************************************************************************************************************
* File: WeatherAPIDriver.java                                                                                                    *
* Author: Bradford Torpey                                                                                                        *
* Purpose: This file is used to get the weather data from the OpenWeatherMap API and return the data when needed.                *            *
**********************************************************************************************************************************/
package c.finalweatherproject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class WeatherAPIDriver { 

    /**
     * This method is used to get the weather data of a city
     * @param latitude - The latitude of the city
     * @param longitude - The longitude of the city
     * @return CityData - The weather data of the city
     */
    public static CityData PopulateCityInfo(double latitude, double longitude) {
        JsonObject jsonObject = getWeatherApiResponse(latitude, longitude); // Get the weather data from the API
        ArrayList<CityHourly> cityHourlyArrayList = new ArrayList<>(); // Create an array list to store hourly and daily data
        ArrayList<CityDaily> cityDailyArrayList = new ArrayList<>();

        if (jsonObject != null) { // If the API call was successful
            JsonObject current = jsonObject.getAsJsonObject("current"); // Get the current weather data
            JsonArray weatherArray = current.getAsJsonArray("weather"); // Get the weather data
            JsonObject weatherObject = weatherArray.get(0).getAsJsonObject(); 

            int weatherId = weatherObject.get("id").getAsInt(); // Get the weather ID
            String weatherMain = weatherObject.get("main").getAsString(); // Get the weather main
            String weatherDescription = weatherObject.get("description").getAsString(); // Get the weather description
            
            JsonArray hourlyArray = jsonObject.getAsJsonArray("hourly"); // Get the hourly weather data

            for (int i = 0; i < hourlyArray.size(); i++) { // Loop through the hourly data
                JsonObject hourlyForecast = hourlyArray.get(i).getAsJsonObject();
                weatherArray = hourlyForecast.getAsJsonArray("weather");
                weatherObject = weatherArray.get(0).getAsJsonObject();

                weatherId = weatherObject.get("id").getAsInt();
                weatherMain = weatherObject.get("main").getAsString();
                weatherDescription = weatherObject.get("description").getAsString();

                CityHourly cityHourly = new CityHourly( // Create a new hourly object for each hour of the day and add it to the array list
                        hourlyForecast.get("dt").getAsInt(),
                        hourlyForecast.get("temp").getAsDouble(),
                        hourlyForecast.get("feels_like").getAsDouble(),
                        hourlyForecast.get("pressure").getAsInt(),
                        hourlyForecast.get("humidity").getAsInt(),
                        hourlyForecast.get("dew_point").getAsDouble(),
                        hourlyForecast.get("uvi").getAsDouble(),
                        hourlyForecast.get("clouds").getAsInt(),
                        hourlyForecast.get("wind_speed").getAsDouble(),
                        hourlyForecast.get("wind_deg").getAsInt(),
                        hourlyForecast.get("wind_gust").getAsDouble(),
                        weatherId,
                        weatherMain,
                        weatherDescription,
                        hourlyForecast.get("pop").getAsDouble()
                );
                cityHourlyArrayList.add(cityHourly); // Add the hourly object to the array list
            }
            
            JsonArray dailyArray = jsonObject.getAsJsonArray("daily"); // Get the daily weather data
            for (int i = 0; i < dailyArray.size(); i++) { // Loop through the daily data
                JsonObject dailyForecast = dailyArray.get(i).getAsJsonObject();
                JsonObject tempObject = dailyForecast.getAsJsonObject("temp");

                double tempday = tempObject.get("day").getAsDouble();
                double tempmin = tempObject.get("min").getAsDouble();
                double tempmax = tempObject.get("max").getAsDouble();
                double tempnight = tempObject.get("night").getAsDouble();
                double tempeve = tempObject.get("eve").getAsDouble();
                double tempmorn = tempObject.get("morn").getAsDouble();

                JsonObject feelslikeObject = dailyForecast.getAsJsonObject("feels_like");
                double feelslikeday = feelslikeObject.get("day").getAsDouble();
                double feelslikenight = feelslikeObject.get("night").getAsDouble();
                double feelslikeeve = feelslikeObject.get("eve").getAsDouble();
                double feelslikemorn = feelslikeObject.get("morn").getAsDouble();

                weatherArray = dailyForecast.getAsJsonArray("weather");
                weatherObject = weatherArray.get(0).getAsJsonObject();
                weatherMain = weatherObject.get("main").getAsString();
                weatherDescription = weatherObject.get("description").getAsString();

                CityDaily cityDaily = new CityDaily( // Create a new daily object for each day of the week and add it to the array list
                        dailyForecast.get("dt").getAsInt(),
                        dailyForecast.get("sunrise").getAsInt(),
                        dailyForecast.get("sunset").getAsInt(),
                        dailyForecast.get("moonrise").getAsInt(),
                        dailyForecast.get("moonset").getAsInt(),
                        dailyForecast.get("moon_phase").getAsDouble(),
                        dailyForecast.get("summary").getAsString(),
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
                        dailyForecast.get("pressure").getAsInt(),
                        dailyForecast.get("humidity").getAsInt(),
                        dailyForecast.get("dew_point").getAsDouble(),
                        dailyForecast.get("wind_speed").getAsDouble(),
                        dailyForecast.get("wind_deg").getAsInt(),
                        dailyForecast.get("wind_gust").getAsDouble(),
                        weatherMain,
                        weatherDescription,
                        dailyForecast.get("clouds").getAsInt(),
                        dailyForecast.get("uvi").getAsDouble(),
                        dailyForecast.get("pop").getAsDouble()
                        
                );
                cityDailyArrayList.add(cityDaily);
            }

            CityData cityData = new CityData( // Create a new city data object with the current weather data and the hourly and daily data
                    current.get("dt").getAsInt(),
                    current.get("sunrise").getAsInt(),
                    current.get("sunset").getAsInt(),
                    current.get("temp").getAsDouble(),
                    current.get("feels_like").getAsDouble(),
                    current.get("pressure").getAsInt(),
                    current.get("humidity").getAsInt(),
                    current.get("dew_point").getAsDouble(),
                    current.get("uvi").getAsDouble(),
                    current.get("clouds").getAsInt(),
                    current.get("visibility").getAsInt(),
                    current.get("wind_speed").getAsDouble(),
                    current.get("wind_deg").getAsInt(),
                    cityHourlyArrayList.get(0).getWindGust(),
                    cityDailyArrayList.get(0).getTempMin(),
                    cityDailyArrayList.get(0).getTempMax(),
                    weatherId,
                    weatherMain,
                    weatherDescription,
                    cityHourlyArrayList,
                    cityDailyArrayList
            );

            return cityData;

        } else {
            System.out.println("Failed to fetch weather data from the API."); // If the API call was unsuccessful
            return null;
        }
    }
    
    /**
     * This method is used to get the weather data of a city
     * @param latitude - The latitude of the city
     * @param longitude - The longitude of the city
     * @return JsonObject - The weather data of the city
     */
    private static JsonObject getWeatherApiResponse(double latitude, double longitude) { // Get the weather data from the API
        try {
            String apiUrl = "https://api.openweathermap.org/data/3.0/onecall" + // API URL
                    "?lat=" + latitude +
                    "&lon=" + longitude +
                    "&exclude=minutely" +
                    "&appid=7c05796f88fd31c9a19e5cc4d7b951d7";
            System.out.println(apiUrl);
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open a connection to the API
            connection.setRequestMethod("GET"); // Set the request method to GET 

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Read the data from the API
            StringBuilder response = new StringBuilder(); // Create a string builder to store the response
            String line;
            while ((line = reader.readLine()) != null) { // Loop through the response
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString(); // Convert the response to a string
            //System.out.println(jsonResponse);

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            connection.disconnect();

            return jsonObject;

        } catch (Exception e) { // If an error occurs
            System.out.println("API Error while retrieving: lat: " + latitude + " long: " + longitude);
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method is used to get the air quality data of a city
     * @param latitude - The latitude of the city
     * @param longitude - The longitude of the city
     * @return AQIData - The air quality data of the city
     */
    public static AQIData getAQIData(Double latitude, Double longitude) { 
        String apiUrl = "https://api.openweathermap.org/data/2.5/air_pollution" + // API URL
                        "?lat=" + latitude +
                        "&lon=" + longitude +
                        "&appid=7c05796f88fd31c9a19e5cc4d7b951d7";
        //System.out.println(apiUrl);

        try { // Get the air quality data from the API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open a connection to the API
            connection.setRequestMethod("GET"); // Set the request method to GET

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Read the data from the API
            StringBuilder response = new StringBuilder(); // Create a string builder to store the response
            String line;
            while ((line = reader.readLine()) != null) { // Loop through the response
                response.append(line);
            }
            reader.close();
            connection.disconnect();
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class); // Convert the response to a JSON object

            JsonArray list = jsonObject.getAsJsonArray("list");
            JsonObject firstItem = list.get(0).getAsJsonObject();

            JsonObject mainObject = firstItem.getAsJsonObject("main"); // Get the main air quality data
            int aqi = mainObject.get("aqi").getAsInt(); // Get the air quality index

            JsonObject componentsObject = firstItem.getAsJsonObject("components"); // Get the air quality components
            double co = componentsObject.get("co").getAsDouble();
            double no = componentsObject.get("no").getAsDouble();
            double no2 = componentsObject.get("no2").getAsDouble();
            double o3 = componentsObject.get("o3").getAsDouble();
            double so2 = componentsObject.get("so2").getAsDouble();
            double pm2_5 = componentsObject.get("pm2_5").getAsDouble();
            double pm10 = componentsObject.get("pm10").getAsDouble();
            double nh3 = componentsObject.get("nh3").getAsDouble();

            return new AQIData(aqi, co, no, no2, o3, so2, pm2_5, pm10, nh3);

        } catch (Exception e) { // If an error occurs
            return null;
        }
    }
    /**
     * This method is used to get the geolocation data of a city
     * @param zip - The zip code of the city
     * @return Geolocation - The geolocation data of the city
     */
    private static Geolocation getGeoLocationFromZip(String zip) {
        try {
            String apiUrl = "https://api.openweathermap.org/geo/1.0/zip?zip=" + zip + "&appid=7c05796f88fd31c9a19e5cc4d7b951d7"; // API URL
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open a connection to the API
            connection.setRequestMethod("GET"); // Set the request method to GET

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Read the data from the API
            StringBuilder response = new StringBuilder(); // Create a string builder to store the response
            String line;
            while ((line = reader.readLine()) != null) { // Loop through the response
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString(); // Convert the response to a string
            //System.out.println(jsonResponse);

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            String name = jsonObject.get("name").getAsString();
            String country = jsonObject.get("country").getAsString();
            String state = jsonObject.has("state") ? jsonObject.get("state").getAsString() : "";
            Double lat = jsonObject.get("lat").getAsDouble();
            Double lon = jsonObject.get("lon").getAsDouble();

            connection.disconnect();
            return new Geolocation(name, country, state, lat, lon);

        } catch (Exception e) {
            System.out.println("Zip GEO: API Error while retrieving: " + zip);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method is used to get the geolocation data of a city
     * @param city - The name of the city
     * @return Geolocation - The geolocation data of the city
     */
    private static Geolocation getGeoLocationFromCity(String city) {
        try {
            String apiUrl = "https://api.openweathermap.org/geo/1.0/direct?q=" + city + "&appid=7c05796f88fd31c9a19e5cc4d7b951d7"; // API URL
            URL url = new URL(apiUrl);
            System.out.println(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open a connection to the API
            connection.setRequestMethod("GET"); // Set the request method to GET

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Read the data from the API
            StringBuilder response = new StringBuilder(); // Create a string builder to store the response
            String line;
            while ((line = reader.readLine()) != null) { // Loop through the response
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString(); 
            //System.out.println(jsonResponse);

            Gson gson = new Gson();
            JsonElement jsonElement = JsonParser.parseString(jsonResponse);

            if (jsonElement.isJsonArray()) {  // Check if the JSON response is an array
                JsonArray jsonArray = jsonElement.getAsJsonArray(); 
                if (jsonArray.size() > 0) { // Check if the array has data
                    JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                    String name = jsonObject.get("name").getAsString();
                    String country = jsonObject.get("country").getAsString();
                    String state = jsonObject.has("state") ? jsonObject.get("state").getAsString() : "";
                    Double lat = jsonObject.get("lat").getAsDouble();
                    Double lon = jsonObject.get("lon").getAsDouble();
                    return new Geolocation(name, country, state, lat, lon); // Return the geolocation data
                } else {
                    System.out.println("No geolocation found for: " + city);
                }
            } else {
                System.out.println("Invalid JSON response: " + jsonResponse);
            }

            connection.disconnect();
        } catch (Exception e) {
            System.out.println("City GEO: API Error while retrieving: " + city);
           // e.printStackTrace();
        }
        return null;
    }
    /**
     * This method is used to get the geolocation data of a city
     * @param input - The input string
     * @return Geolocation - The geolocation data of the city
     */
    public static Geolocation getGeoLocation(String input) {
        if (input.matches("\\d{5}")) {
            // Zip code
            return getGeoLocationFromZip(input);
        } else if (input.matches("[a-zA-Z]+(\\s*,\\s*[a-zA-Z]+)+")) {
            // City, state/country
            String[] parts = input.split(",\\s*");
            if (parts.length > 1 && parts[1].length() == 2) {
                // If the second part is a two-letter state abbreviation, consider only the first part (city)
                return getGeoLocationFromCity(parts[0]);
            } else {
                return getGeoLocationFromCity(input);
            }
        } else {
            // City
            return getGeoLocationFromCity(input.replaceAll("\\s", "%20"));
            //return getGeoLocationFromCity(input);
        }
    }
}

