package com.wrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrd.dto.ObservationDto;
import com.wrd.entity.Observation;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.service.ObservationsService;

@RestController
@RequestMapping("/dashboard")
public class ObservationsController {

	@Autowired
	ObservationsService observationsService;

	@GetMapping("/observations")
	public ResponseEntity<List<Observation>> getObservations() {
		return new ResponseEntity<List<Observation>>(observationsService.getObservation(), HttpStatus.OK);
	}

	@PostMapping("/observation")
	public ResponseEntity<Void> postObservation(@RequestBody ObservationDto observationDto) {
		observationsService.add(observationDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/observation")
	public ResponseEntity<Observation> updateObservation(@RequestBody Observation observation) {
		return new ResponseEntity<Observation>(observationsService.updateObservation(observation), HttpStatus.OK);
	}

	@GetMapping("/observation/{id}")
	public ResponseEntity<Observation> getById(@PathVariable(required = true) long id) throws NotFoundException {
		return new ResponseEntity<Observation>(observationsService.getObservationById(id), HttpStatus.OK);
	}

	@DeleteMapping("/observation/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) long id) {
		observationsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
