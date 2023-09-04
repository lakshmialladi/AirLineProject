package com.jsp.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.service.FlightService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airlineproject/flight")
public class FlightController 
{
	@Autowired
	private FlightService flightService;
	
	@PostMapping("/addflight/{fareId}/{flightInfoId}/{inventoryId}")
	public ResponseEntity<Integer> addFlight(@RequestBody FlightDTO dto, @PathVariable("fareId") int fareId, @PathVariable("flightInfoId") int flightInfoId, @PathVariable("inventoryId") int inventoryId)
	{
		int i = flightService.addFlight(dto, fareId, flightInfoId, inventoryId);
		return ResponseEntity.status(HttpStatus.CREATED).body(i);
	}
	
	@GetMapping("/getallflights")
	private ResponseEntity<List<FlightDTO>> getAllFlights()
	{
		List<FlightDTO> allFlights = flightService.getAllFlights();
		return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(allFlights);
	}
	
	@GetMapping("/searchflight/{flightDTO}")
	public ResponseEntity<List<FlightDTO>> searchFlightBySLDFDFN(@RequestBody FlightDTO flightDTO)
	{
		List<FlightDTO> list = flightService.searchFlightBySLDFDFN(flightDTO);
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}
	
	@GetMapping("/searchflight/{airLineName}/{flightNumber}/{flightDate}/{flightTime}")
	public ResponseEntity<List<FlightDTO>> searchFlightByALNFNFDFT(@RequestBody FlightDTO flightDTO)
	{
		List<FlightDTO> list = flightService.searchFlightByALNFNFDFT(flightDTO);
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}
	
	@GetMapping("/searchflight/{flightNumber}/{flightDate}/{flightTime}")
	public ResponseEntity<List<FlightDTO>> searchFlightByFNFDFT(@RequestBody FlightDTO flightDTO)
	{
		List<FlightDTO> list = flightService.searchFlightByFNFDFT(flightDTO);
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}
	
}
