package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	// 예약 목록 리스트 select
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	
	// 예약 목록 delete
	public void deleteBookingBy(int id) {
		bookingMapper.deleteBookingById(id);
	}
	
	// 예약 insert
	public void addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
}
