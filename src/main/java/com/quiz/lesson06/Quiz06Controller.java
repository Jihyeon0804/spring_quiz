package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Quiz06Controller {

	@Autowired
	private BookmarkBO bookmarkBO;

	// ------ quiz01 ------
	// 북마크 추가 화면
	// URL : http://localhost:8080/lesson06/quiz01/add-bookmark-view
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}

	// 북마크 추가 로직 - AJAX가 하는 요청
	@PostMapping("/quiz01/add-bookmark")
	@ResponseBody
	public Map<String, Object> addBookmark(@RequestParam("name") String name, @RequestParam("url") String url) {

		// db insert
		bookmarkBO.addBookmark(name, url);

		// 응답값 : JSON String
		/*
		 * { "code" : 1 , "result" : "success" }
		 */
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");

		return result; // JSON String
	}

	// 중복 확인 로직
	@ResponseBody
	@RequestMapping("/quiz01/is-duplication")
	public Map<String, Object> isDuplication(@RequestParam("url") String url) {

		// 중복 확인
		boolean isDuplicated = bookmarkBO.existBookmarkByUrl(url);

		// 응답값 : JSON String
		/*
		 * { "code" : 1 , "result" : "success" }
		 */
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplicated);

		return result; // JSON String
	}

	// 북마크 목록 화면
	@GetMapping("/quiz01/bookmark-list-view")
	public String bookmarkListView(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/bookmarkList";
	}
	// ----- quiz01 끝 -----

	// ------ quiz02 -------
	// URL 중복 확인 - AJAX 요청
	@ResponseBody
	@PostMapping("/quiz02/is-duplicated-url")
	public Map<String, Object> isDuplicatedUrl(@RequestParam("url") String url) {

		// db 조회
		// count 함수를 사용하지 않고 조건문에 걸리는 전체 행을 가져올 것임(결과는 행이 있거나 없거나)
		Bookmark bookmark = bookmarkBO.getBookmarkByUrl(url);

		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", false);
		if (bookmark != null) { // 중복일 때 - 조회한 행이 있는 경우
			result.put("is_duplication", true); // is_duplication key의 값을 true로 변경
		}

		return result;
	}

	// 북마크 삭제	- AJAX 호출
	@ResponseBody
	@DeleteMapping("/quiz02/delete-bookmark")
	public Map<String, Object> deleteBSookmark(@RequestParam("id") int id) {
		
		// db delete
		bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result; // json
	}
}
