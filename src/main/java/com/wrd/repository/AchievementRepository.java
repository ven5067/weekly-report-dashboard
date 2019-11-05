package com.wrd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wrd.entity.Achievement;

@Repository
public interface AchievementRepository extends CrudRepository<Achievement, Long> {}
