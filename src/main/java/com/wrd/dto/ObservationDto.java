package com.wrd.dto;

import java.util.List;

public class ObservationDto {

	private String name;

	private List<String> observations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getObservations() {
		return observations;
	}

	public void setObservations(List<String> observations) {
		this.observations = observations;
	}

}
