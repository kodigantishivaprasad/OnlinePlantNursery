package com.plantnursery.service;

import java.util.List;
import java.util.Map;

import com.plantnursery.entity.Plant;
import com.plantnursery.entity.Seed;


public interface ISeedService {

	Seed addSeed(Seed seed);
	Seed updateSeed(Seed seed, int id);
	Seed deleteSeedById(int id);
	Seed getSeed(int id);
	List<Seed> getAllSeeds();
	
	
}
