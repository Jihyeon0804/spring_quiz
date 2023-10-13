package com.quiz.weather_history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// URL : http://localhost:8080/weather_history/history-view
	// 날씨 목록 화면
	@GetMapping("/history-view")
	public String historyView(Model model) {
		List<WeatherHistory> weatherHistoryList = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "weather_history/history";
	}
	
	// 날씨 추가 화면
	@GetMapping("/history-add-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	
	// 날씨 추가 로직
	// ModelAttribute
//	@PostMapping("/add-weather")
//	public String addWeather(@ModelAttribute WeatherHistory weatherHistory, Model model) {
//		
//		// 입력 받은 날씨 INSERT
//		weatherHistoryBO.addWeatherHistory(weatherHistory);
//		
//		// 방금 INSERT된 것 가져오기
//		WeatherHistory weather =  weatherHistoryBO.getWeatherHistoryById(weatherHistory.getId());
//		model.addAttribute("weather", weather);
//		
//		// Redirect
//		return "redirect:/weather_history/history-view";
//	}
	
	
	// RequestParam
	@PostMapping("/add-weather")
	public String addWeather(
			//@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date
			@RequestParam("date") String date,
			@RequestParam("weather") String weather,
			@RequestParam("microDust") String microDust,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("windSpeed") double windSpeed) {
		
		// db insert
		// output : void
		weatherHistoryBO.addWeatherHistory(date, weather, microDust,
				temperatures, precipitation, windSpeed);
		
		// response
		// redirect => 히스토리 페이지
		return "redirect:/weather_history/history-view";
	}
	
}