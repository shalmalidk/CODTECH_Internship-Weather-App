package com.example.demo.weather.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.weather.service.WeatherService;

import org.json.JSONObject;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        String json = weatherService.getWeatherData(city);
        JSONObject obj = new JSONObject(json);

        String name = obj.getString("name");
        String country = obj.getJSONObject("sys").getString("country");
        double temp = obj.getJSONObject("main").getDouble("temp");
        double feelsLike = obj.getJSONObject("main").getDouble("feels_like");
        int humidity = obj.getJSONObject("main").getInt("humidity");
        int pressure = obj.getJSONObject("main").getInt("pressure");
        String description = obj.getJSONArray("weather").getJSONObject(0).getString("description");
        double windSpeed = obj.getJSONObject("wind").getDouble("speed");
        int windDeg = obj.getJSONObject("wind").getInt("deg");
        int cloudiness = obj.getJSONObject("clouds").getInt("all");
        int visibility = obj.getInt("visibility");
        long sunrise = obj.getJSONObject("sys").getLong("sunrise");
        long sunset = obj.getJSONObject("sys").getLong("sunset");

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));

        StringBuilder html = new StringBuilder();
        html.append("<h3>City: ").append(name).append(", ").append(country).append("</h3>");
        html.append("<p><strong>Temperature:</strong> ").append(temp).append("°C (Feels like: ").append(feelsLike).append("°C)</p>");
        html.append("<p><strong>Humidity:</strong> ").append(humidity).append("%</p>");
        html.append("<p><strong>Pressure:</strong> ").append(pressure).append(" hPa</p>");
        html.append("<p><strong>Weather:</strong> ").append(description).append("</p>");
        html.append("<p><strong>Wind:</strong> ").append(windSpeed).append(" m/s from ").append(windDeg).append("°</p>");
        html.append("<p><strong>Cloudiness:</strong> ").append(cloudiness).append("%</p>");
        html.append("<p><strong>Visibility:</strong> ").append(visibility).append(" meters</p>");
        html.append("<p><strong>Sunrise:</strong> ").append(sdf.format(new Date(sunrise * 1000))).append("</p>");
        html.append("<p><strong>Sunset:</strong> ").append(sdf.format(new Date(sunset * 1000))).append("</p>");

        return html.toString();
    }
}
