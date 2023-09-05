package com.jsp.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.BookingInfoDTO;
import com.jsp.airline.dto.CheckinDTO;
import com.jsp.airline.dto.PassengerDTO;
import com.jsp.airline.entity.BookingInfo;
import com.jsp.airline.entity.Checkin;
import com.jsp.airline.entity.Passenger;
import com.jsp.airline.repository.BookingInfoRepository;
import com.jsp.airline.repository.CheckinRepository;
import com.jsp.airline.repository.PassengerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PassengerServiceImp implements PassengerService
{
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private BookingInfoRepository bookingInfoRepository;
	@Autowired
	private CheckinRepository checkinRepository;

	@Override
	public long addBookingInfo(BookingInfoDTO bookingInfoDto) 
	{
		BookingInfo bookingInfo = bookingInfoRepository.save(BookingInfo
												   .builder().bookingDate(bookingInfoDto.getBookingDate())
												   		.destination(bookingInfoDto.getDestination())
														.fare(bookingInfoDto.getFare())
														.flightDate(bookingInfoDto.getFlightDate())
														.flightNumber(bookingInfoDto.getFlightNumber())
														.status(bookingInfoDto.getStatus())
														.flightTime(bookingInfoDto.getFlightTime())
														.currentCity(bookingInfoDto.getCurrentCity())
													.build());
		return bookingInfo.getBookingId();
	}
	
	@Override
	public int addCheckin(CheckinDTO checkinDTO) 
	{
		Checkin checkin = checkinRepository.save(Checkin.builder().seatNumber(checkinDTO.getSeatNumber())
																  .gateNumber(checkinDTO.getGateNumber())
														.build());
		return checkin.getCheckinId();
	}

	@Override
	public long registerPassenger(PassengerDTO passengerDTO, Long bookingInfoId, int checkinId)
	{
		Optional<BookingInfo> bookingInfo = bookingInfoRepository.findById(bookingInfoId);
		Optional<Checkin> checkin = checkinRepository.findById(checkinId);
		if (bookingInfo.isPresent() && checkin.isPresent())
		{
			BookingInfo bookingInfo2 = bookingInfo.get();
			Checkin checkin2 = checkin.get();
			Passenger passenger = passengerRepository.save(Passenger.builder().passengerEmailId(passengerDTO.getPassengerEmailId())
																			  .firstName(passengerDTO.getFirstName())
																			  .lastName(passengerDTO.getLastName())
																			  .gender(passengerDTO.getGender())
																			  .mobileNumber(passengerDTO.getMobileNumber())
																			  .bookingInfo(bookingInfo2)
																			  .checkin(checkin2)
																	 .build());
			return passenger.getPassengerId();
		}
		else
		{
			return 0;
		}
	}

	@Override
	public BookingInfoDTO bookingDetailsById(Long bookingId) 
	{
		Optional<BookingInfo> id = bookingInfoRepository.findById(bookingId);
		if (id.isPresent())
		{
			BookingInfo info = id.get();
			BookingInfoDTO build = BookingInfoDTO.builder().bookingDate(info.getBookingDate())
														   .destination(info.getDestination())
														   .fare(info.getFare())
														   .flightDate(info.getFlightDate())
														   .flightNumber(info.getFlightNumber())
														   .status(info.getStatus())
														   .flightTime(info.getFlightTime())
														   .currentCity(info.getCurrentCity())
														   .passengers(info.getPassengers()
																   .stream().map(p -> PassengerDTO.builder()
																		   				 .passengerEmailId(p.getPassengerEmailId())
																		   				 .firstName(p.getFirstName())
																		   				 .lastName(p.getLastName())
																		   				 .gender(p.getGender())
																		   				 .mobileNumber(p.getMobileNumber())
																		   				 .build()).toList())
														   .build();
			return build;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<BookingInfoDTO> findAllBookingInfo()
	{
		return bookingInfoRepository.findAll().stream()
				.map(b -> BookingInfoDTO.builder()
						.bookingDate(b.getBookingDate())
						.destination(b.getDestination())
				  		.fare(b.getFare()).flightDate(b.getFlightDate())
				  		.flightNumber(b.getFlightNumber())
				  		.status(b.getStatus()).flightTime(b.getFlightTime())
				  		.currentCity(b.getCurrentCity())
				  		.passengers(b.getPassengers().stream().map(p -> PassengerDTO.builder()
				  				  		.passengerEmailId(p.getPassengerEmailId())
				  				  		.firstName(p.getFirstName())
				  				  		.lastName(p.getLastName())
				  				  		.gender(p.getGender())
				  				  		.mobileNumber(p.getMobileNumber())
								  .build()).toList())
				  .build()).toList();
		
	}

}