package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;

@Repository	// MyBatis가 DB와 연동되는 클래스를 Spring bean 으로 만들어주는 어노테이션
public interface StoreMapper {
	
	// input : X
	// output : List<Store>
	public List<Store> selectStoreList();
	
}
