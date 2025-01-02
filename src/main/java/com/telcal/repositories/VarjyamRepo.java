package com.telcal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Varjyam;

@Repository
public interface VarjyamRepo extends JpaRepository<Varjyam, Long> {
	// Add custom queries if needed
	@Query(value = "SELECT e FROM Varjyam e WHERE date = :date order by id")
	List<Varjyam> findByDate(LocalDate date);
}