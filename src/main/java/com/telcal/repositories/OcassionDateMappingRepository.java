package com.telcal.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telcal.entity.OcassionsList;

@Repository
public interface OcassionDateMappingRepository extends JpaRepository<OcassionsList, Long> {

	@Query(value = "SELECT e FROM OcassionsList e WHERE month_number = MONTH(:date) order by ocassion_date")
	List<OcassionsList> findAllOcassionsByMonth(LocalDate date);

	@Query(value = "SELECT e FROM OcassionsList e WHERE year_number = YEAR(:date) order by ocassion_date")
	List<OcassionsList> findAllOcassionsByYear(LocalDate date);

	@Query(value = "SELECT e FROM OcassionsList e WHERE samvathsaram_id = :samvathsaram order by ocassion_date")
	List<OcassionsList> findAllOcassionsBySamvathsaram(int samvathsaram);

	@Query(value = "SELECT e FROM OcassionsList e WHERE ocassion_date between :startDate AND :endDate")
	List<OcassionsList> getDataByDateRange(LocalDate startDate, LocalDate endDate);

	@Query(value = "SELECT e FROM OcassionsList e WHERE ocassion_date = :date")
	List<OcassionsList> getDataByDate(LocalDate date);
}
