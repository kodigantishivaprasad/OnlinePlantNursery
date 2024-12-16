package com.plantnursery.service;

import java.util.List;

import com.plantnursery.entity.Plant;


public interface IPlantService {
	
	Plant addNewPlant(Plant plant);
	
	Plant updatePlant(Plant plant, int id);
	
	Plant deletePlant(int plantId);
	
	Plant getPlant(int plantId);
	
	
	
	List<Plant> getAllPlants();
	
	

}
