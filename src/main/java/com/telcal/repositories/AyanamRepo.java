package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Ayanam;

@Repository
public interface AyanamRepo extends JpaRepository<Ayanam, Long> {
	// Add custom queries if needed
}