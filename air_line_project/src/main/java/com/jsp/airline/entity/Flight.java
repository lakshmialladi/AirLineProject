package com.jsp.airline.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "flight")
public class Flight 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;
	@Column(nullable = false)
	private String destination;
	@Column(nullable = false)
	private LocalDate flightDate;
	@Column(nullable = false)
	private String flightNumber;
	@Column(nullable = false)
	private LocalTime flightTime;
	@Column(nullable = false)
	private String currentLocation;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fareId")
	private Fare fare;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "flightInfoId")
	private FlightInfo flightInfo;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "inventoryId")
	private Inventory inventory;
	
}
