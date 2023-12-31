package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {

	@Autowired
	private CompanyBO companyBO;
	
	@RequestMapping("/save1")
	public CompanyEntity addCompany1() {
		
//		회사명 : 넥손
//		사업내용 : 컨텐츠 게임
//		규모 : 대기업
//		사원수 : 3585명
		
		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		// JSON
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@RequestMapping("/save2")
	public CompanyEntity addCompany2() {
		
//		회사명 : 버블팡
//		사업내용 : 여신 금융업
//		규모 : 대기업
//		사원수 : 6834명
		
		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	
	@RequestMapping("/update")
	public CompanyEntity updateCompany() {
		// id : 8(버블팡) => scale="중소기업", headcount=34;
		
		return companyBO.updateScaleHeadcountById(8, "중소기업", 34);
		
	}
	
	@RequestMapping("/delete")
	public String deleteCompany() {
		// id : 8 (버블팡)
		companyBO.deleteById(8);
		
		return "수행 완료";
	}
}
