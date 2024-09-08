package com.telcal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Maasam;

@Repository
public interface MaasamRepo extends JpaRepository<Maasam, Long> {
	// Add custom queries if needed
}