
package com.ityourgalj.thaiweather.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherForecast {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("forecasts")
    @Expose
    private List<Forecast> forecasts = null;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

}
