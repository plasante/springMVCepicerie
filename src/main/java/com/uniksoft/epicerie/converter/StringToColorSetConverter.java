package com.uniksoft.epicerie.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.uniksoft.epicerie.domain.Color;
import com.uniksoft.epicerie.service.ColorService;

public class StringToColorSetConverter implements Converter<String, Set<Color>> {

	@Autowired
	private ColorService colorService;
	
	@Override
	public Set<Color> convert(String colorID) {
		Color color = null;
		Set<Color> set = null;
		try {
			color = (Color) colorService.getColorById( Integer.parseInt(colorID) );
			set = new HashSet<Color>();
			set.add(color);
		} catch (NumberFormatException e) {
			
		}
		return set;
	}

}
