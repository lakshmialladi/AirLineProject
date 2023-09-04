package com.jsp.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.FlightInfo;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Integer>
{
	Optional<FlightInfo> findByFlightNumber(String flightNumber);
}
