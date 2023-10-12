package com.quiz.lesson05.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {

	// 날씨 목록 화면
	@GetMapping("/history-view")
	public String historyView() {
		return "weather_history/history";
	}
	
	// 날씨 추가 화면
	@GetMapping("/history-add-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
}
