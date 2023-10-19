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
	
	// ----- 예약 목록 리스트 select -----
	// input : X
	// output : List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	
	// ----- 예약 목록 delete -----
	// input : id
	// output : X
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	}
	
	// ----- 예약 하기 insert -----
	// input : name, date, day, headcount, phoneNumber
	// output : X
	public void addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	
	// ----- 예약 조회 select -----
	// input : name, phoneNumber
	// output : boolean
	public Booking existBooking(String name, String phoneNumber) {
		return bookingMapper.existBooking(name, phoneNumber);
	}
	
}
