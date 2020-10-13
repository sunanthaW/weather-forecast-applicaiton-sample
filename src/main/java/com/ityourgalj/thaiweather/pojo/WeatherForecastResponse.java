
package com.ityourgalj.thaiweather.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherForecastResponse {

    @SerializedName("WeatherForecasts")
    @Expose
    private List<WeatherForecast> weatherForecasts = null;

    public List<WeatherForecast> getWeatherForecasts() {
        return weatherForecasts;
    }

    public void setWeatherForecasts(List<WeatherForecast> weatherForecasts) {
        this.weatherForecasts = weatherForecasts;
    }

}
