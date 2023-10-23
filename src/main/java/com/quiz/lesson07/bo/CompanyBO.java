package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;	// JPA
	
	// JPA
	// input : params(name, business, scale, headcount)
	// output : CompanyEntity
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		
		// 빌더 패턴
		// 1)
//		CompanyEntity company = CompanyEntity.builder()
//				.name(name)
//				.business(business)
//				.scale(scale)
//				.headcount(headcount)
//				.build();
//		
//		return companyRepository.save(company);
		
		// 2)
		return companyRepository.save(
					CompanyEntity.builder()
					.name(name)
					.business(business)
					.scale(scale)
					.headcount(headcount)
					.build());
	}
	
	
	// input : params(id, scale, headcount)
	// output : CompanyEntity
	public CompanyEntity updateScaleHeadcountById(int id, String scale, int headcount) {
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// null이 아닌 경우 update
		if(company != null) {
			
			company = company.toBuilder()
						.scale(scale)
						.headcount(headcount)
						.build();
			
			// update
			company = companyRepository.save(company);
		}
		
		return company;			// null or 변경된 CompanyEntity
	}
	
	
	// input : id
	// output : X
	public void deleteById(int id) {
		Optional<CompanyEntity> company =  companyRepository.findById(id);
		company.ifPresent(c -> companyRepository.delete(c));
	}
}
