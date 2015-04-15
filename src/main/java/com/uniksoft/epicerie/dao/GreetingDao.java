package com.uniksoft.epicerie.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uniksoft.epicerie.domain.Greeting;

@Repository
public interface GreetingDao {

	public void updateGreeting(Greeting greeting);
	public void addGreeting(Greeting greeting);
	public Greeting getGreetingById(Integer greetingId);
	public void deleteGreeting(Greeting greeting);
	public List<Greeting> getAllGreetings();
}
