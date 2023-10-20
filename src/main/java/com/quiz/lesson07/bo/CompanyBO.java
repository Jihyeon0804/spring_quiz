package com.quiz.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// JPA
	// input : params(name, business, scale, headcount)
	// output : CompanyEntity
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		
		// 빌더 패턴
		CompanyEntity company = CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		return companyRepository.save(company);
	}
}
