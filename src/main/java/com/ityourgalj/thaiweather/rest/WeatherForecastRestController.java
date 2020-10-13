package com.ityourgalj.thaiweather.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.ityourgalj.thaiweather.http.HttpManager;
import com.ityourgalj.thaiweather.pojo.WeatherForecastResponse;

@RequestMapping("/api")
@RestController
public class WeatherForecastRestController {
	private HttpManager httpManager;

	@Value("${thaiweather.personal.access.token}")
	private String accessToken;

	@Value("${thaiweather.personal.access.token.type}")
	private String tokenType;

	@Autowired
	public WeatherForecastRestController(HttpManager httpManager) {
		this.httpManager = httpManager;
	}

	@GetMapping("/forecast/daily")
	public WeatherForecastResponse getDailyForecastByRegion(@RequestParam("region") String region, @RequestParam("date") String date)
			throws IOException {
		// https://data.tmd.go.th/nwpapi/v1/forecast/location/daily/region?region=E&fields=tc_max,rh&date=2020-10-17&duration=2

		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrl = "https://data.tmd.go.th/nwpapi/v1/forecast/location/daily/region";

		String queryParam = "?region=E&fields=tc_max,rh&date=2020-10-17&duration=2";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", tokenType + " " + accessToken);
			
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(null,headers);

		String url = fooResourceUrl + queryParam;
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

		String json = response.getBody();
		
		Gson gson = new Gson();
		WeatherForecastResponse responseObject = gson.fromJson(json, WeatherForecastResponse.class);
		

//		Call<WeatherForecastResponse> call = httpManager.getWeatherService()
//				.listRepos("e", "tc_max,rh", "2020-10-10",1);
//		
//		Response<WeatherForecastResponse> response = call.execute();
//
//		WeatherForecastResponse weatherForecastResponse = response.body();
//
//		return weatherForecastResponse;

		return responseObject;
	}

}
