package com.jsp.airline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PassengerDTO 
{
	private String passengerEmailId;
	private String firstName;
	private String lastName;
	private String gender;
	private long mobileNumber;
	
	private BookingInfoDTO booking;
	private CheckinDTO checkin;
}

