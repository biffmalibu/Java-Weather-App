package c.finalweatherproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

public class PrimaryController {
    
    CityData city;
    SaveState save;
    
    @FXML
    private Text feelsLikeLabel;
    
    @FXML
    private Text dewPointLabel;
    
    @FXML
    private Text humidityLabel;
    
    @FXML
    private CheckBox cCheck;

    @FXML
    private CheckBox fCheck;
    
    @FXML
    private Text hour1;

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
    void initialize() throws IOException {
        File file = new File("src\\main\\resources\\c\\finalweatherproject\\save.txt");
        if (!file.exists()) {
            save = new SaveState(WeatherAPIDriver.getGeoLocation("Boston"), "F", false);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(save.getGeolocation().toString());
            writer.write('F');
            writer.write("\nfalse");

            writer.close();
        }
        else {

            
            FileReader fr = new FileReader(file); 
            BufferedReader reader = new BufferedReader(fr);
            
            String name = reader.readLine();
            String country = reader.readLine();
            String state = reader.readLine();
            Double lat = Double.parseDouble(reader.readLine());
            Double lon = Double.parseDouble(reader.readLine());
            String deg = reader.readLine();
            boolean fullTime = Boolean.parseBoolean(reader.readLine());
            
            reader.close();
            Geolocation geolocation = new Geolocation(name, country, state, lat, lon);
            save = new SaveState(geolocation, deg, fullTime);
            
            if (save.getDegreeUnits().equals("F"))
                fCheck.setSelected(true);
            else
                cCheck.setSelected(true);
        }
        Geolocation location = save.getGeolocation();
        city = WeatherAPIDriver.PopulateCityInfo(location.getLat(), location.getLon());
        updateLabels(save.getGeolocation());
       
    }


    
    @FXML 
    void fClicked(ActionEvent event) {
        if (cCheck.isSelected()) {
            cCheck.setSelected(false);
        }
        save.setDegreeUnits("F");
        updateFile();
        updateTempLabels();
    }
    
    @FXML
    void cClicked(ActionEvent event) {
        if (fCheck.isSelected()) {
            fCheck.setSelected(false);
        }
        save.setDegreeUnits("C");
        updateFile();
        updateTempLabels();
    }
   
    
    @FXML
    void openSettings(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Error loading settings.");
        }
    }
            
            
    @FXML
    void updateCity(ActionEvent event) {
        try {
            Geolocation location;
            location = WeatherAPIDriver.getGeoLocation(search.getText());
            
            city = WeatherAPIDriver.PopulateCityInfo(location.getLat(), location.getLon());
            city.printCityData();
            save.setGeolocation(location);
            updateFile();
            updateLabels(location);
            
        } catch (NullPointerException e) {
            // do something here
            search.setText("Error parsing input.");
        }
    }
    private void updateFile()  {
        BufferedWriter writer = null;
        try {
            File file = new File("src\\main\\resources\\c\\finalweatherproject\\save.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(save.getGeolocation().toString());
            writer.write(save.getDegreeUnits());
            writer.write("\n" + save.getUsing24Hour());
            writer.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file save.txt");
        } 
        
    }
    private void updateLabels(Geolocation location) {
    
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
        updateWindInfo();
        
        sunsetLabel.setText("Sunset: " + resolveTimeAMPM(city.getDailyData().get(0).getSunset()));
        sunriseLabel.setText("Sunrise: " + resolveTimeAMPM(city.getDailyData().get(0).getSunrise()));
        moonsetLabel.setText("Moonset: " + resolveTimeAMPM(city.getDailyData().get(0).getMoonset()));
        moonriseLabel.setText("Moonrise: " + resolveTimeAMPM(city.getDailyData().get(0).getMoonrise()));
        
        pressureLabel.setText(city.getPressure() + " mbar");
        
    }
    private void updateWindInfo() {
        double wind = city.getWindDegrees();
        windspeedLabel.setText("Wind " + city.getWindSpeed() + " MPH");
        gustLabel.setText("Gust: " + city.getWindGust() + " MPH");
        winddirectionLabel.setText(wind + "°");
        winddirectionIMG.setRotate(wind);
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
                System.out.println(resolveHourFromEpoch(curTime) + " " +  curTime + "daytime: " + isDaytime);
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
}
