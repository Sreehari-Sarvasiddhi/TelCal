package com.telcal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telcal.entity.DailyDataView;

@Repository
public interface DailyDataViewRepo extends JpaRepository<DailyDataView, Long> {
	// Add custom queries if needed

//	@Query(value = "SELECT e FROM DailyDataView e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month")
//	List<DailyDataView> getDataForMonth(@Param("month") int month, @Param("year") int year);

	@Query(value = "SELECT e FROM DailyDataView e WHERE date = :date order by id")
	List<DailyDataView> findByDate(LocalDate date);

}