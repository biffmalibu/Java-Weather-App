/*********************************************************************************************************************************
* File: SavedCitiesController.java                                                                                               *
* Author: Bradford Torpey                                                                                                        *
* Purpose: This file is used to control the saved cities window. It is used to display the saved cities and their weather data.  *
**********************************************************************************************************************************/
package c.finalweatherproject;

import static c.finalweatherproject.MainWinController.save;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class SavedCitiesController { // Controller for the saved cities window
    @FXML // FXML variables
    private Text cityNameLabel1;

    @FXML
    private Text cityNameLabel2;

    @FXML
    private Text cityNameLabel3;

    @FXML
    private Text dewpointLabel1;

    @FXML
    private Text dewpointLabel2;

    @FXML
    private Text dewpointLabel3;

    @FXML
    private Text feelsLikeLabel1;

    @FXML
    private Text feelsLikeLabel2;

    @FXML
    private Text feelsLikeLabel3;

    @FXML
    private Text highLowLabel1;

    @FXML
    private Text highLowLabel2;

    @FXML
    private Text highLowLabel3;

    @FXML
    private Text humidityLabel1;

    @FXML
    private Text humidityLabel2;

    @FXML
    private Text humidityLabel3;

    @FXML
    private Text tempLabel1;

    @FXML
    private Text tempLabel2;

    @FXML
    private Text tempLabel3;

    @FXML
    private Text uvDescLabel1;

    @FXML
    private Text uvDescLabel2;

    @FXML
    private Text uvDescLabel3;

    @FXML
    private Text uvindexLabel1;

    @FXML
    private Text uvindexLabel2;

    @FXML
    private Text uvindexLabel3;

    @FXML
    private Text weatherDescLabel1;

    @FXML
    private Text weatherDescLabel2;

    @FXML
    private Text weatherDescLabel3;

    @FXML
    private ImageView weatherImage1;

    @FXML
    private ImageView weatherImage2;

    @FXML
    private ImageView weatherImage3;

    @FXML
    private ImageView windDirection1;

    @FXML
    private ImageView windDirection2;

    @FXML
    private ImageView windDirection3;

    @FXML
    private Text windDirectionLabel1;

    @FXML
    private Text windDirectionLabel3;

    @FXML
    private Text windDirectionLabel2;

    @FXML
    private Text windGustLabel1;

    @FXML
    private Text windGustLabel2;

    @FXML
    private Text windGustLabel3;

    @FXML
    private Text windSpeedLabel1;
    
    @FXML
    private Text windSpeedLabel2;

    @FXML
    private Text windSpeedLabel3;

    @FXML
    private Text windUnits1;

    @FXML
    private Text windUnits2;

    @FXML
    private Text windUnits3;

    @FXML
    private Text windUnits4;

    @FXML
    private Text windUnits5;

    @FXML
    private Text windUnits6;
    
    /**
     * This method is used to initialize the saved cities window
     */
    @FXML
    void initialize() {
        ArrayList<Geolocation> citiesArrayList = save.getSavedCities(); // Arraylist of geolocations representing saved cities
        for (int i = 0; i < 6; i++) { // Loop through the wind units and apply the correct units
            try {
                String windUnits = "windUnits" + (i + 1); // Construct the field name dynamically
                Text wind = (Text) getClass().getDeclaredField(windUnits).get(this); // Access the Text using reflection
                String unit;
                if (save.getDistance().equals("MI")) // Check if the distance units are in miles
                    unit = "MPH";
                else    
                    unit = "KMH";
                wind.setText(unit);
            } catch(Exception e) { // Catch any exceptions
                System.out.println("Error applying distance units"); 
            }
        }
        int k = 2;
        for (int i = 0; i < 3; i++) { // Loop through the saved cities backwords to display the most recent cities first
            Geolocation curCity = citiesArrayList.get(k);
            k--;
            try {
                CityData cities = WeatherAPIDriver.PopulateCityInfo(curCity.getLat(), curCity.getLon()); // Get the city data
                String cityName = "cityNameLabel" + (i + 1); // Construct the field names dynamically
                String weatherDescLabel = "weatherDescLabel" + (i + 1);
                String highLowLabel = "highLowLabel" + (i + 1);
                String tempLabelText = "tempLabel" + (i + 1);
                String feelsLikeLabel = "feelsLikeLabel" + (i + 1);
                String humidityLabel = "humidityLabel" + (i + 1);
                String dewpointLabel = "dewpointLabel" + (i + 1);
                String windDirection = "windDirection" + (i + 1);
                String windDirectionLabel = "windDirectionLabel" + (i + 1);
                String windSpeedLabel = "windSpeedLabel" + (i + 1);
                String windGustLabel = "windGustLabel" + (i + 1);
                String uvindexLabel = "uvindexLabel" + (i + 1);
                String uvDescLabel = "uvDescLabel" + (i + 1);
                
                
                Text city = (Text) getClass().getDeclaredField(cityName).get(this); // Access the Texts using reflection
                Text weatherDesc = (Text) getClass().getDeclaredField(weatherDescLabel).get(this);
                Text highLow = (Text) getClass().getDeclaredField(highLowLabel).get(this);
                Text temperature = (Text) getClass().getDeclaredField(tempLabelText).get(this);
                Text feelsLike = (Text) getClass().getDeclaredField(feelsLikeLabel).get(this);
                Text dewpoint = (Text) getClass().getDeclaredField(dewpointLabel).get(this);
                Text humidity = (Text) getClass().getDeclaredField(humidityLabel).get(this);
                ImageView windDir = (ImageView) getClass().getDeclaredField(windDirection).get(this);
                Text windDirectionText = (Text) getClass().getDeclaredField(windDirectionLabel).get(this);
                Text windSpeed = (Text) getClass().getDeclaredField(windSpeedLabel).get(this);
                Text windGust = (Text) getClass().getDeclaredField(windGustLabel).get(this);
                Text uvindex = (Text) getClass().getDeclaredField(uvindexLabel).get(this);
                Text uvDesc = (Text) getClass().getDeclaredField(uvDescLabel).get(this);
                
                city.setText(curCity.getCityName()); // Set the city name
                String desc = cities.getWeatherMain(); // Get the weather description
                weatherDesc.setText(desc.substring(0, 1).toUpperCase() + desc.substring(1)); // Set the weather description
                double windDeg = (cities.getWindDegrees() + 180) % 360; // Get the wind direction
                humidity.setText("Humidity: " + cities.getHumidity() + "%"); // Set the humidity
                double speed = cities.getWindSpeed(); // Get the wind speed
                double gust = cities.getWindGust(); // Get the wind gust
                windDir.setRotate(windDeg); // Set the wind direction rotation
                windDirectionText.setText(getWindDirection(windDeg)); // Set the wind direction text
                DecimalFormat f = new DecimalFormat("##.00"); // Format the wind speed and gust
                if (save.getDistance().equals("MI")) { // Check if the distance units are in miles
                    speed = speed * 2.23694; // Convert the wind speed to mph
                    gust = gust * 2.23694; // Convert the wind gust to mph
                }
                else {
                    speed = speed * 3.6; // Convert the wind speed to km/h
                    gust = gust * 3.6; // Convert the wind gust to km/h
                }
                windSpeed.setText(f.format(speed)); // Set the wind speed
                windGust.setText(f.format(gust)); // Set the wind gust
                double uvi = cities.getUvi(); // Get the UV index
                uvindex.setText(String.valueOf(uvi)); // Set the UV index
                uvDesc.setText(getUVDesc(uvi)); // Set the UV description
                String unit;
                if (save.getDegreeUnits().equals("F")) { // Check if the degree units are in Fahrenheit
                    unit = "°F"; // Set climate units to Fahrenheit
                    highLow.setText("H: " + getFahrenheit(cities.getTempMax()) + unit + "     L: " + getFahrenheit(cities.getTempMin()) + unit);
                    temperature.setText(getFahrenheit(cities.getCurTemp()) + unit);
                    feelsLike.setText("Feels like: " + getFahrenheit(cities.getFeelsLike()) + unit);
                    dewpoint.setText("Dew point: " + getFahrenheit(cities.getDewPoint()) + unit);
                }
                else { // If the degree units are in Celsius
                    unit = "°C"; // Set climate units to Celsius
                    highLow.setText("H: " + getCelsius(cities.getTempMax()) + unit + "     L: " + getCelsius(cities.getTempMin()) + unit);
                    temperature.setText(getCelsius(cities.getCurTemp()) + unit);
                    feelsLike.setText("Feels like: " + getCelsius(cities.getFeelsLike()) + unit);
                    dewpoint.setText("Dew point: " + getCelsius(cities.getDewPoint()) + unit);
                }
                

                // Set the weather image based on the weather description
                String imageType = "";
                int curTime = cities.getDt();
                int sunrise = cities.getSunrise();
                int sunset = cities.getSunset();
                boolean isDaytime = curTime > sunrise && curTime < sunset; // Check if it is daytime
                if (cities.getWeatherMain().equals("Clear")) { // Check if the weather is clear
                    if (isDaytime) { // Check if it is daytime
                        imageType = "sun.png"; // Set the image to the sun
                    } else {
                        imageType = "moon.png"; // Set the image to the moon
                    }
                }
                if (cities.getWeatherMain().equals("Clouds")) { // Check if the weather is cloudy
                    if (cities.getWeatherDesc().equals("overcast clouds")) // Check if the weather is overcast
                        imageType = "clouds.png"; // Set the image to clouds
                    else {
                        if (isDaytime) // Check if it is daytime
                            imageType = "partlycloudy.png"; // Set the image to partly cloudy
                        else    
                            imageType = "partiallynight.png"; // Set the image to partially cloudy at night
                    }

                } else if (cities.getWeatherMain().equals("Rain")) { // Check if the weather is rainy
                    imageType = "rain.png";
                } else if (cities.getWeatherMain().equals("Thunderstorm")) { // Check if the weather is a thunderstorm
                    imageType = "lightning.png";
                } else if (cities.getWeatherMain().equals("Drizzle")) { // Check if the weather is drizzling
                    imageType = "drizzle.png";
                } else if (cities.getWeatherMain().equals("Snow")) { // Check if the weather is snowy
                    imageType = "snow.png";
                }
                // Construct the field name dynamically
                String weatherImage = "weatherImage" + (i + 1);

                try {
                    // Access the ImageView using reflection
                    ImageView imageView = (ImageView) getClass().getDeclaredField(weatherImage).get(this);

                    // Construct the file path
                    File file = new File("src/main/resources/c/finalweatherproject/images/" + imageType);

                    // Check if file exists before attempting to load the image
                    if (file.exists()) {
                        Image image = new Image(file.toURI().toString());
                        imageView.setImage(image);
                    } else {
                        System.out.println("File not found: " + file.getAbsolutePath());
                    }
                } catch (Exception e) { // Catch any exceptions
                    e.printStackTrace();
                }
            } catch(Exception e) {}

        }
    }
    /**
     * This method is used to open the main window with the selected city
     * @param windowNum - The window number to open
     */
    @FXML
    void openMainWindow(int windowNum) { // Open the main window with the selected city
        save.setGeolocation(save.getSavedCities().get(windowNum)); // Set the geolocation to the selected city
        SaveState.updateFile(); // Update the save file
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("primary.fxml")); // Load the primary fxml file

            Stage stage = App.getStage();
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            stage.setTitle("Weather Info");
            stage.setScene(scene);
            stage.setResizable(false); // Disable resizing
            stage.show(); // Show the stage
        } catch (IOException e) {
            System.out.println("Error loading primary.fxml");
        }
    }
    @FXML
    void openMain1() { // Open the main window with the first city
        openMainWindow(2);
    }
    @FXML
    void openMain2() { // Open the main window with the second city
        openMainWindow(1);
    }
    @FXML
    void openMain3() { // Open the main window with the third city
        openMainWindow(0);
    }

    /**
     * This method is used to get the UV description based on the UV index
     * @param uvi - The UV index
     * @return String - The UV description
     */
    private String getUVDesc(double uvi) {
        if (uvi >= 0 && uvi < 3) {
            return "Low";
        } else if (uvi <= 6) {
            return "Moderate";
        } else if (uvi <= 8) {
            return "High";
        } else if (uvi <= 10) {
            return "Very High";
        } else {
            return "Extreme";
        }
    }
    /**
     * This method is used to get the wind direction based on the wind degrees
     * @param deg - The wind degrees
     * @return String - The wind direction
     */
    private String getWindDirection(double deg) {
        int direction = (int) ((deg + 11.25) % 360) / 45;
        String windDirection;
        switch (direction) {
            case 0:
            case 8:
                windDirection = "N";
                break;
            case 1:
                windDirection = "NE";
                break;
            case 2:
                windDirection = "E";
                break;
            case 3:
                windDirection = "SE";
                break;
            case 4:
                windDirection = "S";
                break;
            case 5:
                windDirection = "SW";
                break;
            case 6:
                windDirection = "W";
                break;
            case 7:
                windDirection = "NW";
                break;
            default:
                windDirection = "";
                break;
        }
        return windDirection;
    }
    /**
     * This method is used to convert Kelvin to Fahrenheit
     * @param k - The temperature in Kelvin
     * @return int - The temperature in Fahrenheit
     */
    private int getFahrenheit(double k) {
        return (int) Math.rint((k - 273.15) * 9/5 + 32);
    }
    /**
     * This method is used to convert Kelvin to Celsius
     * @param k - The temperature in Kelvin
     * @return int - The temperature in Celsius
     */
    private int getCelsius(double k) {
        return (int) Math.rint(k - 273.15);
    }
}
