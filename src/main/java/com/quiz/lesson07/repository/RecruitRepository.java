package com.quiz.lesson07.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;


@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	// 1.
	public RecruitEntity findById(int id);
	
	// 2.
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	// 3.
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	// 4. 
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 5.
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6.
	public List<RecruitEntity> findByRegionAndSalaryBetween(String type, int start, int end);
	
	// 7. Native query 조회 => DB 직접 조회
	@Query(value="select * from `recruit`"
			+ " where type = :type"
			+ " and deadline > :deadline"
			+ " and salary >= :salary"
			+ " order by salary desc", nativeQuery=true)
	public List<RecruitEntity> findByTypeAndDeadlineAfterAndSalaryGreaterThanEqualOrderBySalaryDesc(
			@Param("type") String type,
			@Param("deadline") LocalDate deadline,
			@Param("salary") int salary);
}
