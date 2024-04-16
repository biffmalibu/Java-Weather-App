package c.finalweatherproject;

import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PrimaryController {

     @FXML
    private Text cityNameLabel;

    @FXML
    private Text lowHighLabel;

    @FXML
    private TextField search;
    
    @FXML
    private Button settingsButton;
    
    @FXML
    private Text temperatureLabel;

    @FXML
    private Text weatherLabel;
    
    @FXML
    private Text updatedLabel;
    
    @FXML
    private Button goButton;

    @FXML
    void initWindow(ActionEvent event) {
        String degrees = "°F";
        double lat = 42.5584; //this should be changed to some start, saved location, if none is set, we could set it to boston
        double llong= -70.8800;
        CityData city = WeatherAPIDriver.PopulateCityInfo(lat, llong);
        city.printCityData();
        
        updatedLabel.setText("Updated: " + getDateFromEpoch(city.getDt()));
        temperatureLabel.setText(getFahrenheit(city.getCurTemp()) + degrees);
        weatherLabel.setText(city.getWeatherMain());
        lowHighLabel.setText("L: " + getFahrenheit(city.getTempMin()) + "°F    H: " + getFahrenheit(city.getTempMax()) + "°F");
    }
    @FXML
    void updateCity(ActionEvent event) {
        try {
            String fahrenheit = "°F";
            Geolocation location;
            location = WeatherAPIDriver.getGeoLocation(search.getText());
            CityData city = WeatherAPIDriver.PopulateCityInfo(location.getLat(), location.getLon());
            city.printCityData();

            cityNameLabel.setText(location.getCityName());
            updatedLabel.setText("Updated: " + getDateFromEpoch(city.getDt()));
            weatherLabel.setText(city.getWeatherMain());
            
            temperatureLabel.setText(getFahrenheit(city.getCurTemp()) + fahrenheit);
            lowHighLabel.setText("L: " + getFahrenheit(city.getTempMin()) + fahrenheit + "    H: " + getFahrenheit(city.getTempMax()) + fahrenheit);
            
            
        } catch (NullPointerException e) {
            // do something here
            search.setText("Error parsing input.");
        }
    }
    private int getFahrenheit(double k) {
        return (int) Math.rint((k - 273.15) * 9/5 + 32);
    }
    private int getCelsius(double k) {
        return (int) Math.rint(k - 273.15);
    }
    private Date getDateFromEpoch(int epochTimeSeconds) {
        long epoch = Long.parseLong(String.valueOf(epochTimeSeconds));
        return new Date(epoch * 1000);
    }
    
}
