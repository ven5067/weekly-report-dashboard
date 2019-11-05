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

import com.wrd.dto.ApplicationDto;
import com.wrd.entity.Application;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.service.ApplicationService;

@RestController
@RequestMapping("/dashboard")
public class ApplicationsController {
	
	@Autowired private ApplicationService dashboardService;
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Test", HttpStatus.OK);
	}
	
	/*
	 * 
	 * Application APIS
	 * 
	 */
	
	@GetMapping("/application")
    public ResponseEntity<List<Application>> getApplications() {
        return new ResponseEntity<List<Application>>(dashboardService.getApplications(), HttpStatus.OK);
    }
	
	@PostMapping("/application")
	public ResponseEntity<Void> postApplication(@RequestBody ApplicationDto applicationDto) {
		dashboardService.add(applicationDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/application")
	public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
		return new ResponseEntity<Application>(dashboardService.updateApplication(application), HttpStatus.OK);
	}
	
	@GetMapping("/application/{id}")
	public ResponseEntity<Application> getById(@PathVariable(required = true) long id) throws NotFoundException {
		return new ResponseEntity<Application>(dashboardService.getApplicationById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/application/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) long id) {
		dashboardService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}

