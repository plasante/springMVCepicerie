package com.uniksoft.epicerie.web.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.uniksoft.epicerie.domain.Role;
import com.uniksoft.epicerie.domain.User;
import com.uniksoft.epicerie.service.GenericEntityService;
import com.uniksoft.epicerie.service.RoleService;
import com.uniksoft.epicerie.service.UserService;

public class UserControllerTest {

	UserController userController;
	UserService fakeUserService;
	RoleService fakeRoleService;
	User user;
	Role role;
	List<User> fakeUserList;
	List<Role> fakeRoleList;
	Map<String, Object> model = new HashMap<String, Object>();
	
	@Before
	public void setUp() {
		fakeUserService = mock(UserService.class);
		fakeRoleService = mock(RoleService.class);
		
		fakeUserList = new ArrayList<User>();
		user = new User();
		user.setUsername("plasante");
		user.setPassword("123456");
		fakeUserList.add(user);
		
		fakeRoleList = new ArrayList<Role>();
		role = new Role("admin");
		fakeRoleList.add(role);
		
		userController = new UserController(fakeUserService, fakeRoleService);
		when(fakeRoleService.getAllEntities()).thenReturn(fakeRoleList);
	}
	
	@Test
	public void sanityCheck() {
		assertTrue("This should be true",true);
	}
	
	@Test
	public void populateRoleList() {
		//given
		role.setName("Pierre");
		//when
		List<Role> roles = userController.populateRoleList();
		//then
		assertEquals("Pierre", roles.get(0).getName());
	}
}
