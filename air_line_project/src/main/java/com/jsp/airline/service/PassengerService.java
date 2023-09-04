package com.jsp.airline.service;

import java.util.List;

import com.jsp.airline.dto.BookingInfoDTO;
import com.jsp.airline.dto.CheckinDTO;
import com.jsp.airline.dto.PassengerDTO;

public interface PassengerService 
{

	long addBookingInfo(BookingInfoDTO bookingInfoDtoto);
	
	int addCheckin(CheckinDTO checkinDto);
	
	long registerPassenger(PassengerDTO passengerDto, int bookingInfoId, int checkinId);
	
	BookingInfoDTO bookingDetailsById(int bookingId);
	
	List<BookingInfoDTO> findAllBookingInfo();
}
