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

import com.plantnursery.entity.Planter;
import com.plantnursery.service.IPlanterService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/planter")
public class PlanterController {

	@Autowired
	private IPlanterService planterService;

	@PostMapping("/addPlanter")
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter) {
		planter = planterService.addPlanter(planter);
		return new ResponseEntity<Planter>(planter, HttpStatus.CREATED);
	}

 
	@GetMapping("/getAllPlanters")
	public ResponseEntity<List<Planter>> getAllPlanters() {
		List<Planter> planters = planterService.viewAllPlanters();
		return new ResponseEntity<List<Planter>>(planters, HttpStatus.OK);
	}
	

	@GetMapping("/getPlanter/id/{id}")
	public ResponseEntity<Planter> getPlanterById(@PathVariable int id) {
		Planter planter = planterService.getPlanter(id);
		return new ResponseEntity<Planter>(planter, HttpStatus.OK);
	}


	@PutMapping("/updatePlanter")
	public ResponseEntity<Planter> update(@RequestBody Planter planter) {
		Planter newPlanter = planterService.updatePlanter(planter);
		return new ResponseEntity<Planter>(newPlanter, HttpStatus.OK);
	}


	@DeleteMapping("/deletePlanter/id/{planterId}")
	public ResponseEntity<Planter> deletePlanter(@PathVariable int planterId) {
		// logger.trace("deleting the whole plant");
		return new ResponseEntity<Planter>(planterService.deletePlanter(planterId), HttpStatus.OK);
	}

	@GetMapping("/planters/{min}/{max}")
	public ResponseEntity<List<Planter>> getAllPlantersInRange(@PathVariable double min, @PathVariable double max) {
		List<Planter> planters = planterService.viewAllPlanters(min, max);
		if (planters.size() != 0)
			return new ResponseEntity<List<Planter>>(planters, HttpStatus.OK);
		return new ResponseEntity<List<Planter>>(planters, HttpStatus.NOT_FOUND);
	}

}
