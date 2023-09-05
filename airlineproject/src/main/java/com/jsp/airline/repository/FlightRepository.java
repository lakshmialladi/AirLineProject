package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer>
{
/*	@Query("SELECT f FROM Flight f WHERE f.currentLocation = :currentLocation AND f.destination = :destination AND f.flightDate = :flightDate")
	List<Flight> findBySDFF(@Param("currentLocation") String currentLocation, @Param("destination") String destination, @Param("flightDate") LocalDate flightDate);
	
	@Query("SELECT f FROM Flight f WHERE f.flightInfos = "
			+ "(SELECT fI.flightInfoId FROM FlightInfo fI WHERE fI.airLineInfos = "
			+ "(SELECT a.airLineId FROM AirLineInfo a WHERE a.airLineName = :airLineName)) "
			+ "AND f.flightNumber = :flightNumber AND f.flightDate = :flightDate AND f.flightTime = :flightTime")
	List<Flight> findByAFFF(@Param("airLineName") String airLineName, @Param("flightNumber") String flightNumber, @Param("flightDate") LocalDate flightDate, @Param("flightTime") LocalTime flightTime);
	
	@Query("SELECT f FROM Flight f WHERE f.flightNumber = :flightNumber AND f.flightDate = :flightDate AND f.flightTime = :flightTime ORDER BY (SELECT fare.amount From Fare fare)")
	List<Flight> findByFFF(@Param("flightNumber") String flightNumber, @Param("flightDate") LocalDate flightDate, @Param("flightTime") LocalTime flightTime);
*/
}
