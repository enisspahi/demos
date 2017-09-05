package com.my.demos.hystrixweatherdemo;

import com.my.demos.hystrixweatherdemo.weather.WeatherInfo;
import com.my.demos.hystrixweatherdemo.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixWeatherDemoController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weatherInPrizren/{source}")
    public WeatherInfo weatherInPrizren(@PathVariable String source) {
        if ("accuWeather".equals(source)) {
            return weatherService.weatherInPzFromAccuWeather();
        } else if ("openWeatherMap".equals(source)) {
            return weatherService.weatherInPzFromOpenWeatherMap();
        }
        throw new UnsupportedOperationException("Unsupported source");
    }

    @GetMapping("/weatherInPrizrenResilient")
    public WeatherInfo weatherInPrizrenResilient() {
        return weatherService.weatherInPrizrenResilient();
    }

    @GetMapping("/weatherInPrizrenResilientFromAccuWeather")
    public WeatherInfo awWeatherInPrizrenResilient() {
        return weatherService.weatherInPrizrenResilientFromAccuWeather();
    }

}
