package com.wrd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrd.dto.ObservationDto;
import com.wrd.entity.Observation;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.repository.ObservationsRepository;

@Service
public class ObservationsService {
	
	@Autowired
	private ObservationsRepository observationsRepository;

	public void add(ObservationDto observationDto) {
		observationsRepository.save(toEntity(observationDto));
	}

	public void delete(long id) {
		observationsRepository.deleteById(id);
	}

	public List<Observation> getObservation() {
		return (List<Observation>) observationsRepository.findAll();
	}

	public Observation getObservationById(long id) throws NotFoundException {
		Optional<Observation> optional = observationsRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Calendar with id: " + id));
	}

	public Observation updateObservation(Observation observation) {
		return observationsRepository.save(observation);
	}

	private Observation toEntity(ObservationDto observationDto) {
		Observation entity = new Observation();
		entity.setName(observationDto.getName());
		entity.setObservations(observationDto.getObservations());
		
		return entity;
	}
}
