package com.quiz.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.store.domain.Review;

@Repository
public interface ReviewMapper {

	public List<Review> selectReviewListById(@Param("storeId") int id);
}
