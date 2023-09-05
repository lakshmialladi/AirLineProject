package com.jsp.airline.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.AirLineInfoDTO;
import com.jsp.airline.dto.FareDTO;
import com.jsp.airline.dto.FlightInfoDTO;
import com.jsp.airline.dto.InventoryDTO;
import com.jsp.airline.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airlineproject")
public class AdminController 
{
	@Autowired
	private AdminService adminService;

	@PostMapping("/addairlineinfo")
	public ResponseEntity<AirLineInfoDTO> addAirLine(@RequestBody AirLineInfoDTO airLineDto)
	{
		System.out.println(airLineDto);
		AirLineInfoDTO airLineInfo = adminService.addAirLineInfo(airLineDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(airLineInfo);
	}
	
	@DeleteMapping("/removeairlineinfo/{airLineName}")
	public ResponseEntity<String> removeAirLine(@PathVariable("airLineName") String airLineName)
	{
		String removeAirLineInfo = adminService.removeAirLineInfo(airLineName);
		if (removeAirLineInfo.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Air line name not exist");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body("Particular air line data is deleted");
		}
	}

	@GetMapping("/allairlineinfos")
	public ResponseEntity<List<AirLineInfoDTO>> getAllAirLines()
	{
		List<AirLineInfoDTO> allAirLineInfos = adminService.getAllAirLineInfos();
		return ResponseEntity.status(HttpStatus.OK).body(allAirLineInfos);
	}
	
	@PostMapping("/addfare")
	public ResponseEntity<Integer> addFare(@RequestBody FareDTO dto)
	{
		int fare = adminService.addFare(dto);
		return ResponseEntity.status(HttpStatus.OK).body(fare);
	}
	
	@PostMapping("/addinventory")
	public ResponseEntity<Integer> addInventory(@RequestBody InventoryDTO dto)
	{
		int i = adminService.addInventory(dto);
		return ResponseEntity.status(HttpStatus.OK).body(i);
	}
	
	@PostMapping("/addflightinfo/{airLineId}")
	public ResponseEntity<Optional<FlightInfoDTO>> addFlightInfo(@RequestBody FlightInfoDTO dto,@PathVariable("airLineId") int airLineId)
	{
		Optional<FlightInfoDTO> info = adminService.addFlightInfo(dto, airLineId);
		return ResponseEntity.status(HttpStatus.OK).body(info);
	}
	
	@DeleteMapping("/removeflightinfo/{flightNumber}")
	public ResponseEntity<String> removeFlightInfo(@PathVariable("flightNumber") String flightNumber)
	{
		String removeFlightInfo = adminService.removeFlightInfo(flightNumber);
		if (removeFlightInfo.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Flight number not exist");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body("Particular flight is removed");
		}
	}
	
	@PutMapping("/modifyflightinfo")
	public ResponseEntity<FlightInfoDTO> modifyFlightInformation(@RequestBody FlightInfoDTO flightInfoDto)
	{
		FlightInfoDTO dto = adminService.modifyFlightInformation(flightInfoDto);
		if (dto != null)
		{
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@GetMapping("/getallflightinfos")
	public ResponseEntity<List<FlightInfoDTO>> getAllFlightInfo()
	{
		List<FlightInfoDTO> allFlightInfo = adminService.getAllFlightInfo();
		return ResponseEntity.status(HttpStatus.FOUND).body(allFlightInfo);
	}
	
	@GetMapping("/getflightinfobasedonairlinename/{airlinename}")
	public ResponseEntity<List<FlightInfoDTO>> getFlightInfoBasedOnAirLineName(@PathVariable("airlinename") String airLineName)
	{
		List<FlightInfoDTO> name = adminService.getFlightInfoBasedOnAirLineName(airLineName);
		if (name.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(name);
		}
	}
	
}
