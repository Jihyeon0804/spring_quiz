package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Seller;

@Repository
public interface SellerMapper {
	
	// input : 3개의 파라미터
	// output : X
	public void insertSeller(
			@Param("nickname") String nickname,
			@Param("profileImageUrl") String profileImageUrl,
			@Param("temperature") Double temperature);
	
	// 2.
	// input : X
	// output : Seller
	public Seller selectLatestSeller();
	
	// 3.
	// input : id
	// output : Seller
	public Seller selectSellerById(@Param("id") int id);
}
