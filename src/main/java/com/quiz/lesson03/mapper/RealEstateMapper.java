package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	// 1.
	public RealEstate selectRealEstateById(int id);
	
	// 2. @Param("") 어노테이션에 들어가는 값과 xml에 서 #{}에 들어가는 값과 일치해야 함
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentprice") int rentPrice);
	
	// 3.
	public List<RealEstate> selectRealEstateByAreaPrice(@Param("area") int area, @Param("price") int price);
}
