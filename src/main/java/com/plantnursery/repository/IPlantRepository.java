package com.plantnursery.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantnursery.entity.Plant;


	@Repository
	public interface IPlantRepository extends JpaRepository<Plant, Integer>{
		
		Optional<Plant> findByname(String name);
		
		List<Plant> findByTypeOfPlant(String typeOfPlant);


}
