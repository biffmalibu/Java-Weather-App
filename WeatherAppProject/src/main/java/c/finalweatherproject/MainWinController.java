/*********************************************************************************************************************************
* File: MainWinController.java                                                                                                   *
* Author: Bradford Torpey                                                                                                        *
* Purpose: This file is used to control the main weather window. It is used to display the saved city and its weather data.      *
**********************************************************************************************************************************/
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MainWinController {
    private ScheduledExecutorService scheduler; // Used for auto updates
    private long lastRefreshTime = 0;
    private static CityData city; // Create a static city object to store the city data
    public static SaveState save; // Create a static save object to store the save data
    private static Stage stage = new Stage(); // Create a stage variable to be able to access the stage from other classes
    
    // Create a bunch of FXML variables to be able to access the FXML elements
    @FXML 
    private Text summaryLabel;
    
    @FXML
    private Text cloudCoverLabel;
    
    @FXML 
    private Text aqiLevel;
    
    @FXML 
    private Text aqiLevelDesc;
    
    @FXML 
    private Text noLabel;
    
    @FXML 
    private Text coLabel;
    
    @FXML 
    private Text o3Label;
    
    @FXML 
    private Text no2Label;
    
    @FXML 
    private Text nh3Label;
    
    @FXML 
    private Text pm25Label;
    
    @FXML 
    private Text pm10Label;
    
    @FXML 
    private Text so2Label;
            
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
    private CheckBox autoUpdateCheck;

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
    private Text windUnits1;
    
    @FXML 
    private Text windUnits2;
    
   
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
    private Button refreshButton;
    

    /**
     * This method initializes the main window by loading the save file and populating the labels with the city data,
     * if the save file does not exist, it will create a new one with default values.
     * @throws IOException
     */
    @FXML
    void initialize() throws IOException {
        scheduler = Executors.newScheduledThreadPool(1);

        // Add listener to autoUpdateCheck
        autoUpdateCheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    startScheduledTask();
                } else {
                    stopScheduledTask();
                }
            }
        });

        // Start the task if autoUpdateCheck is already selected
        if (autoUpdateCheck.isSelected()) {
            startScheduledTask();
        }
        File file = new File("src\\main\\resources\\c\\finalweatherproject\\save.txt"); // Create a file object to access the save file
        ArrayList<Geolocation> savedCities = getDefaultSavedCities(); // Create an arraylist of saved cities with default values
        if (!file.exists()) { // If the file does not exist, create a new one with default values
            save = new SaveState(WeatherAPIDriver.getGeoLocation("Boston"), "F", "MI", false, savedCities); // Fill save with default values
            BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // Write default values to file
            writer.write(save.getGeolocation().toString());
            writer.write('F');
            writer.write("\nMI\n");
            writer.write("false\n");
            for (int i = 0; i < 3; i++) {
                writer.write(savedCities.get(i).toString());
            }
            fCheck.setSelected(true); // Set the default temperature unit to Fahrenheit
            miCheck.setSelected(true); // Set the default distance unit to Miles
            autoUpdateCheck.setSelected(false);

            writer.close(); // Close the writer
        }
        else { // If the file exists, read the values from the file and populate the save object with the values
            try {
                FileReader fr = new FileReader(file);  // Create a file reader object to read the file
                BufferedReader reader = new BufferedReader(fr); // Create a buffered reader object to read the file

                String name = reader.readLine(); // Read the current city data from the file
                String country = reader.readLine();
                String state = reader.readLine();
                Double lat = Double.parseDouble(reader.readLine());
                Double lon = Double.parseDouble(reader.readLine());
                String deg = reader.readLine(); // Read the temperature unit from the file
                String distance = reader.readLine();
                boolean autoUpdateStatus = Boolean.parseBoolean(reader.readLine());

                Geolocation geolocation = new Geolocation(name, country, state, lat, lon); // Create a new geolocation object with the read values
                ArrayList<Geolocation> cities = new ArrayList<>(); // Create an arraylist of geolocations to store the saved cities
                for(int i = 0; i < 3; i++) {
                    name = reader.readLine();
                    country = reader.readLine();
                    state = reader.readLine();
                    lat = Double.parseDouble(reader.readLine());
                    lon = Double.parseDouble(reader.readLine());
                    Geolocation savedLocation = new Geolocation(name, country, state, lat, lon);
                    cities.add(savedLocation); // Add the saved city to the arraylist
                }
                reader.close();
                save = new SaveState(geolocation, deg, distance, autoUpdateStatus, cities); // Populate the save object with the read values
                autoUpdateCheck.setSelected(save.getAutoUpdateStatus());
                if (save.getDegreeUnits().equals("F")) // Set the temperature unit to Fahrenheit if it is saved as Fahrenheit
                    fCheck.setSelected(true);
                else
                    cCheck.setSelected(true); // Set the temperature unit to Celsius if it is saved as Celsius

                if (save.getDistance().equals("MI")) // Set the distance unit to Miles if it is saved as Miles
                    miCheck.setSelected(true);
                else
                    kmCheck.setSelected(true); // Set the distance unit to Kilometers if it is saved as Kilometers
            } catch(Exception e) { // Catch any exceptions that occur while reading the file and create a new file with default values
                save = new SaveState(WeatherAPIDriver.getGeoLocation("Boston"), "F", "MI", false, getDefaultSavedCities()); // Fill save with default values
                BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // Write default values to file
                writer.write(save.getGeolocation().toString());
                writer.write('F');
                writer.write("\nMI\n");
                writer.write("false\n");
                for (int i = 0; i < 3; i++) { 
                    writer.write(savedCities.get(i).toString());
                }

                writer.close();
                fCheck.setSelected(true); // Set the default temperature unit to Fahrenheit
                miCheck.setSelected(true); // Set the default distance unit to Miles
                autoUpdateCheck.setSelected(false);
            }
        }
        Geolocation location = save.getGeolocation(); // Get the current city data from the save object
        city = WeatherAPIDriver.PopulateCityInfo(location.getLat(), location.getLon()); // Populate the city object with the current city data
        updateLabels(); // Update the labels with the current city data
       
    }


   @FXML 
   void searchClicked() {
       search.selectAll();
   
   }
   /**
    * This method sets the users auto update option upon being clicked. 
    */
   @FXML
   void autoUpdateCheckClicked() {
       save.setAutoUpdateStatus(autoUpdateCheck.isSelected());
       SaveState.updateFile();
   }
   /**
    * This method sets the temperature unit to Fahrenheit and updates the labels with the new temperature unit
    */
   @FXML 
    void fClicked() {
        if (cCheck.isSelected()) { // If the Celsius checkbox is selected, deselect it
            cCheck.setSelected(false);
        }
        save.setDegreeUnits("F"); // Set the temperature unit to Fahrenheit
        SaveState.updateFile(); // Update the save file with the new temperature unit
        updateTempLabels(); // Update the labels with the new temperature unit
    }
    /**
     * This method sets the temperature unit to Celsius and updates the labels with the new temperature unit
     */
    @FXML 
    void cClicked() {
        if (fCheck.isSelected()) { // If the Fahrenheit checkbox is selected, deselect it
            fCheck.setSelected(false); 
        }
        save.setDegreeUnits("C"); // Set the temperature unit to Celsius
        SaveState.updateFile(); // Update the save file with the new temperature unit
        updateTempLabels(); // Update the labels with the new temperature unit
    }
    
    /**
     * This method sets the distance unit to Miles and updates the labels with the new distance unit
     */
    @FXML 
    void miClicked() {
        if (kmCheck.isSelected()) { // If the Kilometers checkbox is selected, deselect it
            kmCheck.setSelected(false);
        }
         
        save.setDistance("MI"); // Set the distance unit to Miles
        SaveState.updateFile(); // Update the save file with the new distance unit
        updateDistanceLabels(); // Update the labels with the new distance unit
        
    }
    
    /**
     * This method sets the distance unit to Kilometers and updates the labels with the new distance unit
     */
    @FXML 
    void kmClicked() { 
        if (miCheck.isSelected()) { // If the Miles checkbox is selected, deselect it
            miCheck.setSelected(false);
        }
        save.setDistance("KM"); // Set the distance unit to Kilometers
        SaveState.updateFile(); // Update the save file with the new distance unit
        updateDistanceLabels(); // Update the labels with the new distance unit
    }

    /**
     * This method opens the saved cities window when the saved cities button is clicked
     */
    @FXML
    void openSavedCities() {
        if (stage.getScene() == null) { // If the stage is not open, open the saved cities window
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("tertiary.fxml")); // Load the saved cities fxml file

                Scene scene = new Scene(fxmlLoader.load(), 680, 500); // Create a new scene with the saved cities fxml file
                stage.setTitle("Saved Cities"); // Set the title of the stage
                stage.setScene(scene);
                stage.setOnHidden(events -> { // When the stage is closed, set the stage to null
                    stage.setScene(null);
                });
                stage.setResizable(false); // Disable resizing
                stage.show();
            } catch (IOException e) { // Catch any exceptions that occur while opening the saved cities window
                System.out.println("Error opening saved cities window");
            }
        }
    }
            
    /**
     * This method updates the city data with the new city data from the search bar
     */
    @FXML
    void updateCity() {
        try {
            Geolocation location;
            location = WeatherAPIDriver.getGeoLocation(search.getText()); // Get the new city data from the search bar
            
            city = WeatherAPIDriver.PopulateCityInfo(location.getLat(), location.getLon()); // Populate the city object with the new city data
            save.setGeolocation(location); // Set the save object's geolocation to the new city data
            SaveState.updateFile(); // Update the save file with the new city data
            App.getStage().setTitle(save.getGeolocation().getCityName() + " " + save.getGeolocation().getState() + ", " + save.getGeolocation().getCountry() + " Weather Info");
            updateLabels(); // Update the labels with the new city data
            lastRefreshTime = 0;
            
        } catch (NullPointerException e) { // Catch any exceptions that occur while updating the city data
            search.setText("Error updating city info");
        }
    }
    /*
     * Save the current city to the saved cities list
     */
    @FXML
    void saveCity() {
        SaveState.addSavedCity(save.getGeolocation());
    }
    
    /**
     * Refresh the city data
     */
    @FXML
    void refresh() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastRefreshTime < 5 * 60 * 1000) {
            return; // Skip if called within the last 5 minutes
        }
        lastRefreshTime = currentTime;

        try {
            System.out.println("Refreshing... API Called");
            city = WeatherAPIDriver.PopulateCityInfo(save.getGeolocation().getLat(), save.getGeolocation().getLon()); // Populate the city object with the current city data
            updateLabels(); // Update the labels with the new city data
        } catch (NullPointerException e) { // Catch any exceptions that occur while refreshing the city data
            search.setText("Error parsing input.");
        }
    }
    private void startScheduledTask() {
        scheduler.scheduleAtFixedRate(() -> {
            if (autoUpdateCheck.isSelected()) {
                refresh();
            }
        }, 0, 5, TimeUnit.MINUTES);
    }

    private void stopScheduledTask() {
        scheduler.shutdownNow();
        scheduler = Executors.newScheduledThreadPool(1); // Reinitialize the scheduler
    }
    /**
     * This method returns default saved cities to be used when the save file does not exist
     * @return ArrayList<Geolocation> - an arraylist of geolocations with default values
     */
    private ArrayList<Geolocation> getDefaultSavedCities() {
        ArrayList<Geolocation> cities = new ArrayList<>();

        cities.add(new Geolocation("Paris", "Ile-de-France", "FR", 48.8589, 2.32)); // Add Paris to the saved cities
        cities.add(new Geolocation("New York County", "New York", "US", 40.7127, -74.006)); // Add New York to the saved cities
        cities.add(new Geolocation("London", "England", "GB", 51.5073, -0.1276)); // Add London to the saved cities
        
        return cities;
    }
    /**
     * This method updates all the labels with the current city data
     */
    private void updateLabels() {
        Geolocation location = save.getGeolocation(); // Get the current city data from the save object
        if (!location.getState().equals("")) // If the state is not empty, set the city name label to the city name, state, and country
            cityNameLabel.setText(location.getCityName() + ", " + location.getState() + ", " + location.getCountry());
        else  // If the state is empty, set the city name label to the city name and country
            cityNameLabel.setText(location.getCityName() + ", " + location.getCountry());
        updatedLabel.setText("Updated: " + getDateFromEpoch(city.getDt())); // Set the updated label to the current date and time
        humidityLabel.setText("Humidity: " + city.getHumidity() + "%"); // Set the humidity label to the current humidity
        String main = city.getWeatherMain(); // Get the main weather description
        weatherLabel.setText(main); // Set the weather label to the main weather description
        if (main.equals("Clouds")) 
            if (!city.getWeatherDesc().equals("overcast clouds")) // If the weather description is not overcast clouds, set the weather label to partly cloudy
                weatherLabel.setText("Partly Cloudy");

        
        addImages(); // Add the weather images to the labels
        updateTempLabels(); // Update the temperature labels

        updateAQIData(); // Update the AQI data labels 
        sunsetLabel.setText("Sunset: " + resolveTimeAMPM(city.getDailyData().get(0).getSunset())); // Set the sun/moon rise/set labels to the correct times
        sunriseLabel.setText("Sunrise: " + resolveTimeAMPM(city.getDailyData().get(0).getSunrise()));
        moonsetLabel.setText("Moonset: " + resolveTimeAMPM(city.getDailyData().get(0).getMoonset()));
        moonriseLabel.setText("Moonrise: " + resolveTimeAMPM(city.getDailyData().get(0).getMoonrise()));
        
        pressureLabel.setText(city.getPressure() + " mbar"); // Set the pressure label to the current pressure
        uvLabelNum.setText(String.valueOf(city.getUvi())); // Set the UV label to the current UV index
        uvLabelDesc.setText(getUVDesc(city.getUvi())); // Set the UV description label to the current UV description
        
        updateDistanceLabels(); // Update the distance labels
        updateDayOfWeekLabels(); // Update the day of the week labels
        
        CityDaily daily = city.getDailyData().get(0);
        summaryLabel.setText(daily.getSummary() + ".");
        cloudCoverLabel.setText(daily.getClouds() + "%");
        
    }
    /**
     * Add the AQI data to the labels
     */
    private void updateAQIData() {
        Geolocation location = save.getGeolocation();
        AQIData data = WeatherAPIDriver.getAQIData(location.getLat(), location.getLon());
        aqiLevel.setText(String.valueOf(data.getMain()));
        aqiLevelDesc.setText(data.getMainDesc());
        coLabel.setText(String.valueOf(data.getCO()));
        noLabel.setText(String.valueOf(data.getNO()));
        no2Label.setText(String.valueOf(data.getNO2()));
        o3Label.setText(String.valueOf(data.getO3()));
        coLabel.setText(String.valueOf(data.getCO()));
        so2Label.setText(String.valueOf(data.getSO2()));
        pm25Label.setText(String.valueOf(data.getPM2_5()));
        pm10Label.setText(String.valueOf(data.getPM10()));
        nh3Label.setText(String.valueOf(data.getNH3()));
    }
    /**
     * This method populates the day of week labels with the correct day of the week
     */
    private void updateDayOfWeekLabels() {
        day1.setText("Today");
        for(int i = 1; i < 8; i++) {
            try {
                String dayLabel = "day" + (i + 1); // Use reflection to get the day of the week labels
                Text day = (Text) getClass().getDeclaredField(dayLabel).get(this); 
                day.setText(getDayOfWeek(city.getDailyData().get(i).getDt()));
            } catch (Exception e) {}
        }
    }
    /**
     * This method updates the visibility and wind labels with the correct distance unit
     */
    private void updateDistanceLabels() {
        updateVisibility();
        updateWindInfo();
    }
    /**
     * This method updates visibility labels with the correct visibility
     */
    private void updateVisibility() {
        int vis = city.getVisibility();
        visibilityDescLabel.setText(getVisibilityDesc(vis));
        
        if (save.getDistance().equals("KM")) { // If the distance unit is Kilometers, set the visibility label to the visibility in kilometers
            if (vis != 10000)
                visibilityLabel.setText(vis/1000 + "Km");
            else
                visibilityLabel.setText("10+ Km"); // Set to 10+ Km if the visibility is 10,000 meters
        }
        else { // If the distance unit is Miles, set the visibility label to the visibility in miles
            if (vis > 9656) // Set to 6 MI if the visibility is greater than 9656 meters
                visibilityLabel.setText("6+ MI");
            else {
                DecimalFormat f = new DecimalFormat("##.00"); // Set the visibility label to the visibility in miles
                visibilityLabel.setText(f.format(vis * 0.000621371) + " MI"); // Convert the visibility to miles
            }
        }
    }
    /**
     * Updates the wind labels with the correct wind data
     */
    private void updateWindInfo() {
        double deg = (city.getWindDegrees() + 180) % 360; // Invert the wind direction to match the compass
        double speed = city.getWindSpeed(); // Get the wind speed
        double gust = city.getWindGust(); // Get the wind gust
        String unit = "";
        winddirectionLabel.setText(getWindDirection(deg)); // Set the wind direction label to the wind direction
        winddirectionIMG.setRotate(deg); // Rotate the wind direction image to match the wind direction
        DecimalFormat f = new DecimalFormat("##.00"); // Set the wind speed and gust labels to the wind speed and gust
        if (save.getDistance().equals("MI")) { // If the distance unit is Miles, set the wind speed and gust labels to the wind speed and gust in MPH
            unit = "MPH";
            speed = speed * 2.23694; // Convert the wind speed to MPH
            gust = gust * 2.23694; // Convert the wind gust to MPH
        }
        else { // If the distance unit is Kilometers, set the wind speed and gust labels to the wind speed and gust in KMH
            unit = "KMH";
            speed = speed * 3.6; // Convert the wind speed to KMH
            gust = gust * 3.6; // Convert the wind gust to KMH
        }
        windspeedLabel.setText(f.format(speed)); // Set the wind speed label to the wind speed
        gustLabel.setText(f.format(gust)); // Set the gust label to the wind gust
        windUnits1.setText(unit);
        windUnits2.setText(unit);
    }
    
    /**
     * Updates the temperature labels with the correct temperature
     */
    private void updateTempLabels() {
        if(save.getDegreeUnits().equals("F")) { // If the temperature unit is Fahrenheit, update the labels with Fahrenheit
            updateHourlyFieldsF();
            updateTempFieldsF();
            updateDailyTempLabelsF();
        }
        else { // If the temperature unit is Celsius, update the labels with Celsius
            updateHourlyFieldsC();
            updateTempFieldsC();
            updateDailyTempLabelsC();
        }
    }
   
    /**
     * This method returns a description of the visibility based on the visibility value
     * @param visibility - the visibility value
     * @return String - the description of the visibility
     */
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
    /**
     * Returns the UV description based on the UV index
     * @param uvi - the UV index
     * @return String - the UV description
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
     * Gets the fahrenheit temperature from the kelvin temperature
     * @param k - the kelvin temperature
     * @return int - the fahrenheit temperature
     */
    private int getFahrenheit(double k) { 
        return (int) Math.rint((k - 273.15) * 9/5 + 32);
    }

    /**
     * Gets the celsius temperature from the kelvin temperature
     * @param k - the kelvin temperature
     * @return int - the celsius temperature
     */
    private int getCelsius(double k) {
        return (int) Math.rint(k - 273.15);
    }

    /**
     * Gets the date from the epoch time
     * @param epochTimeSeconds - the epoch time in seconds
     * @return Date - the date
     */
    private Date getDateFromEpoch(int epochTimeSeconds) {
        long epoch = Long.parseLong(String.valueOf(epochTimeSeconds));
        return new Date(epoch * 1000);
    }
    
    /**
     * Updates the daily temp labels with fahrenheit
     */
    private void updateDailyTempLabelsF() {
        ArrayList<CityDaily> cityDaily = city.getDailyData();
        for (int i = 0; i < 8; i++) {
            try { // Use reflection to get the high and low labels
                String highText = "high" + (i + 1);
                String lowText = "low" + (i + 1);
                Text high = (Text) getClass().getDeclaredField(highText).get(this);
                Text low = (Text) getClass().getDeclaredField(lowText).get(this);
                high.setText(getFahrenheit(cityDaily.get(i).getTempMax()) + "°F");
                low.setText(getFahrenheit(cityDaily.get(i).getTempMin()) + "°F");
            } catch(Exception e) {}

        }
    }

    /**
     * Updates the daily temp labels with celsius
     */
    private void updateDailyTempLabelsC() {
        ArrayList<CityDaily> cityDaily = city.getDailyData();
        high1.setText(city.getTempMax() + "°C");
        high1.setText(city.getTempMin() + "°C");
        for (int i = 1; i < 8; i++) {
            try { // Use reflection to get the high and low labels
                String highText = "high" + (i);
                String lowText = "low" + (i);
                Text high = (Text) getClass().getDeclaredField(highText).get(this);
                Text low = (Text) getClass().getDeclaredField(lowText).get(this);
                high.setText(getCelsius(cityDaily.get(i).getTempMax()) + "°C");
                low.setText(getCelsius(cityDaily.get(i).getTempMin()) + "°C");
            } catch(Exception e) {}

        }
    }
    /**
     * Updates the temp labels with fahrenheit
     */
    private void updateTempFieldsF() {
        String fahrenheit = "°F";
        temperatureLabel.setText(getFahrenheit(city.getCurTemp()) + fahrenheit);
        lowHighLabel.setText("H: " + getFahrenheit(city.getTempMax()) + fahrenheit + "    L: " + getFahrenheit(city.getTempMin()) + fahrenheit);
        dewPointLabel.setText("Dew Point: " + getFahrenheit(city.getDewPoint())+ fahrenheit);
        feelsLikeLabel.setText("Feels Like: " + getFahrenheit(city.getFeelsLike()) + fahrenheit);
    }
    /**
     * Updates the temp labels with celsius
     */
    private void updateTempFieldsC() {
        String celsius = "°C";
        temperatureLabel.setText(getCelsius(city.getCurTemp()) + celsius);
        lowHighLabel.setText("H: " + getCelsius(city.getTempMax()) + celsius + "    L: " + getCelsius(city.getTempMin()) + celsius);
        dewPointLabel.setText("Dew Point: " + getCelsius(city.getDewPoint()) + celsius);
        feelsLikeLabel.setText("Feels Like: " + getCelsius(city.getFeelsLike()) + celsius);
    }
    /**
     * Updates the hourly fields with fahrenheit
     */
    private void updateHourlyFieldsF() {
        try {
        ArrayList<CityHourly> cityHourly = city.getHourlyData();

        for (int i = 0; i < 37; i++) { // Use reflection to get the hourly and hour labels
            String hourlyText = "hourly" + (i + 1);
            String hourText = "hour" + (i + 1);

            Text hourly = (Text) getClass().getDeclaredField(hourlyText).get(this);
            Text hour = (Text) getClass().getDeclaredField(hourText).get(this);

            hourly.setText(getFahrenheit(cityHourly.get(i).getCurTemp()) + "°F");
            hour.setText(resolveHourFromEpoch(cityHourly.get(i).getDt()));
        }
        } catch(Exception e) {}
    }
    /**
     * Updates the hourly fields with celsius
     */
    private void updateHourlyFieldsC() {
        try {
        ArrayList<CityHourly> cityHourly = city.getHourlyData();

        for (int i = 0; i < 37; i++) { // Use reflection to get the hourly and hour labels
            String hourlyText = "hourly" + (i + 1);
            String hourText = "hour" + (i + 1);

            Text hourly = (Text) getClass().getDeclaredField(hourlyText).get(this);
            Text hour = (Text) getClass().getDeclaredField(hourText).get(this);

            hourly.setText(getCelsius(cityHourly.get(i).getCurTemp()) + "°C");
            hour.setText(resolveHourFromEpoch(cityHourly.get(i).getDt()));
        }
        } catch(Exception e) {}
    }
    
    /**
     * Gets the wind direction based on the degree
     * @param deg - the degree
     * @return String - the wind direction
     */
    private String getWindDirection(double deg) { //
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
     * Gets the time based on the epoch time
     * @param epoch - the epoch time
     * @return String - the time
     */
    private String resolveTimeAMPM(int epoch) {
        // Convert epoch time to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());

        // Format the hour part only
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String hour = dateTime.format(formatter);

        return hour;
    }
    /**
     * Gets the hour based on the epoch time
     * @param epoch - the epoch time
     * @return String - the hour
     */
    private String resolveHourFromEpoch(int epoch) {
        // Convert epoch time to LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epoch), ZoneId.systemDefault());

        // Format the hour part only
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:00");
        String hour = dateTime.format(formatter);

        return hour;
    }
    /** 
     * Adds images to the labels based on the weather data
     */
    private void addImages() {
        ArrayList<CityHourly> cityHourly = city.getHourlyData(); // Get the hourly data
        ArrayList<CityDaily> cityDaily = city.getDailyData(); // Get the daily data
        Thread hourlyImagesThread = new Thread(() -> { // Create a new thread to add the hourly images
            for (int i = 0; i < 37; i++) { // Loop through the hourly data
                String imageType = "";
                int curTime = cityHourly.get(i).getDt(); // Get the current time
                int sunrise = city.getSunrise(); // Get the sunrise and sunset times
                int sunset = city.getSunset(); // Get the sunrise and sunset times
                if (curTime > sunset) { // If the current time is after sunset, set the sunrise and sunset to the next day
                    sunset = cityDaily.get(1).getSunset();
                    sunrise = cityDaily.get(1).getSunrise();
                }
                boolean isDaytime = curTime > sunrise && curTime < sunset; // Check if it is daytime
                if (cityHourly.get(i).getWeatherMain().equals("Clear")) { // If the weather is clear, set the image to the sun or moon
                    if (isDaytime) { // If it is daytime, set the image to the sun
                        imageType = "sun.png";
                    } else {
                        imageType = "moon.png"; // If it is nighttime, set the image to the moon
                    }
                }
                if (cityHourly.get(i).getWeatherMain().equals("Clouds")) { // If the weather is cloudy, set the image to clouds
                    if (cityHourly.get(i).getWeatherDesc().equals("overcast clouds"))
                        imageType = "clouds.png";
                    else {
                        if (isDaytime) // If it is daytime, set the image to partly cloudy at day
                            imageType = "partlycloudy.png";
                        else    
                            imageType = "partiallynight.png"; // If it is nighttime, set the image to partially cloudy at night
                    }

                } else if (cityHourly.get(i).getWeatherMain().equals("Rain")) { // If the weather is rainy, set the image to rain
                    imageType = "rain.png";
                } else if (cityHourly.get(i).getWeatherMain().equals("Thunderstorm")) { // If the weather is a thunderstorm, set the image to lightning
                    imageType = "lightning.png";
                } else if (cityHourly.get(i).getWeatherMain().equals("Drizzle")) { // If the weather is drizzling, set the image to drizzle
                    imageType = "drizzle.png";
                } else if (cityHourly.get(i).getWeatherMain().equals("Snow")) { // If the weather is snowy, set the image to snow
                    imageType = "snow.png";
                }
                String imgFieldName = "img" + (i + 1);

                try {
                    // Access the ImageView using reflection
                    ImageView imageView = (ImageView) getClass().getDeclaredField(imgFieldName).get(this);

                    File file = new File("src/main/resources/c/finalweatherproject/images/" + imageType); // Construct the file path
                    if (file.exists()) { // Check if file exists before attempting to load the image
                        Image image = new Image(file.toURI().toString()); // Load the image
                        imageView.setImage(image); // Set the image to the image view
                    } else {
                        System.out.println("File not found: " + file.getAbsolutePath()); // Print an error message if the file is not found
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        hourlyImagesThread.start(); // Start the hourly images thread
        Thread dailyImagesThread = new Thread(() -> { // Create a new thread to add the daily images 
            for (int i = 0; i < 8; i++) {
                String imageType = "";
                String weatherMain = cityDaily.get(i).getWeatherMain();
                try {
                    String popText = "pop" + (i + 1); // Use reflection to get the pop labels
                    Text pop = (Text) getClass().getDeclaredField(popText).get(this);
                    Double popNum = 100 * cityDaily.get(i).getPop();
                    if(popNum == 0 || !weatherMain.equals("Rain")) // If the chance of precipitation is 0 or the weather is not rainy, set the pop label to empty
                        pop.setText("");
                    else
                        pop.setText(String.format("%.0f", popNum) + "%"); // Set the pop label to the chance of precipitation
                } catch (Exception e) {}
                if (weatherMain.equals("Clear")) { // If the weather is clear, set the image to the sun or moon
                    imageType = "clouds.png";
                }
                else if (weatherMain.equals("Rain")) { // If the weather is rainy, set the image to rain
                    imageType = "rain.png";
                }
                else if (weatherMain.equals("Clouds")) { // If the weather is cloudy, set the image to clouds
                    imageType = "clouds.png";
                }
                else if (weatherMain.equals("Snow")) { // If the weather is snowy, set the image to snow
                    imageType = "snow.png";
                }
                else if (weatherMain.equals("Thunderstorm")) {  // If the weather is a thunderstorm, set the image to lightning
                    imageType = "lightning.png";
                }
                else if (weatherMain.equals("Drizzle")) { // If the weather is drizzling, set the image to drizzle
                    imageType = "drizzle.png";
                }

                String imgFieldName = "dimg" + (i + 1); // Use reflection to get the daily image views

                try { 
                    ImageView imageView = (ImageView) getClass().getDeclaredField(imgFieldName).get(this);

                    File file = new File("src/main/resources/c/finalweatherproject/images/" + imageType);

                    if (file.exists()) { // Check if file exists before attempting to load the image
                        Image image = new Image(file.toURI().toString());
                        imageView.setImage(image); // Set the image to the image view
                    } else {
                        System.out.println("File not found: " + file.getAbsolutePath()); // Print an error message if the file is not found
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dailyImagesThread.start(); // Start the daily images thread
    }
    /**
     * Gets the day of the week based on the epoch time
     * @param epochSeconds - the epoch time
     * @return String - the day of the week
     */
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
