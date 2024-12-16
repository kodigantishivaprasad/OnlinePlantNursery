package com.plantnursery.service;

import java.util.List;

import com.plantnursery.entity.Planter;

public interface IPlanterService {
	public Planter addPlanter(Planter planter);
	public Planter updatePlanter(Planter planter);
	public Planter deletePlanter(int planterId);
	public Planter getPlanter(int planterId);
	public List<Planter> viewAllPlanters();
	public List<Planter> viewAllPlanters(double minCost,double maxCost);

}
