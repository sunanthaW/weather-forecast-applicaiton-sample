package com.ityourgalj.thaiweather.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class HttpManager {

	private WeatherService weatherService;

	@Autowired
	public HttpManager(@Value("${thaiweather.personal.access.token.type}") String tokenType,
			@Value("${thaiweather.personal.access.token}") String accessToken) {
		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
		OAuthInteceptor authInteceptor = new OAuthInteceptor(tokenType, accessToken);

		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(authInteceptor)
				.addInterceptor(loggingInterceptor).build();

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://data.tmd.go.th/nwpapi/v1/forecast/")
				.addConverterFactory(GsonConverterFactory.create(gson)).client(client).build();

		weatherService = retrofit.create(WeatherService.class);

	}

	public WeatherService getWeatherService() {
		return weatherService;
	}

}
