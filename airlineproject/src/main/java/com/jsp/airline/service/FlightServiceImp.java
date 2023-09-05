package com.jsp.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.FareDTO;
import com.jsp.airline.dto.FlightDTO;
import com.jsp.airline.dto.InventoryDTO;
import com.jsp.airline.entity.Fare;
import com.jsp.airline.entity.Flight;
import com.jsp.airline.entity.FlightInfo;
import com.jsp.airline.entity.Inventory;
import com.jsp.airline.repository.FareRepository;
import com.jsp.airline.repository.FlightInfoRepository;
import com.jsp.airline.repository.FlightRepository;
import com.jsp.airline.repository.InventoryRepository;

@Service
public class FlightServiceImp implements FlightService
{
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private FlightInfoRepository flightInfoRepository;
	@Autowired
	private FareRepository fareRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Override
	public int addFlight(FlightDTO flightDto, int fareId, int flightInfoId, int inventoryId) 
	{
		Optional<Fare> fare = fareRepository.findById(fareId);
		Optional<FlightInfo> flightInfo = flightInfoRepository.findById(flightInfoId);
		Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
		if (fare.isPresent() && flightInfo.isPresent() && inventory.isPresent())
		{
			Flight flight = flightRepository.save(Flight.builder().destination(flightDto.getDestination())
												  .flightNumber(flightInfoRepository.findById(flightInfoId).get().getFlightNumber())
												  .flightDate(flightDto.getFlightDate())
												  .currentLocation(flightDto.getCurrentLocation())
												  .flightTime(flightDto.getFlightTime())
												  .fare(fare.get())
												  .flightInfo(flightInfo.get())
												 .inventory(inventory.get())
										.build());
			return flight.getFlightId();
		}
		else
		{
			return 0;
		}
	}
	
	public List<FlightDTO> getAllFlights()
	{
		List<FlightDTO> list = flightRepository.findAll().stream().map(flightDb -> FlightDTO.builder().destination(flightDb.getDestination())
															.flightDate(flightDb.getFlightDate()).flightNumber(flightDb.getFlightNumber())
															.flightTime(flightDb.getFlightTime())
															.currentLocation(flightDb.getCurrentLocation())
														.fare(FareDTO.builder().currency(flightDb.getFare().getCurrency())
																.amount(flightDb.getFare().getAmount()).build())
														/*.flightInfo(FlightInfoDTO.builder().flightNumber(flightDb.getFlightInfo().getFlightNumber())
																.flightTime(flightDb.getFlightInfo().getFlightTime())
																.flightType(flightDb.getFlightInfo().getFlightType())
																.noOfSeats(flightDb.getFlightInfo().getNoOfSeats())
																.airLineInfo(AirLineInfoDTO.builder().airLineId(flightDb.getFlightInfo().getAirLineInfo().getAirLineId())
											  							 .airLineName(flightDb.getFlightInfo().getAirLineInfo().getAirLineName())
											  				   .build())
																.build())*/
														.inventory(InventoryDTO.builder().count(flightDb.getInventory().getCount()).build())
													.build()).toList();
		return list;
	}
	
	@Override
	public List<FlightDTO> searchFlightBySLDFDFN(FlightDTO flightDTO)
	{
		return getAllFlights().stream().filter(flight -> flight.getCurrentLocation().equals(flightDTO.getCurrentLocation())
													  && flight.getDestination().equals(flightDTO.getDestination())
													  && flight.getFlightDate().equals(flightDTO.getFlightDate())
													  && flight.getFlightNumber().equals(flightDTO.getFlightNumber()))
												.toList();
	}

	@Override
	public List<FlightDTO> searchFlightByALNFNFDFT(FlightDTO flightDTO) 
	{
		return getAllFlights().stream().filter(flight -> (flight.getFlightInfo().getAirLineInfo().getAirLineName()).equals(flightDTO.getFlightInfo().getAirLineInfo().getAirLineName())
													  && flight.getFlightNumber().equals(flightDTO.getFlightNumber())
													  && flight.getFlightDate().equals(flightDTO.getFlightDate())
													  && flight.getFlightTime().equals(flightDTO.getFlightTime()))
													.toList();
	}

	@Override
	public List<FlightDTO> searchFlightByFNFDFT(FlightDTO flightDTO) 
	{
		return getAllFlights().stream().filter(flight -> flight.getFlightNumber().equals(flightDTO.getFlightNumber())
													  && flight.getFlightDate().equals(flightDTO.getFlightDate())
													  && flight.getFlightTime().equals(flightDTO.getFlightTime()))
													.toList();
	}

}
