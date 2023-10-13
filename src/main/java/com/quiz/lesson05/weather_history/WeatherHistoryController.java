package com.quiz.lesson05.weather_history;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson05.weather_history.bo.WeatherHistoryBO;
import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@RequestMapping("/weather_history")
@Controller
public class WeatherHistoryController {

	@Autowired WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 목록 화면
	@GetMapping("/history-view")
	public String historyView(Model model) {
		List<WeatherHistory> weatherHistoryList = new ArrayList<>();
		weatherHistoryList = weatherHistoryBO.getWeatherHistory();
		model.addAttribute("weatherHistoryList", weatherHistoryList);
		return "weather_history/history";
	}
	
	// 날씨 추가 화면
	@GetMapping("/history-add-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@PostMapping("/add_weather")
	public String addWeather(@ModelAttribute WeatherHistory weatherHistory, Model model) {
		
		// 입력 받은 날씨 INSERT
		weatherHistoryBO.addWeatherHistory(weatherHistory);
		
		// 방금 INSERT된 id로 인해
		WeatherHistory weather =  weatherHistoryBO.getWeatherHistoryById(weatherHistory.getId());
		model.addAttribute("weather", weather);
		
		// Redirect
		return "redirect:/weather_history/history-view";
	}
	
}
