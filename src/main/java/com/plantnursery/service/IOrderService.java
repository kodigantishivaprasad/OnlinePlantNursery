package com.plantnursery.service;
import java.util.List;

import com.plantnursery.entity.OrderTable;

public interface IOrderService {
	OrderTable addOrder(OrderTable order);
	
	OrderTable deleteOrder(int bookingId);
	
	OrderTable viewOrder(int bookingId);
	
	List<OrderTable> viewAllOrders();
	
	
	OrderTable updateOrder(OrderTable order,int bookingId);
	
	
}