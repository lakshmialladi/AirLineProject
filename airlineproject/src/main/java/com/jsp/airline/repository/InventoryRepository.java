package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airline.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>
{

}
