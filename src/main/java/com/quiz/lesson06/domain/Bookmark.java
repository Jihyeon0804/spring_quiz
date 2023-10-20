package com.quiz.lesson06.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Bookmark {
	private int id;
	private String name;
	private String url;
	private Date createdAt;
	private Date updatedAt;
}