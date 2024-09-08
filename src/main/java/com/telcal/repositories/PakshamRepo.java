package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Paksham;

@Repository
public interface PakshamRepo extends JpaRepository<Paksham, Long> {
	// Add custom queries if needed
}