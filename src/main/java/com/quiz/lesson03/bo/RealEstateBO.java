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

	// 1-1.
	// input : id
	// output : RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}

	// 1-2.
	// input : rentPrice
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}

	// 1-3.
	// input : area, price
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateByAreaPrice(area, price);
	}
	
	// 2-1.
	// input : RealEstate
	// output : int
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	// 2-2.
	// addRealEstateByRealtorId(realtor_id, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120)
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	// 3-1.
	// input : id, type, price
	// output : int(수정 성공된 행의 개수)
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	// 4-1.
	// input : id
	// output : int
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}

}
