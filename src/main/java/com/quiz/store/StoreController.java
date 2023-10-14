package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.store.bo.ReviewBO;
import com.quiz.store.domain.Review;

@RequestMapping("/store")
@Controller
public class StoreController {

	@Autowired
	private StoreBO storeBO;
	
	@Autowired
	private ReviewBO reviewBO;
	
	// URL : http://localhost:8080/store/store-view
	// 가게 리스트
	@GetMapping("/store-view")
	public String storeListView(Model model) {
		List<Store> storeList = storeBO.getstoreList();
		model.addAttribute("storeList", storeList);
		return "store/storeList";
	}
	
	// 가게 리뷰 목록
	@GetMapping("/review")
	public String reviewListView(@RequestParam("storeId") int storeId,
			@RequestParam("storeName") String storeName, Model model) {
		List<Review> reviewList = reviewBO.getReviewListById(storeId);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("storeName", storeName);
		return "store/review";
	}
}
