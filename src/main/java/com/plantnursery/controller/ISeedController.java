package com.plantnursery.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantnursery.entity.Plant;
import com.plantnursery.entity.Seed;
import com.plantnursery.service.ISeedService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/seeds")
public class ISeedController {
	
	@Autowired
	private ISeedService seedService;

	
	@PostMapping("/addSeeds")
	public ResponseEntity<Seed> addSeed( @RequestBody Seed seed){
		seedService.addSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateseeds/{id}")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed, @PathVariable int id) {
		// logger.trace("updating the whole plant having id "+ id);  
		seedService.updateSeed(seed, id);
		return new ResponseEntity<Seed>(seed, HttpStatus.ACCEPTED);
	}

	
	@DeleteMapping("/deleteseeds/{id}")
	public ResponseEntity<Seed> deleteSeedById(@PathVariable int id){
		return new ResponseEntity<Seed>(seedService.deleteSeedById(id),HttpStatus.OK);
	}
	

	@GetMapping("/getseeds/{id}")
	public ResponseEntity<Seed> getSeed(@PathVariable int id){
		return new ResponseEntity<Seed>(seedService.getSeed(id),HttpStatus.OK);	
	}
	
//	@GetMapping("/seeds/name/{name}")
//	public ResponseEntity<Seed> getSeed(@PathVariable String name) {
//		return new ResponseEntity<Seed>(seedService.getSeed(name),HttpStatus.ACCEPTED);	
//	}
	
	
	@GetMapping("/getSeeds")
	public ResponseEntity<List<Seed>> viewAllSeeds() {
		//logger.trace("fetching all the plants");
		return new ResponseEntity<List<Seed>>(seedService.getAllSeeds(), HttpStatus.OK);
	}

	
//	@GetMapping("/seeds/typeOfSeed/{typeOfSeed}")
//	public ResponseEntity<List<Seed>> getSeeds(@PathVariable String typeOfSeed){
//		List<Seed> seedList = seedService.getSeeds(typeOfSeed);
//		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
//	}
	

}
