package com.jsp.airline.dto;

import java.util.List;

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
public class BookingInfoDTO 
{
	private String bookingDate;
	private String destination;
	private double fare;
	private String flightDate;
	private String flightNumber;
	private String status;
	private String flightTime;
	private String currentCity;
	
	private List<PassengerDTO> passengers;
}
