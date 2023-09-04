package com.jsp.airline.dto;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class FlightDTO 
{
	private String destination;
	private LocalDate flightDate;
	private String flightNumber;
	private LocalTime flightTime;
	private String currentLocation;
	
	private FareDTO fares;
	private FlightInfoDTO flightInfos;
	private InventoryDTO inventories;
}
