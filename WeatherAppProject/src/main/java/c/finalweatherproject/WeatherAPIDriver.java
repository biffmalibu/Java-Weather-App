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

    public static CityData PopulateCityInfo(double latitude, double longitude) {
        JsonObject jsonObject = getWeatherApiResponse(latitude, longitude);
        ArrayList<CityHourly> cityHourlyArrayList = new ArrayList<>();
        ArrayList<CityDaily> cityDailyArrayList = new ArrayList<>();

        if (jsonObject != null) {
            JsonObject current = jsonObject.getAsJsonObject("current");
            JsonArray weatherArray = current.getAsJsonArray("weather");
            JsonObject weatherObject = weatherArray.get(0).getAsJsonObject();

            int weatherId = weatherObject.get("id").getAsInt();
            String weatherMain = weatherObject.get("main").getAsString();
            String weatherDescription = weatherObject.get("description").getAsString();
            
            JsonArray hourlyArray = jsonObject.getAsJsonArray("hourly");

            for (int i = 0; i < hourlyArray.size(); i++) {
                JsonObject hourlyForecast = hourlyArray.get(i).getAsJsonObject();
                weatherArray = hourlyForecast.getAsJsonArray("weather");
                weatherObject = weatherArray.get(0).getAsJsonObject();

                weatherId = weatherObject.get("id").getAsInt();
                weatherMain = weatherObject.get("main").getAsString();
                weatherDescription = weatherObject.get("description").getAsString();

                CityHourly cityHourly = new CityHourly(
                        hourlyForecast.get("dt").getAsInt(),
                        hourlyForecast.get("temp").getAsDouble(),
                        hourlyForecast.get("feels_like").getAsDouble(),
                        hourlyForecast.get("pressure").getAsInt(),
                        hourlyForecast.get("humidity").getAsInt(),
                        hourlyForecast.get("dew_point").getAsDouble(),
                        hourlyForecast.get("uvi").getAsDouble(),
                        hourlyForecast.get("clouds").getAsInt(),
                        hourlyForecast.get("visibility").getAsInt(),
                        hourlyForecast.get("wind_speed").getAsDouble(),
                        hourlyForecast.get("wind_deg").getAsInt(),
                        hourlyForecast.get("wind_gust").getAsDouble(),
                        weatherId,
                        weatherMain,
                        weatherDescription,
                        hourlyForecast.get("pop").getAsDouble()
                );
                cityHourlyArrayList.add(cityHourly);
            }
            
            JsonArray dailyArray = jsonObject.getAsJsonArray("daily");
            for (int i = 0; i < dailyArray.size(); i++) {
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

                CityDaily cityDaily = new CityDaily(
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

            CityData cityData = new CityData(
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
            System.out.println("Failed to fetch weather data from the API.");
            return null;
        }
    }
    
    private static JsonObject getWeatherApiResponse(double latitude, double longitude) {
        try {
            String apiUrl = "https://api.openweathermap.org/data/3.0/onecall" +
                    "?lat=" + latitude +
                    "&lon=" + longitude +
                    "&exclude=minutely" +
                    "&appid=7c05796f88fd31c9a19e5cc4d7b951d7";
            System.out.println("URL: " + apiUrl);
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

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            connection.disconnect();

            return jsonObject;

        } catch (Exception e) {
            System.out.println("API Error while retrieving: lat: " + latitude + " long: " + longitude);
            e.printStackTrace();
        }
        return null;
    }
    private static Geolocation getGeoLocationFromZip(String zip) {
        try {
            String apiUrl = "https://api.openweathermap.org/geo/1.0/zip?zip=" + zip + "&appid=7c05796f88fd31c9a19e5cc4d7b951d7";
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

    private static Geolocation getGeoLocationFromCity(String city) {
        try {
            String apiUrl = "https://api.openweathermap.org/geo/1.0/direct?q=" + city + "&appid=7c05796f88fd31c9a19e5cc4d7b951d7";
            URL url = new URL(apiUrl);
            System.out.println(apiUrl);
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

            Gson gson = new Gson();
            JsonElement jsonElement = JsonParser.parseString(jsonResponse);

            if (jsonElement.isJsonArray()) {
                JsonArray jsonArray = jsonElement.getAsJsonArray();
                if (jsonArray.size() > 0) {
                    JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                    String name = jsonObject.get("name").getAsString();
                    String country = jsonObject.get("country").getAsString();
                    String state = jsonObject.has("state") ? jsonObject.get("state").getAsString() : "";
                    Double lat = jsonObject.get("lat").getAsDouble();
                    Double lon = jsonObject.get("lon").getAsDouble();
                    return new Geolocation(name, country, state, lat, lon);
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
            return getGeoLocationFromCity(input);
        }
    }
}

