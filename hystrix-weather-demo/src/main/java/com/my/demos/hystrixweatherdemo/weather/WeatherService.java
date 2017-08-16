package com.my.demos.hystrixweatherdemo.weather;

import com.my.demos.hystrixweatherdemo.weather.accuweather.AWCurrentCondition;
import com.my.demos.hystrixweatherdemo.weather.owm.OpenWeatherMapResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${accuweather.api.uri}")
    private String accuWeatherApiUri;

    @Value("${accuweather.api.key}")
    private String accuWeatherApiKey;

    @Value("${openweathermap.api.uri}")
    private String openWeatherMapApiUri;

    @Value("${openweathermap.api.key}")
    private String openWeatherMapApiKey;

    public WeatherInfo weatherInPzFromAccuWeather() {
        String pzCityId = "300299";
        AWCurrentCondition[] currentConditions = callWeatherApi(
                accuWeatherApiUri, pzCityId, accuWeatherApiKey,
                AWCurrentCondition[].class);

        final String temperature = currentConditions[0].getTemperature().getMetric().getValue();
        final String description = currentConditions[0].getWeatherText();

        return WeatherInfo.builder()
                .temperature(temperature)
                .description(description)
                .source("AccuWeather")
                .build();
    }

    public WeatherInfo weatherInPzFromOpenWeatherMap() {
        String pzCityId = "Prizren";
        OpenWeatherMapResponse owmResponse = callWeatherApi(
                openWeatherMapApiUri, pzCityId, openWeatherMapApiKey,
                OpenWeatherMapResponse.class);

        return WeatherInfo.builder()
                .temperature(owmResponse.getMain().getTemp())
                .description(owmResponse.getWeather()[0].getDescription())
                .source("OpenWeatherMap")
                .build();
    }

    private <T> T callWeatherApi(String uri, String cityId, String apiKey, Class<T> responseType) {
        String requestUri = String.format(uri, cityId, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(requestUri, responseType);
    }
}
