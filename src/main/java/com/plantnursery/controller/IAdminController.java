package com.plantnursery.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plantnursery.entity.Admin;
import com.plantnursery.service.IAdminService;

@RequestMapping(value={"/loginController"})
@RestController
public class IAdminController {
	private static final HttpStatus HttpStatus = null;

	@Autowired
	HttpSession session;

	@Autowired
	private IAdminService loginservice;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<Admin> addUser(@RequestBody Admin admin){
		if(admin.getAdminId() == 0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		Admin userImpl=loginservice.addAdmin(admin);
		return new ResponseEntity(userImpl,HttpStatus.OK);
	}
	
//*********************************************************************************************************************	

	
	@DeleteMapping("/removeUser")
	public ResponseEntity<Admin> removeUser(@RequestBody Admin admin){
		if(admin.getAdminId()==0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		Admin userImpl=loginservice.removeAdmin(admin);
		return new ResponseEntity(userImpl,HttpStatus.OK);
		
	}

//*********************************************************************************************************************	
		
	@GetMapping("/viewAllUsers")
	public ResponseEntity<List<Admin>> viewAllUsers() {
		//logger.trace("fetching all the plants");
		return new ResponseEntity<List<Admin>>(loginservice.getAllUsers(), HttpStatus.OK);
	}
//*********************************************************************************************************************	
	

	@GetMapping("/signOut")
	public ResponseEntity<Admin> signOut(){
		session.invalidate();
		return new ResponseEntity("LoggedOut",HttpStatus.OK);
	}
}
