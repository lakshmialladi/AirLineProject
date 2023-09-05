package com.jsp.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.AirLineInfoDTO;
import com.jsp.airline.dto.FareDTO;
import com.jsp.airline.dto.FlightInfoDTO;
import com.jsp.airline.dto.InventoryDTO;
import com.jsp.airline.entity.AirLineInfo;
import com.jsp.airline.entity.Fare;
import com.jsp.airline.entity.FlightInfo;
import com.jsp.airline.entity.Inventory;
import com.jsp.airline.repository.AirLineInfoRepository;
import com.jsp.airline.repository.FareRepository;
import com.jsp.airline.repository.FlightInfoRepository;
import com.jsp.airline.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceImp implements AdminService
{
	@Autowired
	private AirLineInfoRepository airLineInfoRepository;
	@Autowired
	private FlightInfoRepository flightInfoRepository;
	@Autowired
	private FareRepository fareRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public 	AirLineInfoDTO addAirLineInfo(AirLineInfoDTO airLineDto)
	{		
		AirLineInfo airLineInfo = airLineInfoRepository.save(AirLineInfo.builder()
														.airLineName(airLineDto.getAirLineName())
														.build());
		AirLineInfoDTO airLineInfoDTO = AirLineInfoDTO.builder().airLineName(airLineInfo.getAirLineName()).build();
		return airLineInfoDTO;
	}
	
	@Override
	public String removeAirLineInfo(String airLineName) 
	{
		Optional<AirLineInfo> name = airLineInfoRepository.findByAirLineName(airLineName);
		if (name.isEmpty())
		{
			return "Data not found";
		}
		else
		{
			airLineInfoRepository.delete(name.get());
			return "Data deleted";
		}
	}

	@Override
	public List<AirLineInfoDTO> getAllAirLineInfos()
	{
		List<AirLineInfoDTO> list = airLineInfoRepository.findAll().stream().map(t -> AirLineInfoDTO.builder().airLineId(t.getAirLineId()).airLineName(t.getAirLineName()).build()).toList();
		return list;
	}
	
	@Override
	public int addFare(FareDTO fareDto) 
	{
		Fare fare = fareRepository.save(Fare.builder().currency(fareDto.getCurrency())
													  .amount(fareDto.getAmount()).build());
		return fare.getFareId();
	}

	@Override
	public int addInventory(InventoryDTO inventoryDto) 
	{
		Inventory inventory = inventoryRepository.save(Inventory.builder()
														.count(inventoryDto.getCount())
														.build());
		return inventory.getInventoryId();
	}
	
	@Override
	public Optional<FlightInfoDTO> addFlightInfo(FlightInfoDTO flightInfoDto, int airLineId) 
	{
		Optional<AirLineInfo> findById = airLineInfoRepository.findById(airLineId);
		FlightInfo flightInfo = flightInfoRepository.save(FlightInfo.builder()
														.flightNumber(flightInfoDto.getFlightNumber())
														.flightTime(flightInfoDto.getFlightTime())
														.flightType(flightInfoDto.getFlightType())
														.noOfSeats(flightInfoDto.getNoOfSeats())
														.airLineInfo(findById.get())
												        .build());
		Optional<FlightInfoDTO> ofNullable = Optional.ofNullable(FlightInfoDTO.builder().flightNumber(flightInfo.getFlightNumber())
																						.flightTime(flightInfo.getFlightTime())
																						.flightType(flightInfo.getFlightType())
																						.noOfSeats(flightInfo.getNoOfSeats())
																						.airLineInfo(AirLineInfoDTO.builder().airLineId(flightInfo.getAirLineInfo().getAirLineId())
					   										   								 								  .airLineName(flightInfo.getAirLineInfo().getAirLineName())
					   										   								 						 .build())
					   								   						   .build());
		return ofNullable;
	}

	@Override
	public String removeFlightInfo(String flightNumber) 
	{
		Optional<FlightInfo> flightNumber2 = flightInfoRepository.findByFlightNumber(flightNumber);
		if (flightNumber2.isPresent())
		{
			flightInfoRepository.delete(flightNumber2.get());
			return "Particular flight record is deleted";
		}
		else
		{
			return "Flight number not exist";
		}
	}

	@Override
	public FlightInfoDTO modifyFlightInformation(FlightInfoDTO flightInfoDto) 
	{
		Optional<FlightInfo> flightNumber = flightInfoRepository.findByFlightNumber(flightInfoDto.getFlightNumber());
		if (flightNumber.isPresent())
		{
			FlightInfo flightInfo = flightNumber.get();
			flightInfo.setFlightType(flightInfoDto.getFlightType());
			flightInfo.setFlightTime(flightInfoDto.getFlightTime());
			flightInfo.setNoOfSeats(flightInfoDto.getNoOfSeats());
			
			FlightInfo save = flightInfoRepository.save(flightInfo);
			FlightInfoDTO dto = FlightInfoDTO.builder().flightNumber(save.getFlightNumber())
													   .flightTime(save.getFlightTime())
													   .flightType(save.getFlightType())
													   .noOfSeats(save.getNoOfSeats()).build();
			return dto;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<FlightInfoDTO> getAllFlightInfo() 
	{
		List<FlightInfoDTO> list = flightInfoRepository.findAll().stream().map(t -> FlightInfoDTO.builder().flightNumber(t.getFlightNumber())
																										   .flightTime(t.getFlightTime())	
																										   .flightType(t.getFlightType())
																										   .noOfSeats(t.getNoOfSeats())
																										   .airLineInfo(AirLineInfoDTO.builder().airLineId(t.getAirLineInfo().getAirLineId())
																													  							 .airLineName(t.getAirLineInfo().getAirLineName())
																													  				   .build())
																								  .build()).toList();
		return list;
	}

	@Override
	public List<FlightInfoDTO> getFlightInfoBasedOnAirLineName(String airLineName) 
	{
		List<FlightInfoDTO> list = getAllFlightInfo().stream().filter(t -> t.getAirLineInfo().getAirLineName().equalsIgnoreCase(airLineName)).toList();
		return list;
	}
	
}