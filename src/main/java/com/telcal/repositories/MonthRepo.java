package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Month;

@Repository
public interface MonthRepo extends JpaRepository<Month, Long> {
	// Add custom queries if needed
}