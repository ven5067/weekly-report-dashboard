package com.wrd.dto;

public class ApplicationDto {
	private String name;
	private int session;
	private int documentation;
	private int shadowSupport;
	private int reverseKT;

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
