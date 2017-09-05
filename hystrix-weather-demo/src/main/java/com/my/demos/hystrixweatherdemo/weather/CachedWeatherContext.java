package com.my.demos.hystrixweatherdemo.weather;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class CachedWeatherContext {

    private WeatherInfo cachedWeatherInfo;
    private LocalDateTime lastCachingTime;

    public WeatherInfo getCachedWeatherInfo() {
        return cachedWeatherInfo;
    }

    public void storeWeatherInfo(WeatherInfo weatherInfo) {
        this.cachedWeatherInfo = WeatherInfo.builder()
                .temperature(weatherInfo.getTemperature())
                .description(weatherInfo.getDescription())
                .source("AccuWeather (cached)")
                .build();
        this.lastCachingTime = LocalDateTime.now();
    }

    public boolean isCacheValid() {
        return cachedWeatherInfo != null && minutesSinceLastRead() <= 30;
    }

    private long minutesSinceLastRead() {
        return ChronoUnit.MINUTES.between(lastCachingTime, LocalDateTime.now());
    }

}
