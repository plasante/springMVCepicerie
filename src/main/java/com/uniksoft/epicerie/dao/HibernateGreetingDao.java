package com.uniksoft.epicerie.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniksoft.epicerie.domain.Greeting;

@Repository
public class HibernateGreetingDao implements GreetingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void updateGreeting(Greeting greeting) {
		sessionFactory.getCurrentSession().update(greeting);
	}
	
	@SuppressWarnings("unchecked")
	public List<Greeting> getAllGreetings() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("select g from Greeting g order by id desc");
		List<Greeting> greetings = q.list();
		return greetings;
	}
	
	public void addGreeting(Greeting greeting) {
		Session session = sessionFactory.getCurrentSession();
		session.save(greeting);
	}

	@SuppressWarnings("unchecked")
	public Greeting getGreetingById(Integer greetingId) {
		Session session = sessionFactory.getCurrentSession();
		List<Greeting> greetings = session.createQuery("from Greeting g where g.id = :greetingId").setParameter("greetingId", greetingId).list();
		return greetings.size() > 0 ? (Greeting) greetings.get(0) : null;
	}

	public void deleteGreeting(Greeting greeting) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(greeting);
	}
}
