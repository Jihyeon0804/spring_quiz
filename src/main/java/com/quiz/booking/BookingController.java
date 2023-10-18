package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking/homepage-view")
	public String homepageView() {
		return "booking/homepage";
	}
	
	@GetMapping("/booking/reserve-view")
	public String reserveView() {
		return "booking/reserve";
	}
	
	@GetMapping("/booking/reserve-list-view")
	public String reserveListView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "booking/reserveList";
	}
}
