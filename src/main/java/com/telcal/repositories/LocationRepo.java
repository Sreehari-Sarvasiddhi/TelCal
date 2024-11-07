package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.LocationData;

@Repository
public interface LocationRepo extends JpaRepository<LocationData, Long> {
	// Add custom queries if needed

}