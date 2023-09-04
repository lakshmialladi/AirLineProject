package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Integer>
{
	
}
