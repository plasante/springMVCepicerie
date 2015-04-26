package com.uniksoft.epicerie.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniksoft.epicerie.domain.Color;
import com.uniksoft.epicerie.domain.Greeting;
import com.uniksoft.epicerie.domain.Role;
import com.uniksoft.epicerie.domain.User;
import com.uniksoft.epicerie.service.ColorService;
import com.uniksoft.epicerie.service.GenericEntityService;
import com.uniksoft.epicerie.service.GreetingService;

@Component
public class Seed {

	@Autowired
	private ColorService colorService;
	
	@Autowired
	private GreetingService greetingService;
	
	@Autowired
	private GenericEntityService entityService;
	
	@PostConstruct
	public void init() {
		System.out.println("Seeding the database");
		populateColors();
		populateGreetings();
		populateUsersRoles();
	}
	
	private void populateColors() {
		Color indianRed = new Color("Indian Red", "#F75D59");
		colorService.addColor(indianRed);
		colorService.addColor(new Color("Red", "#FF0000"));
		colorService.addColor(new Color("Salmon", "#F9966B"));
		colorService.addColor(new Color("Lemon Chiffon", "#FFF8C6"));
		colorService.addColor(new Color("Olive Green", "#BCE954"));
		colorService.addColor(new Color("Steel Blue", "#C6DEFF"));
		colorService.addColor(new Color("Medium Purple", "#9E7BFF"));
	}
	
	private void populateGreetings() {
		Greeting greeting1 = new Greeting("Greeting 1");
		Color color = colorService.getColorById(1);
		Set<Color> set = new HashSet<Color>();
		set.add(color);
		greeting1.setColors(set);
		greetingService.addGreeting(greeting1);
		color = colorService.getColorById(2);
		set.add(color);
		greeting1.setColors(set);
		greetingService.updateGreeting(greeting1);
		greetingService.addGreeting(new Greeting("Greeting 2"));
		greetingService.addGreeting(new Greeting("Greeting 3"));
	}
	
	private void populateUsersRoles() {
		User user1 = new User("firstName","lastName","username","email","password",new Date(),"ssn");
		Role role1 = new Role("user");
		entityService.addEntity(role1);
		List<Role> roles = new ArrayList<Role>();
		roles.add(role1);
		user1.setRoles(roles);
		entityService.addEntity(user1);
		
		User user2 = new User("Pierre","Lasante","plasante","plasante@email.com","123456",new Date(),"ssn");
		entityService.addEntity(user2);
		User user3 = new User("Carole","Spenard","cspenard","cspenard@email.com","123456",new Date(),"ssn");
		entityService.addEntity(user3);
		User user4 = new User("Judith","Spenard","jspenard","jspenard@email.com","123456",new Date(),"ssn");
		entityService.addEntity(user4);
		
		Role role2 = new Role("admin");
		entityService.addEntity(role2);
		roles.add(role2);
		user2.setRoles(roles);
		entityService.updateEntity(user2);
	}
}
