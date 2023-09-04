package com.jsp.airline.dto;

import java.time.LocalDate;
import java.time.LocalTime;
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
	private LocalDate bookingDate;
	private String destination;
	private double fare;
	private LocalDate flightDate;
	private String flightNumber;
	private String status;
	private LocalTime flightTime;
	private String currentCity;
	
	private List<PassengerDTO> passengers;
}
