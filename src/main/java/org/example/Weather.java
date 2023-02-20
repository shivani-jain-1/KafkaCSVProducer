package org.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Date;
import java.util.List;

public class Weather {

    // ,,,,,,,,,,,,,,,,,,,,,
// 8,24.3,0,3.4,6.3,NW,30,SW,NW,6,20,68,29,1019.7,1015,7,7,14.4,23.6,No,3.6,Yes
    @JsonFormat
    private String MinTemp;
    @JsonFormat
    private String MaxTemp;
    @JsonFormat
    private String Rainfall;
    @JsonFormat
    private String Evaporation;
    @JsonFormat
    private String Sunshine;
    @JsonFormat
    private String WindGustDir;
    @JsonFormat
    private String WindGustSpeed;
    @JsonFormat
    private String WindDir3pm;
    @JsonFormat
    private String WindDir9am;
    @JsonFormat
    private String WindSpeed9am;
    @JsonFormat
    private String WindSpeed3pm;
    @JsonFormat
    private String Humidity9am;
    @JsonFormat
    private String Humidity3pm;
    @JsonFormat
    private String Pressure9am;
    @JsonFormat
    private String Pressure3pm;
    @JsonFormat
    private String Cloud9am;
    @JsonFormat
    private String Cloud3pm;
    @JsonFormat
    private String Temp9am;
    @JsonFormat
    private String Temp3pm;
    @JsonFormat
    private String RainToday;
    @JsonFormat
    private String RISK_MM;
    @JsonFormat
    private String RainTomorrow;


    public Weather() {
    }

    public Weather(String minTemp, String maxTemp, String rainfall, String evaporation, String sunshine, String windGustDir, String windGustSpeed, String windDir9am, String windDir3pm, String windSpeed9am, String windSpeed3pm, String humidity9am, String humidity3pm, String pressure9am, String pressure3pm, String cloud9am, String cloud3pm, String temp9am, String temp3pm, String rainToday, String RISK_MM, String rainTomorrow) {
        MinTemp = minTemp;
        MaxTemp = maxTemp;
        Rainfall = rainfall;
        Evaporation = evaporation;
        Sunshine = sunshine;
        WindGustDir = windGustDir;
        WindGustSpeed = windGustSpeed;
        WindDir9am = windDir9am;
        WindDir3pm = windDir3pm;
        WindSpeed9am = windSpeed9am;
        WindSpeed3pm = windSpeed3pm;
        Humidity9am = humidity9am;
        Humidity3pm = humidity3pm;
        Pressure9am = pressure9am;
        Pressure3pm = pressure3pm;
        Cloud9am = cloud9am;
        Cloud3pm = cloud3pm;
        Temp9am = temp9am;
        Temp3pm = temp3pm;
        RainToday = rainToday;
        this.RISK_MM = RISK_MM;
        RainTomorrow = rainTomorrow;
    }
}


