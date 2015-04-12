package com.uniksoft.epicerie.web.controller;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import com.uniksoft.epicerie.domain.Color;
import com.uniksoft.epicerie.domain.Greeting;
import com.uniksoft.epicerie.service.ColorService;
import com.uniksoft.epicerie.service.GreetingService;

import junit.framework.TestCase;

public class GreetingControllerBetterTest extends TestCase {

	Greeting greeting = new Greeting();
	Color color = new Color();
	Map<String, Object> model = new HashMap<String, Object>();
	GreetingService fakeGreetingService;
	ColorService fakeColorService;
	List<Greeting>  fakeGreetingList;
	List<Color> fakeColorList;
	GreetingController greetingController;
	
	@Before
	protected void setUp() {
		//mock the GreetingService
		fakeGreetingService = mock(GreetingService.class);
		fakeGreetingList = new ArrayList<Greeting>();
		//mock the ColorService
		fakeColorService = mock(ColorService.class);
		fakeColorList = new ArrayList<Color>();
		//inject the GreetingController with a fake GreetingService
		greetingController = new GreetingController(fakeGreetingService, fakeColorService);
		when(fakeGreetingService.getAllGreetings()).thenReturn(fakeGreetingList);
		when(fakeGreetingService.getGreetingById(new Integer("1"))).thenReturn(greeting);
		when(fakeColorService.listColors()).thenReturn(fakeColorList);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testShowAllGreetingsGetVerb() {
		//GIVEN
		greeting.setGreetingText("Hello Pierre");
		fakeGreetingList.add(greeting);
		//WHEN
		String result = greetingController.showAllGreetings(model);
		//THEN
		List<Greeting> greetingListResult = (ArrayList<Greeting>) (model.get("greetingList"));
		assertEquals("Hello Pierre", greetingListResult.get(0).getGreetingText());
		assertEquals("FFFFFF", model.get("colorcode"));
		assertEquals("greetings", result);
	}
	
	@Test
	public void testPopulateColorList() {
		//GIVEN
		color.setColorCode("#ABCDEF");
		color.setColorName("colorName");
		fakeColorList.add(color);
		//WHEN
		List<Color> colors = greetingController.populateColorList();
		//THEN
		assertEquals("#ABCDEF", colors.get(0).getColorCode());
		assertEquals("colorName", colors.get(0).getColorName());
	}
	
	@Test
	public void testEditGreetingGetVerb() {
		//GIVEN
		greeting.setId(1);
		//WHEN
		String result = greetingController.editGreeting(new Integer("1"), model);
		//THEN
		assertNotNull(model.get("greeting"));
		assertEquals(new Integer("1"), ((Greeting)(model.get("greeting"))).getId());
		assertEquals("editgreeting", result);
	}
}
