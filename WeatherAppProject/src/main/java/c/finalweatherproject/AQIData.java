/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c.finalweatherproject;

/**
 *
 * @author bradf
 */
public class AQIData {
    private int main;
    private String mainDesc;
    private double co;
    private double no;
    private double no2;
    private double o3;
    private double so2;
    private double pm2_5;
    private double pm10;
    private double nh3;
    
    public AQIData(int main, double co, double no, double no2, double o3, double so2, double pm2_5, double pm10, double nh3) {
        this.main = main;
        this.co = co;
        this.no = no;
        this.no2 = no2;
        this.o3 = o3;
        this.so2 = so2;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.nh3 = nh3;
        this.mainDesc = getAQIMainDesc();
    }
    public int getMain() {return main;}
    public String getMainDesc() {return mainDesc;}
    public double getCO() {return co;}
    public double getNO() {return no;}
    public double getNO2() {return no2;}
    public double getO3() {return o3;}
    public double getSO2() {return so2;}
    public double getPM2_5() {return pm2_5;}
    public double getPM10() {return pm10;}
    public double getNH3() {return nh3;}

    private String getAQIMainDesc() {
        if (main == 1) {
            return "Good";
        } else if (main == 2) {
            return "Fair";
        } else if (main == 3) {
            return "Moderate";
        } else if (main == 4) {
            return "Poor";
        } else if (main == 5) {
            return "Very Poor";
        } 
        else {
            return "Error";
        }
    }
    @Override
    public String toString() {
        return "AQIData{" + "main=" + main 
                          + ", mainDesc=" + mainDesc 
                          + ", co=" + co 
                          + ", no=" + no 
                          + ", no2=" + no2 
                          + ", o3=" + o3 
                          + ", so2=" + so2 
                          + ", pm2_5=" + pm2_5 
                          + ", pm10=" + pm10 
                          + ", nh3=" + nh3 + '}';
    }
}
