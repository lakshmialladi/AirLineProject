package com.jsp.airline.service;

import java.util.List;

import com.jsp.airline.dto.FlightDTO;

public interface FlightService 
{
	int addFlight(FlightDTO flightDto, int fareId, int flightInfoId, int inventoryId);
	
	List<FlightDTO> getAllFlights();
	
	List<FlightDTO> searchFlightBySLDFDFN(FlightDTO flightDTO);
	
	List<FlightDTO> searchFlightByALNFNFDFT(FlightDTO flightDTO);
	
	List<FlightDTO> searchFlightByFNFDFT(FlightDTO flightDTO);
}
