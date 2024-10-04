package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.DailyData;

@Repository
public interface DailyDataRepo extends JpaRepository<DailyData, Long> {
	// Add custom queries if needed

}