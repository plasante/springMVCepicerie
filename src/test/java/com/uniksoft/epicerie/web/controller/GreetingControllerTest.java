package com.uniksoft.epicerie.web.controller;

import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.uniksoft.epicerie.service.GreetingService;

import junit.framework.TestCase;

public class GreetingControllerTest extends TestCase {

	@Test
	public void testTheMethodShowAllGreetingShouldReturnAResult() {
		//GIVEN
		GreetingService fakeGreetingService = mock(GreetingService.class);
		GreetingController controller = new GreetingController(fakeGreetingService, null);
		Map<String, Object> model = new HashMap<String, Object>();
		//WHEN
		String result = controller.showAllGreetings(model);
		//THEN
		assertNotNull(result);
		assertEquals("greetings", result);
	}
}
