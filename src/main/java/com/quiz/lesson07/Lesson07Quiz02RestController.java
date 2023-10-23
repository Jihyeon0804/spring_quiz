package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.RecruitBO;
import com.quiz.lesson07.entity.RecruitEntity;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitBO recruitBO;
	
	// URL : http://localhost:8080/lesson07/quiz02/1
	// 1. id가 8인 공고를 조회
	@GetMapping("/1")
	public RecruitEntity getRecruit() {
		return recruitBO.getRecruitById(8);
	}
	
	// 2. companyId가 1인 공고 조회
	@GetMapping("/2")
	public List<RecruitEntity> getRecruitList2() {
		return recruitBO.getRecruitListByCompanyId(1);
	}
	
	// 3. position : 웹 back-end 개발자 이고 type : 정규직인 공고를 조회
	@GetMapping("/3")
	public List<RecruitEntity> getRecruitList3() {
		return recruitBO.getRecruitListByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// 4. 정규직이거나 연봉이 9000 이상인 공고를 조회
	@GetMapping("/4")
	public List<RecruitEntity> getRecruitList4() {
		return recruitBO.getRecruitListByTypeOrSalary("정규직", 9000);
	}
	
	// 5. 계약직(type) 목록을 연봉(salary) 기준으로 내림차순 정렬해서 3개만 조회
	@GetMapping("/5")
	public List<RecruitEntity> getRecruitList5() {
		return recruitBO.getRecruitListByTypeAndSalary("계약직");
	}
	
	// 6. 성남시 분당구가 지역(region)인 연봉(salary) 7000 이상 8500 이하인 공고를 조회
	@GetMapping("/6")
	public List<RecruitEntity> getRecruitList6() {
		return recruitBO.getRecruitListByRegionAndSalary("성남시 분당구", 7000, 8500);
	}
}
