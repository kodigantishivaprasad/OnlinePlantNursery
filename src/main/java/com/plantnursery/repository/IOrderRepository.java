package com.plantnursery.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantnursery.entity.OrderTable;


@Repository
public interface IOrderRepository extends JpaRepository<OrderTable, Integer> {
	Optional<OrderTable> findById(Integer bookingOrderId);
}