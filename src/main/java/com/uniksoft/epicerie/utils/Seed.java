package com.uniksoft.epicerie.utils;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniksoft.epicerie.domain.Color;
import com.uniksoft.epicerie.domain.Greeting;
import com.uniksoft.epicerie.service.ColorService;
import com.uniksoft.epicerie.service.GreetingService;

@Component
public class Seed {

	@Autowired
	private ColorService colorService;
	
	@Autowired
	private GreetingService greetingService;
	
	@PostConstruct
	public void init() {
		System.out.println("Seeding the database");
		populateColors();
		populateGreetings();
	}
	
	private void populateColors() {
		System.out.println("Populating colors table");
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
		System.out.println("Populating greetings table");
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
}
