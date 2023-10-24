package com.quiz.lesson07.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@Service
public class RecruitBO {

	@Autowired
	private RecruitRepository recruitRepository;
	
	// input : id
	// output : RecruitEntity
	public RecruitEntity getRecruitById(int id) {
		return recruitRepository.findById(id);
	}
	
	// input : companyId
	// output : List<RecruitEntity>
	public List<RecruitEntity> getRecruitListByCompanyId(int id) {
		return recruitRepository.findByCompanyId(id);
	}
	
	// input : params(position, type)
	// output : List<RecruitEntity>
	public List<RecruitEntity> getRecruitListByPositionAndType(String position, String type) {
		return recruitRepository.findByPositionAndType(position, type);
	}
	
	// input : params(type, salary)
	// output : List<RecruitEntity>
	public List<RecruitEntity> getRecruitListByTypeOrSalary(String type, int salary) {
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual(type, salary);
	}
	
	// input : type
	// output : List<RecruitEntity>
	public List<RecruitEntity> getRecruitListByTypeAndSalary(String type) {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc(type);
	}
	
	// input : params(region, salary)
	// output : List<RecruitEntity>
	public List<RecruitEntity> getRecruitListByRegionAndSalary(String region, int start, int end) {
		return recruitRepository.findByRegionAndSalaryBetween(region, start, end);
	}
	
	
	// input : params(type, deadline, salary)
	// output : List<RecruitEntity>
	public List<RecruitEntity> getRecruitListByDeadlineAndSalary(String type, LocalDate deadline, int salary) {
		return recruitRepository.findByTypeAndDeadlineAfterAndSalaryGreaterThanEqualOrderBySalaryDesc(type, deadline, salary);
	}
}
