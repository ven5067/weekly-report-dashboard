package com.wrd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrd.dto.RiskDto;
import com.wrd.entity.Risk;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.repository.RiskRepository;

@Service
public class RiskService {
	
	@Autowired private RiskRepository riskRepository;
	
	public void add(RiskDto riskDto) {
		riskRepository.save(toEntity(riskDto));
	}

	public List<Risk> getRisks() {
		return (List<Risk>) riskRepository.findAll();
	}

	public Risk updateRisk(Risk risk) {
		return riskRepository.save(risk);
	}

	public Risk getRiskById(long id) throws NotFoundException {
		Optional<Risk> optional = riskRepository.findById(id);
		return optional.orElseThrow(() -> new NotFoundException("Couldn't find a Application with id: " + id));
	}

	public void delete(long id) {
		riskRepository.deleteById(id);
	}
	
	private Risk toEntity(RiskDto riskDto) {
		Risk entity = new Risk();
		entity.setArea(riskDto.getArea());
		entity.setImpact(riskDto.getImpact());
		entity.setMigrationPlan(riskDto.getMigrationPlan());
		entity.setRiskDetails(riskDto.getRiskDetails());
		
		return entity;
	}
}
