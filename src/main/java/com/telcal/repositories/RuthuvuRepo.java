package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Ruthuvu;

@Repository
public interface RuthuvuRepo extends JpaRepository<Ruthuvu, Long> {
	// Add custom queries if needed
}