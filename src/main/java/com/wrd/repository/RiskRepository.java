package com.wrd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wrd.entity.Risk;

@Repository
public interface RiskRepository extends CrudRepository<Risk, Long>{}
