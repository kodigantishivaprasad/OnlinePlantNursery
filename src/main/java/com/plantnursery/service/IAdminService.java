package com.plantnursery.service;

import java.util.List;

import com.plantnursery.entity.Admin;
import com.plantnursery.exceptions.UserNotFoundException;

public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public Admin removeAdmin(Admin admin);
	public Admin validateAdmin(String adminId)throws UserNotFoundException;
	public List<Admin> getAllUsers();
}
