package com.telcal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Amrutham;

@Repository
public interface AmruthamRepo extends JpaRepository<Amrutham, Long> {
	// Add custom queries if needed
	@Query(value = "SELECT e FROM Amrutham e WHERE date = :date order by id")
	List<Amrutham> findByDate(LocalDate date);
}