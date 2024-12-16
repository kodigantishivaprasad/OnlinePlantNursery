package com.plantnursery.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plantnursery.entity.Planter;

@Repository
public interface IPlanterRepository extends JpaRepository<Planter, Integer> {

}
