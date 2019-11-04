package com.wrd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Application extends Auditable<String> {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int session;
	private int documentation;
	private int shadowSupport;
	private int reverseKT;
	
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
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public int getDocumentation() {
		return documentation;
	}
	public void setDocumentation(int documentation) {
		this.documentation = documentation;
	}
	public int getShadowSupport() {
		return shadowSupport;
	}
	public void setShadowSupport(int shadowSupport) {
		this.shadowSupport = shadowSupport;
	}
	public int getReverseKT() {
		return reverseKT;
	}
	public void setReverseKT(int reverseKT) {
		this.reverseKT = reverseKT;
	}
	
	
}
