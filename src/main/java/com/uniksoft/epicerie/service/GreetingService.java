package com.uniksoft.epicerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.epicerie.dao.GreetingDao;
import com.uniksoft.epicerie.domain.Greeting;

@Service
@Transactional
public class GreetingService {

	@Autowired
	private GreetingDao greetingDao;
	
	public void updateGreeting(Greeting greeting) {
		greetingDao.updateGreeting(greeting);
	}
	
	public List<Greeting> getAllGreetings() {
		return greetingDao.getAllGreetings();
	}
	
	public void addGreeting(Greeting greeting) {
		greetingDao.addGreeting(greeting);
	}
	
	public Greeting getGreetingById(Integer greetingId) {
		return greetingDao.getGreetingById(greetingId);
	}
	
	public void deleteGreeting(Greeting greeting) {
		greetingDao.deleteGreeting(greeting);
	}
}
