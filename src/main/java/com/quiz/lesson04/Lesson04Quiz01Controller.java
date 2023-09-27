package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// 1. seller 추가
	// 판매자 추가 페이지
	// 요청 URL : http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";	// jsp view 경로
	}
	
	
	// 판매자 DB에 추가 => 입력 성공 페이지로 이동
	// 요청 URL : http://localhost:8080/lesson04/quiz01/add-seller
	@PostMapping("/add-seller")		// form 태그를 통해서만 들어올 수 있음
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImageUrl", required=false) String profileImageUrl,
			@RequestParam(value="temperature", required=false) Double temperature) {
		
		// DB insert ; insert 전에 응답 확인 먼저하기
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 응답 확인
		return "lesson04/afterAddSeller";
	}
	
	// 2. seller 출력
	// 3. seller 검색 출력
	// 가장 최근에 추가된 seller의 정보를 아래와 같은 형태로 출력 하세요.
	// 요청 URL : http://localhost:8080/lesson04/quiz01/seller-info
	// 요청 URL : http://localhost:8080/lesson04/quiz01/seller-info?id=2
	
	@GetMapping("/seller-info")
	public String getSellerById(Model model, @RequestParam(value="id", required=false) Integer id) {
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		return "lesson04/sellerInfo";
	}

}
