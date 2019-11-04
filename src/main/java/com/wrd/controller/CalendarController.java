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

import com.wrd.dto.CalendarDto;
import com.wrd.entity.Calendar;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.service.CalendarService;

@RestController
@RequestMapping("/dashboard")
public class CalendarController {
	
	@Autowired CalendarService calendarService;
	
	@GetMapping("/calendar")
    public ResponseEntity<List<Calendar>> getApplications() {
        return new ResponseEntity<List<Calendar>>(calendarService.getCalendar(), HttpStatus.OK);
    }
	
	@PostMapping("/calendar")
	public ResponseEntity<Void> postApplication(@RequestBody CalendarDto calendarDto) {
		calendarService.add(calendarDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/calendar")
	public ResponseEntity<Calendar> updateApplication(@RequestBody Calendar calendar) {
		return new ResponseEntity<Calendar>(calendarService.updateCalendar(calendar), HttpStatus.OK);
	}
	
	@GetMapping("/calendar/{id}")
	public ResponseEntity<Calendar> getById(@PathVariable(required = true) long id) throws NotFoundException {
		return new ResponseEntity<Calendar>(calendarService.getCalendarById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/calendar/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true) long id) {
		calendarService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
