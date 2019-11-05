package com.wrd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Risk {

	@Id
	@GeneratedValue
	private long id;

	private String area;
	private String riskDetails;
	private int impact;
	private String migrationPlan;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRiskDetails() {
		return riskDetails;
	}

	public void setRiskDetails(String riskDetails) {
		this.riskDetails = riskDetails;
	}

	public int getImpact() {
		return impact;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}

	public String getMigrationPlan() {
		return migrationPlan;
	}

	public void setMigrationPlan(String migrationPlan) {
		this.migrationPlan = migrationPlan;
	}

}
