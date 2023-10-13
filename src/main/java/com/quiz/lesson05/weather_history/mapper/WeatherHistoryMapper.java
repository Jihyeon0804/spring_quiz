package com.quiz.lesson05.weather_history.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.weather_history.domain.WeatherHistory;

@Repository
public interface WeatherHistoryMapper {

	public List<WeatherHistory> selectWeatherHistory();
	
	public void insertWeatherHistory(WeatherHistory weatherHistory);
	
	public WeatherHistory selectWeatherHistoryById(int id);
}
