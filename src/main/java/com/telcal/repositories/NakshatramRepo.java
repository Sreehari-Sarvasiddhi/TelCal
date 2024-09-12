package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Nakshatram;

@Repository
public interface NakshatramRepo extends JpaRepository<Nakshatram, Long> {
	// Add custom queries if needed
}