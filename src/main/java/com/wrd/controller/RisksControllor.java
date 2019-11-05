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

import com.wrd.dto.RiskDto;
import com.wrd.entity.Risk;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.service.RiskService;

@RestController
@RequestMapping("/dashboard")
public class RisksControllor {

	@Autowired private RiskService riskService;

	@GetMapping("/risks")
	public ResponseEntity<List<Risk>> getRisks() {
		return new ResponseEntity<List<Risk>>(riskService.getRisks(), HttpStatus.OK);
	}

	@PostMapping("/risk")
	public ResponseEntity<Void> postRisk(@RequestBody RiskDto riskDto) {
		riskService.add(riskDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/risk")
	public ResponseEntity<Risk> updateAchievement(@RequestBody Risk risk) {
		return new ResponseEntity<Risk>(riskService.updateRisk(risk), HttpStatus.OK);
	}

	@GetMapping("/risk/{id}")
	public ResponseEntity<Risk> getById(@PathVariable(required = true) long id) throws NotFoundException {
		return new ResponseEntity<Risk>(riskService.getRiskById(id), HttpStatus.OK);
	}

	@DeleteMapping("/risk/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) long id) {
		riskService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
