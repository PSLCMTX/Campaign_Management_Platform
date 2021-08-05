package com.demo.campaign_management_ms_model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Channel")
public class Channel {
	private String sms;
	private String mms;
	private String tv;
	public Channel(String sms, String mms, String tv) {
		super();
		this.sms = sms;
		this.mms = mms;
		this.tv = tv;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getMms() {
		return mms;
	}
	public void setMms(String mms) {
		this.mms = mms;
	}
	public String getTv() {
		return tv;
	}
	public void setTv(String tv) {
		this.tv = tv;
	}
	@Override
	public String toString() {
		return "Channel [sms=" + sms + ", mms=" + mms + ", tv=" + tv + "]";
	}
	

}
