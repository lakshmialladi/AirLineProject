package com.jsp.airline.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.AirLineInfo;

public interface AirLineInfoRepository extends JpaRepository<AirLineInfo, Integer>
{
	Optional<AirLineInfo> findByAirLineName(String name);
}
