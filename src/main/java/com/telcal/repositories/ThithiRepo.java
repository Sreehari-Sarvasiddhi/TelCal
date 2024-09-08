package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Thithi;

@Repository
public interface ThithiRepo extends JpaRepository<Thithi, Long> {
	// Add custom queries if needed
}