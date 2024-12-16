package com.plantnursery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plantnursery.entity.Admin;
import com.plantnursery.entity.Plant;
import com.plantnursery.exceptions.UserNotFoundException;
import com.plantnursery.repository.IAdminRepository;

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminRepository iadminrepository;

	@Override
	public Admin validateAdmin(String adminId) throws UserNotFoundException {
		Admin admin_info = iadminrepository.findByAdminId(adminId);
		if (admin_info == null)
			throw new UserNotFoundException("User Not Found");
		return admin_info;
	}
	
	@Override
	public Admin addAdmin(Admin admin) {
		Admin admin_info = iadminrepository.save(admin);
		return admin_info;
	}
	
	@Override
	public Admin removeAdmin(Admin admin) {
		iadminrepository.delete(admin);
		return admin;
	}
	
	@Override
	public List<Admin> getAllUsers() {
		return iadminrepository.findAll();
	}
}
