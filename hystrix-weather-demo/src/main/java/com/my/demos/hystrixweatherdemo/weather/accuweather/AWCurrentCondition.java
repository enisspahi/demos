package com.my.demos.hystrixweatherdemo.weather.accuweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AWCurrentCondition {

    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("WeatherText")
    private String weatherText;

    @Data
    public static class Temperature {
        @JsonProperty("Metric")
        private Metric metric;

        @Data
        public static class Metric {
            @JsonProperty("Value")
            private String value;
        }
    }

}
