package com.wrd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrd.dto.FocusDto;
import com.wrd.entity.Focus;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.repository.FocusRepository;

@Service
public class FocusService {
	
	@Autowired private FocusRepository focusRepository;

	public List<Focus> getFocusList() {
		return (List<Focus>) focusRepository.findAll();
	}

	public void add(FocusDto focusDto) {
		focusRepository.save(toEntity(focusDto));
	}

	public Focus updateFocus(Focus focus) {
		return focusRepository.save(focus);
	}

	public void delete(long id) {
		focusRepository.deleteById(id);
	}

	public Focus getFocusById(long id) throws NotFoundException {
		Optional<Focus> optional = focusRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Application with id: " + id));
	}
	
	private Focus toEntity(FocusDto focusDto) {
		Focus entity = new Focus();
		entity.setFocus(focusDto.getFocus());
		
		return entity;
	}

}
