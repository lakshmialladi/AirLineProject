package com.jsp.airline.dto;

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
public class AirLineInfoDTO 
{
	private int airLineId;
	private String airLineName;
//	private List<FlightInfoDTO> flightInfos;
}
