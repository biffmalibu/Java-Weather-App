package c.finalweatherproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWinController {
    
    private static CityData city;
    public static SaveState save;
    private static Stage stage = new Stage();
    
    @FXML
    private CheckBox kmCheck;

    @FXML
    private CheckBox miCheck;
    
    @FXML
    private Text feelsLikeLabel;
    
    @FXML
    private Text dewPointLabel;
    
    @FXML
    private Text humidityLabel;
    
    @FXML
    private Text hour1;
    
    @FXML 
    private CheckBox fCheck;
    
    @FXML 
    private CheckBox cCheck;

    @FXML
    private Text hour10;

    @FXML
    private Text hour11;

    @FXML
    private Text hour12;

    @FXML
    private Text hour13;

    @FXML
    private Text hour14;

    @FXML
    private Text hour15;

    @FXML
    private Text hour16;

    @FXML
    private Text hour17;

    @FXML
    private Text hour18;

    @FXML
    private Text hour19;

    @FXML
    private Text hour2;

    @FXML
    private Text hour20;

    @FXML
    private Text hour21;

    @FXML
    private Text hour22;

    @FXML
    private Text hour23;

    @FXML
    private Text hour24;

    @FXML
    private Text hour25;

    @FXML
    private Text hour26;

    @FXML
    private Text hour27;

    @FXML
    private Text hour28;

    @FXML
    private Text hour29;

    @FXML
    private Text hour3;

    @FXML
    private Text hour30;

    @FXML
    private Text hour31;

    @FXML
    private Text hour32;

    @FXML
    private Text hour33;

    @FXML
    private Text hour34;

    @FXML
    private Text hour35;

    @FXML
    private Text hour36;

    @FXML
    private Text hour37;

    @FXML
    private Text hour4;

    @FXML
    private Text hour5;

    @FXML
    private Text hour6;

    @FXML
    private Text hour7;

    @FXML
    private Text hour8;

    @FXML
    private Text hour9;

    @FXML
    private Text hourly1;

    @FXML
    private Text hourly10;

    @FXML
    private Text hourly11;

    @FXML
    private Text hourly12;

    @FXML
    private Text hourly13;

    @FXML
    private Text hourly14;

    @FXML
    private Text hourly15;

    @FXML
    private Text hourly16;

    @FXML
    private Text hourly17;

    @FXML
    private Text hourly18;

    @FXML
    private Text hourly19;

    @FXML
    private Text hourly2;

    @FXML
    private Text hourly20;

    @FXML
    private Text hourly21;

    @FXML
    private Text hourly22;

    @FXML
    private Text hourly23;

    @FXML
    private Text hourly24;

    @FXML
    private Text hourly25;

    @FXML
    private Text hourly26;

    @FXML
    private Text hourly27;

    @FXML
    private Text hourly28;

    @FXML
    private Text hourly29;

    @FXML
    private Text hourly3;

    @FXML
    private Text hourly30;

    @FXML
    private Text hourly31;

    @FXML
    private Text hourly32;

    @FXML
    private Text hourly33;

    @FXML
    private Text hourly34;

    @FXML
    private Text hourly35;

    @FXML
    private Text hourly36;

    @FXML
    private Text hourly37;

    @FXML
    private Text hourly4;

    @FXML
    private Text hourly5;

    @FXML
    private Text hourly6;

    @FXML
    private Text hourly7;

    @FXML
    private Text hourly8;

    @FXML
    private Text hourly9;
    
     @FXML
    private Text cityNameLabel;

    @FXML
    private Text lowHighLabel;

    @FXML
    private TextField search;
    
    @FXML
    private Button savedCitiesButton;
    
    @FXML
    private Text temperatureLabel;

    @FXML
    private Text weatherLabel;
    
    @FXML
    private Text updatedLabel;
    
    @FXML
    private Button goButton;
    
    @FXML
    private Button saveButton;
    
    @FXML
    private ImageView img1;

    @FXML
    private ImageView img10;

    @FXML
    private ImageView img11;

    @FXML
    private ImageView img12;

    @FXML
    private ImageView img13;

    @FXML
    private ImageView img14;

    @FXML
    private ImageView img15;

    @FXML
    private ImageView img16;

    @FXML
    private ImageView img17;

    @FXML
    private ImageView img18;

    @FXML
    private ImageView img19;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img20;

    @FXML
    private ImageView img21;

    @FXML
    private ImageView img22;

    @FXML
    private ImageView img23;

    @FXML
    private ImageView img24;

    @FXML
    private ImageView img25;

    @FXML
    private ImageView img26;

    @FXML
    private ImageView img27;

    @FXML
    private ImageView img28;

    @FXML
    private ImageView img29;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img30;

    @FXML
    private ImageView img31;

    @FXML
    private ImageView img32;

    @FXML
    private ImageView img33;

    @FXML
    private ImageView img34;

    @FXML
    private ImageView img35;

    @FXML
    private ImageView img36;

    @FXML
    private ImageView img37;

    @FXML
    private ImageView img4;

    @FXML
    private ImageView img5;

    @FXML
    private ImageView img6;

    @FXML
    private ImageView img7;
    
    @FXML
    private ImageView img8;
    
    @FXML
    private ImageView img9;
    
    @FXML
    private Text day1;

    @FXML
    private Text day2;

    @FXML
    private Text day3;

    @FXML
    private Text day4;

    @FXML
    private Text day5;

    @FXML
    private Text day6;

    @FXML
    private Text day7;

    @FXML
    private Text day8;
    
      @FXML
    private ImageView dimg1;

    @FXML
    private ImageView dimg2;

    @FXML
    private ImageView dimg3;

    @FXML
    private ImageView dimg4;

    @FXML
    private ImageView dimg5;

    @FXML
    private ImageView dimg6;

    @FXML
    private ImageView dimg7;

    @FXML
    private ImageView dimg8;
    
    @FXML
    private Text high1;

    @FXML
    private Text high2;

    @FXML
    private Text high3;

    @FXML
    private Text high4;

    @FXML
    private Text high5;

    @FXML
    private Text high6;

    @FXML
    private Text high7;

    @FXML
    private Text high8;
    
    @FXML
    private Text low1;

    @FXML
    private Text low2;

    @FXML
    private Text low3;

    @FXML
    private Text low4;

    @FXML
    private Text low5;

    @FXML
    private Text low6;

    @FXML
    private Text low7;

    @FXML
    private Text low8;
    
    @FXML
    private Text pop1;

    @FXML
    private Text pop2;

    @FXML
    private Text pop3;

    @FXML
    private Text pop4;

    @FXML
    private Text pop5;

    @FXML
    private Text pop6;

    @FXML
    private Text pop7;

    @FXML
    private Text pop8;
    
    @FXML
    private Text sunsetLabel;
    
    @FXML
    private Text sunriseLabel;
    
    @FXML
    private Text moonriseLabel;
    
    @FXML
    private Text moonsetLabel;
    
    @FXML
    private ImageView winddirectionIMG;
    
    @FXML
    private Text windspeedLabel;
    
    @FXML
    private Text gustLabel;
    
    @FXML
    private Text winddirectionLabel;
    
    @FXML
    private Text pressureLabel;
    
    @FXML
    private Text uvLabelNum;
    
    @FXML
    private Text uvLabelDesc;
    
    @FXML
    private Text visibilityDescLabel;
    
    @FXML
    private Text visibilityLabel;
    

    @FXML
    void initialize() throws IOException {
        File file = new File("src\\main\\resources\\c\\finalweatherproject\\save.txt");
        ArrayList<Geolocation> savedCities = getDefaultSavedCities();
        if (!file.exists()) {
            save = new SaveState(WeatherAPIDriver.getGeoLocation("Boston"), "F", false, "MI", savedCities); // Fill save with default values
            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // Write default values to file
            writer.write(save.getGeolocation().toString());
            writer.write('F');
            writer.write("\nfalse");
            writer.write("\nMI\n");
            for (int i = 0; i < 3; i++) {
                writer.write(savedCities.get(i).toString());
            }
            fCheck.setSelected(true);
            miCheck.setSelected(true);

            writer.close();
        }
        else {
            try {
                FileReader fr = new FileReader(file); 
                BufferedReader reader = new BufferedReader(fr);

                String name = reader.readLine();
                String country = reader.readLine();
                String state = reader.readLine();
                Double lat = Double.parseDouble(reader.readLine());
                Double lon = Double.parseDouble(reader.readLine());
                String deg = reader.readLine();
                boolean fullTime = Boolean.parseBoolean(reader.readLine());
                String distance = reader.readLine();

                Geolocation geolocation = new Geolocation(name, country, state, lat, lon);
                ArrayList<Geolocation> cities = new ArrayList<>();
                for(int i = 0; i < 3; i++) {
                    name = reader.readLine();
                    country = reader.readLine();
                    state = reader.readLine();
                    lat = Double.parseDouble(reader.readLine());
                    lon = Double.parseDouble(reader.readLine());
                    Geolocation savedLocation = new Geolocation(name, country, state, lat, lon);
                    cities.add(savedLocation);
                }
                reader.close();
                save = new SaveState(geolocation, deg, fullTime, distance, cities);

                if (save.getDegreeUnits().equals("F")) /// replace here with settings file 
                    fCheck.setSelected(true);
                else
                    cCheck.setSelected(true);

                if (save.getDistance().equals("MI")) /// replace here with settings file 
                    miCheck.setSelected(true);
                else
                    kmCheck.setSelected(true);
            } catch(Exception e) {
                save = new SaveState(WeatherAPIDriver.getGeoLocation("Boston"), "F", false, "MI", getDefaultSavedCities()); // Fill save with default values
                BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // Write default values to file
                writer.write(save.getGeolocation().toString());
                writer.write('F');
                writer.write("\nfalse");
                writer.write("\nMI\n");
                for (int i = 0; i < 3; i++) {
                    writer.write(savedCities.get(i).toString());
                }

                writer.close();
            }
        }
        Geolocation location = save.getGeolocation();
        city = WeatherAPIDriver.PopulateCityInfo(location.getLat(), location.getLon());
        updateLabels();
       
    }


   
   @FXML 
    void fClicked(ActionEvent event) {
        if (cCheck.isSelected()) {
            cCheck.setSelected(false);
        }
        save.setDegreeUnits("F");
        SaveState.updateFile();
        updateTempLabels();
    }
    @FXML 
    void cClicked(ActionEvent event) {
        if (fCheck.isSelected()) {
            fCheck.setSelected(false);
        }
        save.setDegreeUnits("C");
        SaveState.updateFile();
        updateTempLabels();
    }
    
    
    @FXML 
    void miClicked() {
        if (kmCheck.isSelected()) {
            kmCheck.setSelected(false);
        }
         
        save.setDistance("MI");
        SaveState.updateFile();
        updateDistanceLabels();
        
    }
    
    @FXML 
    void kmClicked() {
        if (miCheck.isSelected()) {
            miCheck.setSelected(false);
        }
        save.setDistance("KM");
        SaveState.updateFile();
        updateDistanceLabels();
    }
    @FXML
    void openSavedCities(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("tertiary.fxml"));

            Scene scene = new Scene(fxmlLoader.load(), 680, 500);
            stage.setTitle("Saved Cities");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
            
            
    @FXML
    void updateCity() {
        try {
            Geolocation location;
            location = WeatherAPIDriver.getGeoLocation(search.getText());
            
            city = WeatherAPIDriver.PopulateCityInfo(location.getLat(), location.getLon());
            city.printCityData();
            save.setGeolocation(location);
            SaveState.updateFile();
            updateLabels();
            
        } catch (NullPointerException e) {
            // do something here
            search.setText("Error parsing input.");
        }
    }
    @FXML
    void saveCity() {
        SaveState.addSavedCity(save.getGeolocation());
    }
    private ArrayList<Geolocation> getDefaultSavedCities() {
        ArrayList<Geolocation> cities = new ArrayList<>();

        cities.add(new Geolocation("Paris", "Ile-de-France", "FR", 48.8589, 2.32));
        cities.add(new Geolocation("New York County", "New York", "US", 40.7127, -74.006));
        cities.add(new Geolocation("London", "England", "GB", 51.5073, -0.1276));
        
        return cities;
    }
    private void updateLabels() {
        Geolocation location = save.getGeolocation();
        if (!location.getState().equals(""))
            cityNameLabel.setText(location.getCityName() + ", " + location.getState() + ", " + location.getCountry());
        else 
            cityNameLabel.setText(location.getCityName() + ", " + location.getCountry());
        updatedLabel.setText("Updated: " + getDateFromEpoch(city.getDt()));
        humidityLabel.setText("Humidity: " + city.getHumidity() + "%");
        String main = city.getWeatherMain();
        weatherLabel.setText(main);
        if (main.equals("Clouds"))
            if (!city.getWeatherDesc().equals("overcast clouds")) 
                weatherLabel.setText("Partly Cloudy");

        
        addImages();
        updateTempLabels();

        
        sunsetLabel.setText("Sunset: " + resolveTimeAMPM(city.getDailyData().get(0).getSunset()));
        sunriseLabel.setText("Sunrise: " + resolveTimeAMPM(city.getDailyData().get(0).getSunrise()));
        moonsetLabel.setText("Moonset: " + resolveTimeAMPM(city.getDailyData().get(0).getMoonset()));
        moonriseLabel.setText("Moonrise: " + resolveTimeAMPM(city.getDailyData().get(0).getMoonrise()));
        
        pressureLabel.setText(city.getPressure() + " mbar");
        uvLabelNum.setText(String.valueOf(city.getUvi()));
        uvLabelDesc.setText(getUVDesc(city.getUvi()));
        
        updateDistanceLabels();
        updateDayOfWeekLabels();
        
    }
    private void updateDayOfWeekLabels() {
        day1.setText("Today");
        for(int i = 1; i < 8; i++) {
            try {
                String dayLabel = "day" + (i + 1);
                Text day = (Text) getClass().getDeclaredField(dayLabel).get(this);
                day.setText(getDayOfWeek(city.getDailyData().get(i).getDt()));
            } catch (Exception e) {}
        }
    }
    private void updateDistanceLabels() {
        updateVisibility();
        updateWindInfo();
    }
    private void updateVisibility() {
        int vis = city.getVisibility();
        visibilityDescLabel.setText(getVisibilityDesc(vis));
        
        if (save.getDistance().equals("KM")) {
            if (vis != 10000)
                visibilityLabel.setText(vis/1000 + "Km");
            else
                visibilityLabel.setText("10+ Km");
        }
        else {
            if (vis > 9656)
                visibilityLabel.setText("6+ MI");
            else {
                DecimalFormat f = new DecimalFormat("##.00");
                visibilityLabel.setText(f.format(vis * 0.000621371) + " MI");
            }
        }
    }
    private void updateWindInfo() {
        double deg = (city.getWindDegrees() + 180) % 360;
        double speed = city.getWindSpeed();
        double gust = city.getWindGust();
        String unit = "";
        winddirectionLabel.setText(getWindDirection(deg) + ", " + String.format("%.0f", deg) + "°");
        winddirectionIMG.setRotate(deg);
        DecimalFormat f = new DecimalFormat("##.00");
        if (save.getDistance().equals("MI")) {
            unit = " MPH";
            speed = speed * 2.23694;
            gust = gust * 2.23694;
        }
        else {
            unit = " KMH";
            speed = speed * 3.6;
            gust = gust * 3.6;
        }
        windspeedLabel.setText("Wind " + f.format(speed) + unit);
        gustLabel.setText("Gust: " + f.format(gust) + unit);
    }
    
    private void updateTempLabels() {
        if(save.getDegreeUnits().equals("F")) {
            updateHourlyFieldsF();
            updateTempFieldsF();
            updateDailyTempLabelsF();
        }
        else {
            updateHourlyFieldsC();
            updateTempFieldsC();
            updateDailyTempLabelsC();
        }
    }
   
    private String getVisibilityDesc(int visibility) {
        visibility = visibility /1000;
        if (visibility >= 0 && visibility <= 3)
            return "Limited Visibility";
        else if (visibility < 6) 
            return "Fair Visibility";
        if (visibility < 10) 
            return "Clear View";
        else
            return "Perfectly Clear";
            
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
    
    private void updateDailyTempLabelsF() {
        ArrayList<CityDaily> cityDaily = city.getDailyData();
        for (int i = 0; i < 8; i++) {
            try {
                String highText = "high" + (i + 1);
                String lowText = "low" + (i + 1);
                Text high = (Text) getClass().getDeclaredField(highText).get(this);
                Text low = (Text) getClass().getDeclaredField(lowText).get(this);
                high.setText(getFahrenheit(cityDaily.get(i).getTempMax()) + "°F");
                low.setText(getFahrenheit(cityDaily.get(i).getTempMin()) + "°F");
            } catch(Exception e) {}

        }
    }
    private void updateDailyTempLabelsC() {
        ArrayList<CityDaily> cityDaily = city.getDailyData();
        high1.setText(city.getTempMax() + "°C");
        high1.setText(city.getTempMin() + "°C");
        for (int i = 1; i < 8; i++) {
            try {
                String highText = "high" + (i);
                String lowText = "low" + (i);
                Text high = (Text) getClass().getDeclaredField(highText).get(this);
                Text low = (Text) getClass().getDeclaredField(lowText).get(this);
                high.setText(getCelsius(cityDaily.get(i).getTempMax()) + "°C");
                low.setText(getCelsius(cityDaily.get(i).getTempMin()) + "°C");
            } catch(Exception e) {}

        }
    }
    private void updateTempFieldsF() {
        String fahrenheit = "°F";
        temperatureLabel.setText(getFahrenheit(city.getCurTemp()) + fahrenheit);
        lowHighLabel.setText("H: " + getFahrenheit(city.getTempMax()) + fahrenheit + "    L: " + getFahrenheit(city.getTempMin()) + fahrenheit);
        dewPointLabel.setText("Dew Point: " + getFahrenheit(city.getDewPoint())+ fahrenheit);
        feelsLikeLabel.setText("Feels Like: " + getFahrenheit(city.getFeelsLike()) + fahrenheit);
    }
    private void updateTempFieldsC() {
        String celsius = "°C";
        temperatureLabel.setText(getCelsius(city.getCurTemp()) + celsius);
        lowHighLabel.setText("H: " + getCelsius(city.getTempMax()) + celsius + "    L: " + getCelsius(city.getTempMin()) + celsius);
        dewPointLabel.setText("Dew Point: " + getCelsius(city.getDewPoint()) + celsius);
        feelsLikeLabel.setText("Feels Like: " + getCelsius(city.getFeelsLike()) + celsius);
    }
    private void updateHourlyFieldsF() {
        try {
        ArrayList<CityHourly> cityHourly = city.getHourlyData();

        for (int i = 0; i < 37; i++) {
            String hourlyText = "hourly" + (i + 1);
            String hourText = "hour" + (i + 1);

            Text hourly = (Text) getClass().getDeclaredField(hourlyText).get(this);
            Text hour = (Text) getClass().getDeclaredField(hourText).get(this);

            hourly.setText(getFahrenheit(cityHourly.get(i).getCurTemp()) + "°F");
            hour.setText(resolveHourFromEpoch(cityHourly.get(i).getDt()));
        }
        } catch(Exception e) {}
    }
    private void updateHourlyFieldsC() {
        try {
        ArrayList<CityHourly> cityHourly = city.getHourlyData();

        for (int i = 0; i < 37; i++) {
            String hourlyText = "hourly" + (i + 1);
            String hourText = "hour" + (i + 1);

            Text hourly = (Text) getClass().getDeclaredField(hourlyText).get(this);
            Text hour = (Text) getClass().getDeclaredField(hourText).get(this);

            hourly.setText(getCelsius(cityHourly.get(i).getCurTemp()) + "°C");
            hour.setText(resolveHourFromEpoch(cityHourly.get(i).getDt()));
        }
        } catch(Exception e) {}
    }
    
    private String getWindDirection(double deg) {
        int direction = (int) ((deg + 11.25) % 360) / 45;
        String windDirection;
        switch (direction) {
            case 0:
            case 8:
                windDirection = "North";
                break;
            case 1:
                windDirection = "Northeast";
                break;
            case 2:
                windDirection = "East";
                break;
            case 3:
                windDirection = "Southeast";
                break;
            case 4:
                windDirection = "South";
                break;
            case 5:
                windDirection = "Southwest";
                break;
            case 6:
                windDirection = "West";
                break;
            case 7:
                windDirection = "Northwest";
                break;
            default:
                windDirection = "";
                break;
        }
        return windDirection;
    }
    
    private String resolveTimeAMPM(int epoch) {
        // Convert epoch time to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());

        // Format the hour part only
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String hour = dateTime.format(formatter);

        return hour;
    }
    private String resolveHourFromEpoch(int epoch) {
        // Convert epoch time to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());

        // Format the hour part only
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:00");
        String hour = dateTime.format(formatter);

        return hour;
    }
    
    private void addImages() {
        ArrayList<CityHourly> cityHourly = city.getHourlyData();
        ArrayList<CityDaily> cityDaily = city.getDailyData();
        Thread hourlyImagesThread = new Thread(() -> {
            for (int i = 0; i < 37; i++) {
                String imageType = "";
                int curTime = cityHourly.get(i).getDt();
                int sunrise = city.getSunrise();
                int sunset = city.getSunset();
                if (curTime > sunset) {
                    sunset = cityDaily.get(1).getSunset();
                    sunrise = cityDaily.get(1).getSunrise();
                }
                boolean isDaytime = curTime > sunrise && curTime < sunset;
                if (cityHourly.get(i).getWeatherMain().equals("Clear")) {
                    if (isDaytime) {
                        imageType = "sun.png";
                    } else {
                        imageType = "moon.png";
                    }
                }
                if (cityHourly.get(i).getWeatherMain().equals("Clouds")) {
                    if (cityHourly.get(i).getWeatherDesc().equals("overcast clouds"))
                        imageType = "clouds.png";
                    else {
                        if (isDaytime)
                            imageType = "partlycloudy.png";
                        else    
                            imageType = "partiallynight.png";
                    }

                } else if (cityHourly.get(i).getWeatherMain().equals("Rain")) {
                    imageType = "rain.png";
                } else if (cityHourly.get(i).getWeatherMain().equals("Thunderstorm")) {
                    imageType = "lightning.png";
                } else if (cityHourly.get(i).getWeatherMain().equals("Drizzle")) {
                    imageType = "drizzle.png";
                } else if (cityHourly.get(i).getWeatherMain().equals("Snow")) {
                    imageType = "snow.png";
                }
                // Construct the field name dynamically
                String imgFieldName = "img" + (i + 1);

                try {
                    // Access the ImageView using reflection
                    ImageView imageView = (ImageView) getClass().getDeclaredField(imgFieldName).get(this);

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
            }
        });
        hourlyImagesThread.start();
        Thread dailyImagesThread = new Thread(() -> {
            for (int i = 0; i < 8; i++) {
                String imageType = "";
                String weatherMain = cityDaily.get(i).getWeatherMain();
                try {
                    String popText = "pop" + (i + 1);
                    Text pop = (Text) getClass().getDeclaredField(popText).get(this);
                    Double popNum = 100 * cityDaily.get(i).getPop();
                    if(popNum == 0 || !weatherMain.equals("Rain"))
                        pop.setText("");
                    else
                        pop.setText(String.format("%.0f", popNum) + "%");
                } catch (Exception e) {}
                if (weatherMain.equals("Clear")) {
                    imageType = "clouds.png";
                }
                else if (weatherMain.equals("Rain")) {
                    imageType = "rain.png";
                }
                else if (weatherMain.equals("Clouds")) {
                    imageType = "clouds.png";
                }
                else if (weatherMain.equals("Snow")) {
                    imageType = "snow.png";
                }
                else if (weatherMain.equals("Thunderstorm")) {
                    imageType = "lightning.png";
                }
                else if (weatherMain.equals("Drizzle")) {
                    imageType = "drizzle.png";
                }

                String imgFieldName = "dimg" + (i + 1);

                try {
                    ImageView imageView = (ImageView) getClass().getDeclaredField(imgFieldName).get(this);

                    File file = new File("src/main/resources/c/finalweatherproject/images/" + imageType);

                    if (file.exists()) {
                        Image image = new Image(file.toURI().toString());
                        imageView.setImage(image);
                    } else {
                        System.out.println("File not found: " + file.getAbsolutePath());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dailyImagesThread.start();
    }
    public static String getDayOfWeek(long epochSeconds) {
        // Convert epoch time to LocalDateTime
        Instant instant = Instant.ofEpochSecond(epochSeconds);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        // Get the day of the week from LocalDateTime
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();

        // Return the day of the week with only the first letter capitalized
        return dayOfWeek.toString().substring(0, 1) + dayOfWeek.toString().substring(1).toLowerCase();
    }
}
