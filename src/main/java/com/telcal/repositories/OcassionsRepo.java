package com.telcal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telcal.entity.Ocassions;

@Repository
public interface OcassionsRepo extends JpaRepository<Ocassions, Long> {
	// Add custom queries if needed
	@Query(value = "SELECT e FROM Ocassions e WHERE date = :date order by ocassion_en")
	List<Ocassions> findByDate(LocalDate date);
}