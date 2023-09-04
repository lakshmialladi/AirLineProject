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
public class FlightInfoDTO 
{
	private String flightNumber;
	private String flightTime;
	private String flightType;
	private int noOfSeats;
	
	private AirLineInfoDTO airLineInfos;
//	private FlightDTO flights;
}
