package com.plantnursery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantnursery.entity.OrderTable;
import com.plantnursery.entity.Plant;
import com.plantnursery.exceptions.OrderIdNotFoundException;
import com.plantnursery.exceptions.PlantIdNotFoundException;
import com.plantnursery.service.IOrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/Orders")
public class OrderController{
	
	@Autowired
	private IOrderService orderService;

	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderTable> addOrder(@RequestBody OrderTable order) {
		return new ResponseEntity<OrderTable>(orderService.addOrder(order), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteOrder/id/{bookingId}")
	public ResponseEntity<OrderTable> deleteOrder(@PathVariable int bookingId) throws OrderIdNotFoundException{
		//logger.trace("deleting the whole plant");	
		return new ResponseEntity<OrderTable>(orderService.deleteOrder(bookingId), HttpStatus.OK);
	}
	
	@GetMapping("/viewOrder/id/{bookingId}")
	public ResponseEntity<OrderTable> viewOrder(@PathVariable int bookingId) {
		return new ResponseEntity<OrderTable>(orderService.viewOrder(bookingId), HttpStatus.OK);
	}
	
//*********************************************************************************************************************	
	
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<List<OrderTable>> viewAllOrders(){
		return new ResponseEntity<List<OrderTable>>(orderService.viewAllOrders(), HttpStatus.OK);
	}	
	
//*********************************************************************************************************************	

	
	@PutMapping({"/updateOrder/id/{bookingId}"})
	public ResponseEntity<OrderTable> updateOrder(@RequestBody OrderTable order, @PathVariable int bookingId) {
		// logger.trace("updating the whole plant having id "+ id);  
		orderService.updateOrder(order, bookingId);
		return new ResponseEntity<OrderTable>(order, HttpStatus.ACCEPTED);
	}
	
}