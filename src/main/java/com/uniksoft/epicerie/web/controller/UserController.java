package com.uniksoft.epicerie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.uniksoft.epicerie.domain.Role;
import com.uniksoft.epicerie.service.RoleService;
import com.uniksoft.epicerie.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public UserController() {}
	
	// This constructor is for testing with mockito
	public UserController(UserService fakeUserService, RoleService fakeRoleService) {
		this.userService = fakeUserService;
		this.roleService = fakeRoleService;
	}
	
	@ModelAttribute("rolelist")
	public List<Role> populateRoleList() {
		return roleService.getAllEntities();
	}
}
