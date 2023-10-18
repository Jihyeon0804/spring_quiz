package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	// input : name, url
	// output : X
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input : X
	// output : List<Bookmark>
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	// input : url
	// output : boolean
	public boolean existBookmarkByUrl(String url) {
		return bookmarkMapper.existBookmarkByUrl(url);
	}
	
	// input : id
	// output : X
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
	
	// input : url
	// output : Bookmark(단건이거나 null이거나)
	// Too many result 에러 => 단건으로 리턴하지만 결과는 List로 나왔을 때
	// 중복이 없다고 가정하고 구성
	public Bookmark getBookmarkByUrl(String url) {
		return bookmarkMapper.selectBookmarkByUrl(url);
	}
}
