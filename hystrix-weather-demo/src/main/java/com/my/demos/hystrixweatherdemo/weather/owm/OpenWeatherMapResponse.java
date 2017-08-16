package com.my.demos.hystrixweatherdemo.weather.owm;

import lombok.Data;

@Data
public class OpenWeatherMapResponse {

    private Main main;
    private Weather[] weather;

    @Data
    public static class Main {
        private String temp;
    }

    @Data
    public static class Weather {
        private String description;
    }

}
