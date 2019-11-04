package com.wrd.repository;

import org.springframework.stereotype.Repository;

import com.wrd.entity.Application;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {}
