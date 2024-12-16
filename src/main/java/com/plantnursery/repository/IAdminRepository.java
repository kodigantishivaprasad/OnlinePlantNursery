package com.plantnursery.repository;


import org.springframework.stereotype.Repository;

import com.plantnursery.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByAdminId(String adminId);
}
