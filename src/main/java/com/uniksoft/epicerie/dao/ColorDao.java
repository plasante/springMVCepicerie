package com.uniksoft.epicerie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniksoft.epicerie.domain.Color;

@Repository
public class ColorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addColor(Color color) {
		sessionFactory.getCurrentSession().save(color);
	}
	
	@SuppressWarnings("unchecked")
	public List<Color> listColors() {
		return sessionFactory.getCurrentSession().createQuery("from Color").list();
	}

	@SuppressWarnings("unchecked")
	public Color getColorById(int colorId) {
		Session session = sessionFactory.getCurrentSession();
		List<Color> colors = session.createQuery("from Color c where c.id = :colorId").setParameter("colorId", colorId).list();
		return colors.size() > 0 ? (Color)colors.get(0) : null;
	}
}
