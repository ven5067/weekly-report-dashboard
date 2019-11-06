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

import com.wrd.dto.FocusDto;
import com.wrd.entity.Focus;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.service.FocusService;

@RestController
@RequestMapping("/dashboard")
public class FocusController {
	
	@Autowired private FocusService focusService;

	@GetMapping("/focusList")
	public ResponseEntity<List<Focus>> getFocusList() {
		return new ResponseEntity<List<Focus>>(focusService.getFocusList(), HttpStatus.OK);
	}

	@PostMapping("/focus")
	public ResponseEntity<Void> postAchievement(@RequestBody FocusDto focusDto) {
		focusService.add(focusDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/focus")
	public ResponseEntity<Focus> updateAchievement(@RequestBody Focus focus) {
		return new ResponseEntity<Focus>(focusService.updateFocus(focus), HttpStatus.OK);
	}

	@GetMapping("/focus/{id}")
	public ResponseEntity<Focus> getById(@PathVariable(required = true) long id) throws NotFoundException {
		return new ResponseEntity<Focus>(focusService.getFocusById(id), HttpStatus.OK);
	}

	@DeleteMapping("/focus/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) long id) {
		focusService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
