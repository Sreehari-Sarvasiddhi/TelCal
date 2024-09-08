package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Samvathsaram;

@Repository
public interface SamvathsaramRepo extends JpaRepository<Samvathsaram, Long> {
	// Add custom queries if needed
}