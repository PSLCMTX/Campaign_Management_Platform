package com.demo.campaign_management_ms_model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Campaign")
public class Campaign {
	
	@Id
	private long id;
	private String name;
	private  String start_date;
	private String end_date;
	private List state;
	private List channel;
	private long price;
	private List cateogry;
	public Campaign(long id, String name, String start_date, String end_date, List state, List channel, long price,
			List cateogry) {
		super();
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.state = state;
		this.channel = channel;
		this.price = price;
		this.cateogry = cateogry;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public List getState() {
		return state;
	}
	public void setState(List state) {
		this.state = state;
	}
	public List getChannel() {
		return channel;
	}
	public void setChannel(List channel) {
		this.channel = channel;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public List getCateogry() {
		return cateogry;
	}
	public void setCateogry(List cateogry) {
		this.cateogry = cateogry;
	}
	@Override
	public String toString() {
		return "Campaign [id=" + id + ", name=" + name + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", state=" + state + ", channel=" + channel + ", price=" + price + ", cateogry=" + cateogry + "]";
	}
	
}