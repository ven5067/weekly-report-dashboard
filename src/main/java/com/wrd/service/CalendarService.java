package com.wrd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrd.dto.CalendarDto;
import com.wrd.entity.Calendar;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.repository.CalendarRepository;

@Service
public class CalendarService {

	@Autowired private CalendarRepository calendarRepository;
	
	public void add(CalendarDto calendarDto) {
		calendarRepository.save(toEntity(calendarDto));
	}

	public void delete(long id) {
		calendarRepository.deleteById(id);
	}

	public List<Calendar> getCalendar() {
		return (List<Calendar>) calendarRepository.findAll();
	}

	public Calendar getCalendarById(long id) throws NotFoundException {
		Optional<Calendar> optionalDog = calendarRepository.findById(id);
		return optionalDog.orElseThrow(() -> new NotFoundException("Couldn't find a Calendar with id: " + id));
	}
	
	public Calendar updateCalendar(Calendar calendar) {
		return calendarRepository.save(calendar);
	}

	private Calendar toEntity(CalendarDto calendarDto) {
		Calendar entity = new Calendar();
		entity.setMonday(calendarDto.getMonday());
		entity.setTuesday(calendarDto.getTuesday());
		entity.setWednesday(calendarDto.getWednesday());
		entity.setThursday(calendarDto.getThursday());
		entity.setFriday(calendarDto.getFriday());
		entity.setSaturday(calendarDto.getSaturday());
		entity.setSunday(calendarDto.getSunday());
		entity.setWeekE(calendarDto.getWeekE());
		
		return entity;
	}
}
