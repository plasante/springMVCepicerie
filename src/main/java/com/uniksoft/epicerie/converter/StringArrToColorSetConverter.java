package com.uniksoft.epicerie.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.uniksoft.epicerie.domain.Color;
import com.uniksoft.epicerie.service.ColorService;

@Component
public class StringArrToColorSetConverter implements Converter<String[], Set<Color>> {

	@Autowired
	private ColorService colorService;
	
	@Override
	public Set<Color> convert(String[] colorIdStr) {
		Set<Color> set = new HashSet<Color>();
		Color color = null;
		
		for (String id : colorIdStr) {
			color = (Color) colorService.getColorById( Integer.parseInt(id) );
			set.add(color);
		}
		
		return set;
	}

}
