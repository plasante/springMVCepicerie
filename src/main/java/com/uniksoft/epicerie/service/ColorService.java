package com.uniksoft.epicerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.epicerie.dao.ColorDao;
import com.uniksoft.epicerie.domain.Color;

@Service
@Transactional
public class ColorService {

	@Autowired 
	private ColorDao colorDao;
	
	public void addColor(Color color) {
		colorDao.addColor(color);
	}
	
	public List<Color> listColors() {
		return colorDao.listColors();
	}

	public Color getColorById(int i) {
		return colorDao.getColorById(i);
	}
}
