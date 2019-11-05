package com.wrd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrd.dto.AchievementDto;
import com.wrd.entity.Achievement;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.repository.AchievementRepository;

@Service
public class AchievementService {
	
	@Autowired private AchievementRepository achievementRepository;

	public void add(AchievementDto achievementDto) {
		achievementRepository.save(toEntity(achievementDto));
	}

	public List<Achievement> getAchievements() {
		return (List<Achievement>) achievementRepository.findAll();
	}

	public Achievement updateAchievement(Achievement achievement) {
		return achievementRepository.save(achievement);
	}

	public Achievement getAchievementById(long id) throws NotFoundException {
		Optional<Achievement> optional = achievementRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Application with id: " + id));
	}

	public void delete(long id) {
		achievementRepository.deleteById(id);
	}
	
	private Achievement toEntity(AchievementDto achievementDto) {
		Achievement entity = new Achievement();
		entity.setAchievement(entity.getAchievement());
		return entity;
	}

	
}
