package com.uniksoft.epicerie.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniksoft.epicerie.domain.Color;
import com.uniksoft.epicerie.domain.Greeting;
import com.uniksoft.epicerie.service.ColorService;
import com.uniksoft.epicerie.service.GreetingService;

@Controller
@RequestMapping("/home")
public class GreetingController {

	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	
	@Autowired
	private GreetingService greetingService;
	
	@Autowired
	private ColorService colorService;
	
	// This empty constructor is needed otherwise Spring will complaint.
	public GreetingController() {}
	
	// This constructor is needed for mockito
	public GreetingController(GreetingService fakeGreetingService, ColorService fakeColorService) {
		this.greetingService = fakeGreetingService;
		this.colorService = fakeColorService;
	}

	@RequestMapping(value = "/editgreetings.html", method = RequestMethod.GET)
	public String editGreeting(@RequestParam("id") Integer id, Map<String, Object> model) {
		Greeting greeting = greetingService.getGreetingById(id);
		model.put("greeting", greeting);
		return "editgreeting";
	}
	
	@RequestMapping(value = "/updategreeting.html", method = RequestMethod.POST)
	public String updateGreeting(@ModelAttribute("greeting") @Valid Greeting greeting, 
			BindingResult result, Map<String, Object> model) {
		if (result.hasErrors()) {
			model.put("greeting", greeting);
			return "editgreeting";
		} else {
			greetingService.updateGreeting(greeting);
			model.put("id", greeting.getId());
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/savegreeting.html", method = RequestMethod.POST)
	public String saveGreeting(@ModelAttribute("greeting") @Valid Greeting greeting, 
			BindingResult result, Map<String, Object> model) {
		if (result.hasErrors()) {
			model.put("greeting", greeting);
			return "editgreeting";
		} else {
			greetingService.addGreeting(greeting);
			model.put("greetinglist", greetingService.getAllGreetings());
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/deletegreeting.html", method = RequestMethod.GET)
	public String deleteGreeting(@RequestParam("id") Integer id) {
		greetingService.deleteGreeting(greetingService.getGreetingById(id));
		return "redirect:/";
	}
	
	@RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
	public String showAllGreetings(@ModelAttribute("greeting") Greeting greeting,
					Map<String, Object> model) {
		
		logger.info("entering showAllGreetings");
		
		greeting.setGreetingDate(new Date());
		greetingService.addGreeting(greeting);
		
		model.put("greetingList", greetingService.getAllGreetings());
		
		return "greetings";
	}
	
	@RequestMapping(value = "/greetings.html", method = RequestMethod.GET)
	public String showAllGreetings(Map<String, Object> model) {
		
		logger.info("entering showAllGreetings");
		
		model.put("greetingList", greetingService.getAllGreetings());
		model.put("colorcode"   , "FFFFFF");
		
		return "greetings";
	}
	
	@ModelAttribute("colorlist")
	public List<Color> populateColorList() {
		return colorService.listColors();
	}
	
	@RequestMapping(value = "addgreeting.html", method = RequestMethod.GET)
	public String showAddGreetingPage(
			@ModelAttribute("greeting") Greeting greeting,
			Map<String, Object> model) {
		
		logger.info("entering showAddGreetingPage");
		model.put("greeting", new Greeting());
		return "addgreeting";
	}
}
