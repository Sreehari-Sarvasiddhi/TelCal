package com.telcal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telcal.entity.DailyData;

@Repository
public interface DailyDataRepo extends JpaRepository<DailyData, Long> {
	// Add custom queries if needed

	@Query(value = "SELECT e FROM DailyData e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month")
	List<DailyData> getDataForMonth(@Param("month") int month, @Param("year") int year);

	@Query(value = "SELECT e FROM DailyData e WHERE date = :date")
	List<DailyData> findByDate(LocalDate date);

}