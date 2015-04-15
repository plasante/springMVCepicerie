package com.uniksoft.epicerie.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.epicerie.dao.HibernateGreetingDao;
import com.uniksoft.epicerie.domain.Greeting;

@Service
@Transactional
public class GreetingService {

	@Resource(name="greetingDao")
	private HibernateGreetingDao hibernateGreetingDao;
	
	public void updateGreeting(Greeting greeting) {
		hibernateGreetingDao.updateGreeting(greeting);
	}
	
	public List<Greeting> getAllGreetings() {
		return hibernateGreetingDao.getAllGreetings();
	}
	
	public void addGreeting(Greeting greeting) {
		hibernateGreetingDao.addGreeting(greeting);
	}
	
	public Greeting getGreetingById(Integer greetingId) {
		return hibernateGreetingDao.getGreetingById(greetingId);
	}
	
	public void deleteGreeting(Greeting greeting) {
		hibernateGreetingDao.deleteGreeting(greeting);
	}
}
