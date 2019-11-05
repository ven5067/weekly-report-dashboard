package com.wrd.dto;

public class RiskDto {

	private String area;
	private String riskDetails;
	private int impact;
	private String migrationPlan;

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
