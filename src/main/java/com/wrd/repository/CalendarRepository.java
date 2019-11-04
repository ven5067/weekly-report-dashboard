package com.wrd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wrd.entity.Calendar;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Long>{}
