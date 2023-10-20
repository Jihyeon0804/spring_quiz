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
	// output : Booking (null or Booking)
	// mybatis는 비어있으면 null이 아닌 [] 반환 => bookingList는 list가 비어있거나 그렇지 않거나 둘 중 하나
	// Mapper에서 List로 return 하지만 최신으로 한 개만 받아오도록 구성
	// Mapper로부터 받아온 것을 가공
	public Booking existBooking(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.existBooking(name, phoneNumber);
		// index가 클 수록 최신 데이터
		// 리스트가 비어있으면 null이 아닌 []
		
		// bookingList 비어있는지 확인
		if (bookingList.isEmpty()) {
			return null;	// null
		} 
		
		// 리스트가 비어있지 않으면 마지막 객체 리턴
		return bookingList.get(bookingList.size() - 1);		// booking
	}
	
}
