package com.my.demos.hystrixweatherdemo.weather;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherInfo {
    private String temperature;
    private String description;
    private String source;
}
