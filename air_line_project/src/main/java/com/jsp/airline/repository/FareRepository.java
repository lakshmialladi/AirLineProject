package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.Fare;

public interface FareRepository extends JpaRepository<Fare, Integer>
{

}
