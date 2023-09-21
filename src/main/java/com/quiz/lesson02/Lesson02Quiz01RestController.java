package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController		// @Controller + @ResponseBody
public class Lesson02Quiz01RestController {

	@Autowired
	private StoreBO storeBO;	// DI
	
	// 요청 URL : http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		List<Store> storeList = storeBO.getstoreList();
		return storeList;	// response body 영역에 담겨져서 응답이 내려짐
		// return storeBO.getstoreList();
	}

}
