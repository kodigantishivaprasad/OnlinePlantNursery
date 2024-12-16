package com.plantnursery.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plantnursery.entity.OrderTable;
import com.plantnursery.entity.Plant;
import com.plantnursery.exceptions.OrderIdNotFoundException;
import com.plantnursery.exceptions.PlantIdNotFoundException;
import com.plantnursery.repository.IOrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderRepository orderRepository;

	@Override
	public OrderTable addOrder(OrderTable order) {
		orderRepository.save(order);
		return order;
	}

	@Override
	public OrderTable updateOrder(OrderTable order,int bookingId) {
		Optional<OrderTable> orderToBeUpdated = orderRepository.findById(order.getBookingOrderId());
		if (orderToBeUpdated.isPresent()) {
			orderRepository.save(order);
		}
		return orderToBeUpdated.orElseThrow(
				() -> new OrderIdNotFoundException("Order with id: " + order.getBookingOrderId() + " is not found"));
	}

	@Override
public OrderTable deleteOrder(int bookingId){
		
		Optional<OrderTable> orderOptional = orderRepository.findById(bookingId);
		
		if(orderOptional.isPresent()) {
			OrderTable here = orderOptional.get();
			orderRepository.delete(here);
			return here;
		}
		return orderOptional.orElseThrow(() -> new OrderIdNotFoundException("Order Not Found"));
	}

	@Override
	public OrderTable viewOrder(int bookingId) throws OrderIdNotFoundException{
		Optional<OrderTable> orderOptional = orderRepository.findById(bookingId);
		return orderOptional
				.orElseThrow(() -> new OrderIdNotFoundException("Order with id: " + bookingId + " is not found"));
	}

	@Override
	public List<OrderTable> viewAllOrders() {
		return orderRepository.findAll();
	}
}