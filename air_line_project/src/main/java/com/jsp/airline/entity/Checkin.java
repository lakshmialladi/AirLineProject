package com.jsp.airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "checkin")
public class Checkin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int checkinId;
	@Column(unique = true, nullable = false)
	private String seatNumber;
	@Column(unique = true, nullable = false)
	private String gateNumber;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "checkin")
	private Passenger passenger;	
}
