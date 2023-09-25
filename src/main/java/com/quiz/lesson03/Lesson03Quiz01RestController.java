package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// 1.
	// 요청 URL : http://localhost:8080/lesson03/quiz01/1?id=20
	
	// input : id
	// output : RealEstate
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam("id") int id) {	// 필수 파라미터 null X
		return realEstateBO.getRealEstateById(id);
	}
	
	// 2. 해당하는 월세보다 낮은 매물 json 출력
	// 요청 URL : http://localhost:8080/lesson03/quiz01/2?rent_price=90
	
	// input : 월세(rentPrice)s
	// output : List<RealEstate>
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam("rent_price") int rentPrice) {	// 필수 파라미터 null X
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	// 3. 복합조건 select
	// 넓이(area) - 매물의 넓이가 전달 받은 넓이 이상인 것
	// 가격(price) - 매물의 매매금이 전달받은 매매금 보다 이하인 것
	// 요청 URL : http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
	
	//input : area, price
	// output : List<RealEstate>
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,			// 필수 파라미터 null X
			@RequestParam("price") int price) {		// 필수 파라미터 null X
		return realEstateBO.getRealEstateByAreaPrice(area, price); // response body => JSON
	}
}
