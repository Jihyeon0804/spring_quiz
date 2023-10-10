package com.quiz.lesson04.mapper;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.domain.Realtor;

@Repository
public interface RealtorMapper {

	// input : Realtor 객체
	// output : X
	public void insertRealtor(Realtor realtor);
	
	// input : id
	// output : Realtor 객체 단건
	public Realtor selectRealtorById(int id);
}
