package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		
		// 응답값 : JSON String
		/*	{
				"code" : 1
				, "result" : "success"
			}*/
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result;	// JSON String
	}
	
	
	// 중복 확인 로직
	@ResponseBody
	@RequestMapping("/quiz01/is-duplication")
	public Map<String, Object> isDuplication(
			@RequestParam("url") String url) {
		
		// 중복 확인
		boolean isDuplicated = bookmarkBO.existBookmarkByUrl(url);
		
		// 응답값 : JSON String
		/*	{
				"code" : 1
				, "result" : "success"
			}*/
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", isDuplicated);
		
		return result;	// JSON String
	}
	
	
	// 북마크 목록 화면
	@GetMapping("/quiz01/bookmark-list-view")
	public String bookmarkListView(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/bookmarkList";
	}
	
	
	// 북마크 삭제
	@ResponseBody
	@GetMapping("/quiz01/delete-bookmark")
	public String deleteBSookmark(@RequestParam("id") int id) {
		bookmarkBO.deleteBookmarkById(id);
		return "redirect:/lesson06/quiz01/bookmark-list-view";
	}
	// ----- quiz01 끝 -----
}
