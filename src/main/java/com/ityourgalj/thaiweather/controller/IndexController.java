package com.ityourgalj.thaiweather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.ityourgalj.thaiweather.pojo.WeatherForecastResponse;

@Controller
public class IndexController {
	@Value("${thaiweather.personal.access.token}")
	private String accessToken;

	@Value("${thaiweather.personal.access.token.type}")
	private String tokenType;
	
	@Value("${app.name}")
	private String appName;

	@RequestMapping(value = { "/", "/index" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String home(Model model, 
						@RequestParam(value = "region", defaultValue = "") String region,
						@RequestParam(value = "date", defaultValue = "") String date,
						@RequestParam(value = "duration", defaultValue = "0") Integer duration) {
		model.addAttribute("title",appName);
		
		if (!region.isEmpty() && !date.isEmpty() && duration != 0) {
			WeatherForecastResponse response = callWeatherApi(region, date, duration);
			String[] cond = { "ท้องฟ้าแจ่มใส", "มีเมฆบางส่วน", "เมฆเป็นส่วนมาก", "มีเมฆมาก", "ฝนตกเล็กน้อย",
					"ฝนปานกลาง", "ฝนตกหนัก", "ฝนฟ้าคะนอง", "อากาศหนาวจัด", "อากาศหนาว", "อากาศเย็น", "อากาศร้อนจัด" };
			model.addAttribute("cond", cond);
			model.addAttribute("region",region);
			model.addAttribute("date",date);
			model.addAttribute("weahterModel", response);
		}

		return "index";
	}

	private WeatherForecastResponse callWeatherApi(String region, String date, Integer duration) {
		RestTemplate restTemplate = new RestTemplate();

		String fooResourceUrl = "https://data.tmd.go.th/nwpapi/v1/forecast/location/daily/region";
		String queryParam = "?region=" + region + "&fields=tc_max,tc_min,rh,cond&date="+date+"&duration=1";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", tokenType + " " + accessToken);

		HttpEntity<Object> requestEntity = new HttpEntity<Object>(null, headers);

		String url = fooResourceUrl + queryParam;
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);

		String json = response.getBody();

		Gson gson = new Gson();
		WeatherForecastResponse responseObject = gson.fromJson(json, WeatherForecastResponse.class);

		return responseObject;
	}

}