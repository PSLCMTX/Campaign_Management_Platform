package com.demo.campaign_management_ms_model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="State")
public class State {
	
	 private String active;
	 private String suspended;
	 private String terminated;
	public State(String active, String suspended, String terminated) {
		super();
		this.active = active;
		this.suspended = suspended;
		this.terminated = terminated;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getSuspended() {
		return suspended;
	}
	public void setSuspended(String suspended) {
		this.suspended = suspended;
	}
	public String getTerminated() {
		return terminated;
	}
	public void setTerminated(String terminated) {
		this.terminated = terminated;
	}
	@Override
	public String toString() {
		return "State [active=" + active + ", suspended=" + suspended + ", terminated=" + terminated + "]";
	}

}
