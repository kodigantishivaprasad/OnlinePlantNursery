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

import com.plantnursery.entity.Plant;
import com.plantnursery.exceptions.PlantIdNotFoundException;
import com.plantnursery.service.IPlantService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/plantsModule")
public class IPlantController {
	
	@Autowired
	private IPlantService plantService;

	@PostMapping("/addPlant")
	public ResponseEntity<Plant> addNewPlant(@RequestBody Plant plant) {
		System.out.println("Add Plant...");
		plantService.addNewPlant(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
	}
// ========================================================================================================================================	

	@PutMapping({"/UpdatePlant/{id}"})
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant, @PathVariable int id) {
		// logger.trace("updating the whole plant having id "+ id);  
		plantService.updatePlant(plant, id);
		return new ResponseEntity<Plant>(plant, HttpStatus.ACCEPTED);
	}
// ========================================================================================================================================	

	
	@DeleteMapping("/deletePlant/{id}")
	public ResponseEntity<Plant> deletePlant(@PathVariable int id) throws PlantIdNotFoundException{
		//logger.trace("deleting the whole plant");	
		return new ResponseEntity<Plant>(plantService.deletePlant(id), HttpStatus.OK);
	}

// ========================================================================================================================================	

	@GetMapping("/getAllPlants")
	public ResponseEntity<List<Plant>> viewAllPlants() {
		//logger.trace("fetching all the plants");
		return new ResponseEntity<List<Plant>>(plantService.getAllPlants(), HttpStatus.OK);
	}

// ========================================================================================================================================	
	
	@GetMapping("/getPlant/{id}")
	public ResponseEntity<Plant> viewPlant(@PathVariable Integer id) {
		//logger.trace("fetching the plant with id "+ id);
		return new ResponseEntity<Plant>(plantService.getPlant(id), HttpStatus.OK);
	}

	

	
}
