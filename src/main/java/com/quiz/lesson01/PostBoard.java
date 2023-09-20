package com.quiz.lesson01;

// 일반 자바 bean
public class PostBoard {
	// 필드
	private String title;
	private String user;
	private String content;
	
	// 기본 생성자
	public PostBoard() {
		
	}
	// 파라미터 있는 생성자
	public PostBoard(String title, String user, String content) {
		this.title = title;
		this.user = user;
		this.content = content;
	}
		
	// 메소드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
