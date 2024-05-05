package c.finalweatherproject;

import static c.finalweatherproject.MainWinController.save;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class SavedCitiesController {
    @FXML
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
    
    @FXML
    void initialize() {
        ArrayList<Geolocation> citiesArrayList = save.getSavedCities(); // Arraylist of geolocations representing saved cities
        for (int i = 0; i < 6; i++) {
            try {
                String windUnits = "windUnits" + (i + 1);
                Text wind = (Text) getClass().getDeclaredField(windUnits).get(this);
                String unit;
                if (save.getDistance().equals("MI"))
                    unit = "MPH";
                else    
                    unit = "KMH";
                wind.setText(unit);
            } catch(Exception e) {
                System.out.println("Error applying distance units");
            }
        }
        int k = 2;
        for (int i = 0; i < 3; i++) {
            Geolocation curCity = citiesArrayList.get(k);
            k--;
            try {
                CityData cities = WeatherAPIDriver.PopulateCityInfo(curCity.getLat(), curCity.getLon());
                String cityName = "cityNameLabel" + (i + 1);
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
                
                
                Text city = (Text) getClass().getDeclaredField(cityName).get(this);
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
                
                city.setText(curCity.getCityName());
                String desc = cities.getWeatherMain();
                weatherDesc.setText(desc.substring(0, 1).toUpperCase() + desc.substring(1));
                double windDeg = (cities.getWindDegrees() + 180) % 360;
                humidity.setText("Humidity: " + cities.getHumidity() + "%");
                double speed = cities.getWindSpeed();
                double gust = cities.getWindGust();
                windDir.setRotate(windDeg);
                windDirectionText.setText(getWindDirection(windDeg));
                DecimalFormat f = new DecimalFormat("##.00");
                if (save.getDistance().equals("MI")) {
                    speed = speed * 2.23694;
                    gust = gust * 2.23694;
                }
                else {
                    speed = speed * 3.6;
                    gust = gust * 3.6;
                }
                windSpeed.setText(f.format(speed));
                windGust.setText(f.format(gust));
                double uvi = cities.getUvi();
                uvindex.setText(String.valueOf(uvi));
                uvDesc.setText(getUVDesc(uvi));
                String unit;
                if (save.getDegreeUnits().equals("F")) {
                    unit = "°F";
                    highLow.setText("H: " + getFahrenheit(cities.getTempMax()) + unit + "     L: " + getFahrenheit(cities.getTempMin()) + unit);
                    temperature.setText(getFahrenheit(cities.getCurTemp()) + unit);
                    feelsLike.setText("Feels like: " + getFahrenheit(cities.getFeelsLike()) + unit);
                    dewpoint.setText("Dew point: " + getFahrenheit(cities.getDewPoint()) + unit);
                }
                else {
                    unit = "°C";
                    highLow.setText("H: " + getCelsius(cities.getTempMax()) + unit + "     L: " + getCelsius(cities.getTempMin()) + unit);
                    temperature.setText(getCelsius(cities.getCurTemp()) + unit);
                    feelsLike.setText("Feels like: " + getCelsius(cities.getFeelsLike()) + unit);
                    dewpoint.setText("Dew point: " + getCelsius(cities.getDewPoint()) + unit);
                }
                

                
                String imageType = "";
                int curTime = cities.getDt();
                int sunrise = cities.getSunrise();
                int sunset = cities.getSunset();
                if (curTime > sunset) {
                    sunset = cities.getSunset();
                    sunrise = cities.getSunrise();
                }
                boolean isDaytime = curTime > sunrise && curTime < sunset;
                if (cities.getWeatherMain().equals("Clear")) {
                    if (isDaytime) {
                        imageType = "sun.png";
                    } else {
                        imageType = "moon.png";
                    }
                }
                if (cities.getWeatherMain().equals("Clouds")) {
                    if (cities.getWeatherDesc().equals("overcast clouds"))
                        imageType = "clouds.png";
                    else {
                        if (isDaytime)
                            imageType = "partlycloudy.png";
                        else    
                            imageType = "partiallynight.png";
                    }

                } else if (cities.getWeatherMain().equals("Rain")) {
                    imageType = "rain.png";
                } else if (cities.getWeatherMain().equals("Thunderstorm")) {
                    imageType = "lightning.png";
                } else if (cities.getWeatherMain().equals("Drizzle")) {
                    imageType = "drizzle.png";
                } else if (cities.getWeatherMain().equals("Snow")) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch(Exception e) {}

        }
    }
    @FXML
    void openMainWindow(int windowNum) {
        save.setGeolocation(save.getSavedCities().get(windowNum));
        SaveState.updateFile();
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("primary.fxml"));

            Stage stage = App.getStage();
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            stage.setTitle("Weather Info");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
    @FXML
    void openMain1() {
        openMainWindow(2);
    }
    @FXML
    void openMain2() {
        openMainWindow(1);
    }
    @FXML
    void openMain3() {
        openMainWindow(0);
    }
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
    private int getFahrenheit(double k) {
        return (int) Math.rint((k - 273.15) * 9/5 + 32);
    }
    private int getCelsius(double k) {
        return (int) Math.rint(k - 273.15);
    }
}
