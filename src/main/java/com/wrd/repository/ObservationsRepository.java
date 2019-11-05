package com.wrd.repository;

import org.springframework.data.repository.CrudRepository;

import com.wrd.entity.Observation;

public interface ObservationsRepository extends CrudRepository<Observation, Long>{}
