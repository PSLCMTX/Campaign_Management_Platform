package com.demo.campaign_management_ms_model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Category")
public class Category {
	private String gaming;
	private String banking;
	private String movie;
	private String music;
	public Category(String gaming, String banking, String movie, String music) {
		super();
		this.gaming = gaming;
		this.banking = banking;
		this.movie = movie;
		this.music = music;
	}
	public String getGaming() {
		return gaming;
	}
	public void setGaming(String gaming) {
		this.gaming = gaming;
	}
	public String getBanking() {
		return banking;
	}
	public void setBanking(String banking) {
		this.banking = banking;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	@Override
	public String toString() {
		return "Category [gaming=" + gaming + ", banking=" + banking + ", movie=" + movie + ", music=" + music + "]";
	}
	
}
