package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Quiz03Controller {

	// 요청 URL : http://localhost:8080/lesson01/quiz03/1
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03_1() {
		// @ResponseBody 어노테이션이 없을 때 String을 리턴하면 
		// HttpConverter 가 아닌 ViewResolver가 동작하여 리턴된 String 경로의 jsp view 화면을 찾고
		// 태그가 Response Body에 담긴다.
		return "lesson01/quiz03";
	}
}
