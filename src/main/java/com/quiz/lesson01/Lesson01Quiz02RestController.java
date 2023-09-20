package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController		// @Controller + @ResponseBody
public class Lesson01Quiz02RestController {
	
	// 1. json 출력 (List, Map)
	// 요청 URL : http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> lst = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("rate", 15);
		map1.put("director", "봉준호");
		map1.put("time", 131);
		map1.put("title", "기생충");
		lst.add(map1);
		
		// 재활용 가능  map1 = new HashMap<>();
		// 변수만 재사용되는 것이고 다시 객체를 생성한 것이므로 새로운 map인 것임
		Map<String, Object> map2 = new HashMap<>();
		map2.put("rate", 0);
		map2.put("director", "로베르토 베니니");
		map2.put("time", 131);
		map2.put("title", "인생은 아름다워");
		lst.add(map2);
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("rate", 19);
		map3.put("director", "윤종빈");
		map3.put("time", 133);
		map3.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		lst.add(map3);
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("rate", 15);
		map4.put("director", "프란시스 로렌스");
		map4.put("time", 137);
		map4.put("title", "헝거게임");
		lst.add(map4);
		
		Map<String, Object> map5 = new HashMap<>();
		map5.put("rate", 12);
		map5.put("director", "크리스토퍼 놀란");
		map5.put("time", 147);
		map5.put("title", "인셉션");
		lst.add(map5);
		
		return lst;
	}
	
	// 2. json 출력 (List, Class)
	// 요청 URL : http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<PostBoard> quiz02_2() {
		// @ResponseBody + return String => HttpMessageConverter 클래스 동작 -> String이 Html로 해석되어 Response body에 내려감
		// @ResponseBody + return 객체(List, Map, 클래스) => HttpMessageConverter 클래스 jackson라이브러리 동작 -> JSON이 response body에 내려감 => API
		List<PostBoard> lst2 = new ArrayList<PostBoard>();
		PostBoard pb1 = new PostBoard();
		pb1.setTitle("안녕하세요 가입인사 드립니다.");
		pb1.setUser("hagulu");
		pb1.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		lst2.add(pb1);
		
		PostBoard pb2 = new PostBoard();
		pb2.setTitle("헐 대박");
		pb2.setUser("bada");
		pb2.setContent("오늘 목요일이 었어... 금요일인줄");
		lst2.add(pb2);
		
		PostBoard pb3 = new PostBoard();
		pb3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		pb3.setUser("dulumary");
		pb3.setContent("....");
		lst2.add(pb3);
		
		return lst2;
	}
	
	// 3. ResponseEntity
	// 요청 URL : http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<PostBoard> quiz02_3() {
		PostBoard pb4 = new PostBoard();
		pb4.setTitle("안녕하세요 가입인사 드립니다.");
		pb4.setUser("hagulu");
		pb4.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(pb4, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
