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

import com.wrd.dto.AchievementDto;
import com.wrd.dto.ObservationDto;
import com.wrd.entity.Achievement;
import com.wrd.entity.Observation;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.service.AchievementService;

@RestController
@RequestMapping("/dashboard")
public class AchievementsContoller {
	
	@Autowired
	AchievementService achievementService;

	@GetMapping("/achievements")
	public ResponseEntity<List<Achievement>> getAchievements() {
		return new ResponseEntity<List<Achievement>>(achievementService.getAchievements(), HttpStatus.OK);
	}

	@PostMapping("/achievement")
	public ResponseEntity<Void> postObservation(@RequestBody AchievementDto achievementDto) {
		achievementService.add(achievementDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/achievement")
	public ResponseEntity<Achievement> updateObservation(@RequestBody Achievement achievement) {
		return new ResponseEntity<Achievement>(achievementService.updateAchievement(achievement), HttpStatus.OK);
	}

	@GetMapping("/achievement/{id}")
	public ResponseEntity<Achievement> getById(@PathVariable(required = true) long id) throws NotFoundException {
		return new ResponseEntity<Achievement>(achievementService.getAchievementById(id), HttpStatus.OK);
	}

	@DeleteMapping("/achievement/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) long id) {
		achievementService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
