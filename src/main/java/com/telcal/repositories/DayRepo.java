package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Day;

@Repository
public interface DayRepo extends JpaRepository<Day, Long> {
	// Add custom queries if needed
}