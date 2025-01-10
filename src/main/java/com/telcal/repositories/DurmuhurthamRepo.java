package com.telcal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Durmuhurtham;

@Repository
public interface DurmuhurthamRepo extends JpaRepository<Durmuhurtham, Long> {
	// Add custom queries if needed
	@Query(value = "SELECT e FROM Durmuhurtham e WHERE date = :date order by from_time")
	List<Durmuhurtham> findByDate(LocalDate date);
}