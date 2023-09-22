package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;

	// 1.
	// input : int(정수)
	// output : RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}

	// 2.
	// input : int(정수)
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}

	// 3.
	// input : int(정수)
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}

}
