package com.ityourgalj.thaiweather.http;

import com.ityourgalj.thaiweather.pojo.WeatherForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

	@GET("location/daily/region")
	Call<WeatherForecastResponse> listRepos(@Query("region") String region,
											@Query("fields") String fields,
											@Query("date") String date,
											@Query("duration") int durations);

}
