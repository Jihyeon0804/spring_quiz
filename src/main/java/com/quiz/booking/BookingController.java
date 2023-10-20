package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;

	// 예약 목록 리스트 페이지
	// URL : http://localhost:8080/booking/reserve-list-view
	@GetMapping("/reserve-list-view")
	public String reserveListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/reserveList";
	}

	// 예약 목록 삭제하기 - AJAX 통신
	@ResponseBody
	@DeleteMapping("/delete-reserve")
	public Map<String, Object> deleteReservie(@RequestParam("id") int id) {

		// db 삭제
		bookingBO.deleteBookingById(id);

		// 응답값
		// {"code" : 200, "result" : "success"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		return result;
	}

	// 에약 하기 페이지
	// URL : http://localhost:8080/booking/reserve-view
	@GetMapping("/reserve-view")
	public String reserveView() {
		return "booking/reserve";
	}
	
	
	// 예약 하기 - AJAX 통신
	@ResponseBody
	@PostMapping("/add-reserve")
	public Map<String, Object> insertReserve(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;	// JSON String
	}
	

	// 통나무 펜션 사이트
	// URL : http://localhost:8080/booking/tongnamu-view
	@GetMapping("/tongnamu-view")
	public String homepageView() {
		return "booking/tongnamu";
	}

	// 예약 조회하기 - AJAX 통신
	@ResponseBody	// Model 사용 불가(JSP return이 아니기 때문에; view로 가지 않기 때문에)
	@PostMapping("/search-reserve")
	public Map<String, Object> submitReserve(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db select
		Booking existBooking = bookingBO.existBooking(name, phoneNumber);
		
		
		// 응답값
		// {"code":200, "result":"success", "existBooking" : existBooking}
		// {"code":400, "result":"error", "error_message" : "데이터가 존재하지 않습니다."}
		Map<String, Object> result = new HashMap<>();
		if (existBooking == null) {
			result.put("code", 400);
			result.put("result", "error");
			result.put("error_message", "데이터가 존재하지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", "success");
			result.put("existBooking", existBooking);
		}
		return result;
	}
}
