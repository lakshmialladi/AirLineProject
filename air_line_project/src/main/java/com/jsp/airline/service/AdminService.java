package com.jsp.airline.service;

import java.util.List;
import java.util.Optional;

import com.jsp.airline.dto.AirLineInfoDTO;
import com.jsp.airline.dto.FareDTO;
import com.jsp.airline.dto.FlightInfoDTO;
import com.jsp.airline.dto.InventoryDTO;

public interface AdminService 
{
	AirLineInfoDTO addAirLineInfo(AirLineInfoDTO airLineDto);
	
	String removeAirLineInfo(String airLineName);
	
	List<AirLineInfoDTO> getAllAirLineInfos();
	
	int addFare(FareDTO fareDto);
	
	int addInventory(InventoryDTO inventoryDto);
	
	Optional<FlightInfoDTO> addFlightInfo(FlightInfoDTO flightInfoDto, int airLineId);
	
	String removeFlightInfo(String flightNumber);
	
	FlightInfoDTO modifyFlightInformation(FlightInfoDTO flightInfoDto);
	
	List<FlightInfoDTO> getAllFlightInfo();
	
	List<FlightInfoDTO> getFlightInfoBasedOnAirLineName(String airLineName);
}
