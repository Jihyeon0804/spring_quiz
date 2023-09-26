package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	// 1-1.
	public RealEstate selectRealEstateById(int id);
	
	// 1-2. @Param("") 어노테이션에 들어가는 값과 xml에 서 #{}에 들어가는 값과 일치해야 함
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentprice") int rentPrice);
	
	// 1-3.
	public List<RealEstate> selectRealEstateByAreaPrice(
			// @Param => 하나의 map이 된다. (파라미터가 2게 이상일 때)
			@Param("area") int area,
			@Param("price") int price);
	
	
	// 2-1.
	public int insertRealEstate(RealEstate realEstate);
	
	// 2-2.
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
	
	// 3-1.
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	public int deleteRealEstateById(int id);
}
