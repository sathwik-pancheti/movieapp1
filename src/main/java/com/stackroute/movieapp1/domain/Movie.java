package com.stackroute.movieapp1.domain;

import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

import lombok.Data;

@Document
public class Movie {
	
	
	private int id;
	private String title;
	private String imdbId;
	private String year;
	private String poster;
	
	public Movie() {
		
	}
	
	
	public Movie(int id,String title, String imdbId, String year, String poster) {
		super();
		this.id = id;
		this.title = title;
		this.imdbId = imdbId;
		this.year = year;
		this.poster = poster;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", imdbId=" + imdbId + ", year=" + year + ", poster=" + poster + "]";
	}
	
	
}
