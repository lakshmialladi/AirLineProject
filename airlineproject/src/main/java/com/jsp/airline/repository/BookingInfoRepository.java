package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.BookingInfo;

public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long>
{
	
}
