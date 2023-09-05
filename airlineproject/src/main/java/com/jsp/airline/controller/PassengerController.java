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

import com.jsp.airline.dto.BookingInfoDTO;
import com.jsp.airline.dto.CheckinDTO;
import com.jsp.airline.dto.PassengerDTO;
import com.jsp.airline.service.PassengerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/airlineproject")
public class PassengerController 
{
	@Autowired
	private PassengerService passengerService;
	
	@PostMapping("/addbookinginfo")
	public ResponseEntity<Long> addBookingInfo(@RequestBody BookingInfoDTO bookingInfoDTO)
	{
		long booking = passengerService.addBookingInfo(bookingInfoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(booking);
	}
	
	@PostMapping("/addcheckin")
	public ResponseEntity<Integer> addCheckin(@RequestBody CheckinDTO checkinDTO)
	{
		int checkin = passengerService.addCheckin(checkinDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(checkin);
	}
	
	@PostMapping("/registerpassenger/{bookingInfoId}/{checkinId}")
	public ResponseEntity<Long> registerPassenger(@RequestBody PassengerDTO passengerDTO, @PathVariable("bookingInfoId") Long bookingInfoId, @PathVariable("checkinId") int checkinId)
	{
		long i = passengerService.registerPassenger(passengerDTO, bookingInfoId, checkinId);
		return ResponseEntity.status(HttpStatus.CREATED).body(i);
	}

	@GetMapping("/findbookinginfo/{bookingId}")
	public ResponseEntity<BookingInfoDTO> findBookById(@PathVariable("bookingId") Long id)
	{
		BookingInfoDTO dto = passengerService.bookingDetailsById(id);
		if (dto != null)
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(dto);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/getallbookinginfo")
	public ResponseEntity<List<BookingInfoDTO>> getAllBookingInfo()
	{
		List<BookingInfoDTO> list = passengerService.findAllBookingInfo();
		return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(list);
	}

}