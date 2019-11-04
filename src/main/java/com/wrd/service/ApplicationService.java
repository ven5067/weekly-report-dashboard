package com.wrd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrd.dto.ApplicationDto;
import com.wrd.entity.Application;
import com.wrd.entity.exception.NotFoundException;
import com.wrd.repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	ApplicationRepository dashboardRepository;

	public void add(ApplicationDto applicationDto) {
		dashboardRepository.save(toEntity(applicationDto));
	}

	public void delete(long id) {
		dashboardRepository.deleteById(id);
	}

	public List<Application> getApplications() {
		return (List<Application>) dashboardRepository.findAll();
	}

	public Application getApplicationById(long id) throws NotFoundException {
		Optional<Application> optionalDog = dashboardRepository.findById(id);
		return optionalDog.orElseThrow(() -> new NotFoundException("Couldn't find a Application with id: " + id));
	}
	
	public Application updateApplication(Application application) {
		return dashboardRepository.save(application);
	}

	private Application toEntity(ApplicationDto applicationDto) {
		Application entity = new Application();
		entity.setName(applicationDto.getName());
		entity.setDocumentation(applicationDto.getDocumentation());
		entity.setSession(applicationDto.getSession());
		entity.setShadowSupport(applicationDto.getShadowSupport());
		entity.setReverseKT(applicationDto.getReverseKT());

		return entity;
	}

}
