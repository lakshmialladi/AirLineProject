package com.jsp.airline.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "booking_info")
public class BookingInfo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookingId;
	@Column(nullable = false)
	private String bookingDate;
	@Column(nullable = false)
	private String destination;
	@Column(nullable = false)
	private double fare;
	@Column(nullable = false)
	private String flightDate;
	@Column(unique = true, nullable = false)
	private String flightNumber;
	
	private String status;
	@Column(nullable = false)
	private String flightTime;
	@Column(nullable = false)
	private String currentCity;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bookingInfo")
	private List<Passenger> passengers;
}
