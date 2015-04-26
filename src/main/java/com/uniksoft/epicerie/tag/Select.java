package com.uniksoft.epicerie.tag;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import com.uniksoft.epicerie.domain.Color;

public class Select implements Tag {

	private List<Color> colorList = null;
	private Set<Color> greetingColors = null;
	private PageContext pc = null;
	private Tag parent = null;
	
	@Override
	public int doEndTag() throws JspException {
		try {
			pc.getOut().print(buildSelect());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private String buildSelect() {
		StringBuilder sb = new StringBuilder();
		sb.append("<select name=\"colors\" multiple=\"multiple\">");
		for (Color color : colorList) {
			for (Color color2 : greetingColors) {
				if (color.equals(color2))
					sb.append("<option value=" + color.getId() + ">" + color.getColorName() + "</option>");
				else
					sb.append("<option value=" + color.getId() + " selected=>" + color.getColorName() + "</option>");
			}
		}
		sb.append("<select/>");
		return sb.toString();
	}
	
	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() {
		System.out.println("*** release");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pc = pageContext;
	}

	@Override
	public void setParent(Tag parent) {
		this.parent = parent;
	}

	public List<Color> getColorList() {
		return colorList;
	}

	public void setColorList(List<Color> colorList) {
		this.colorList = colorList;
	}

	public Set<Color> getGreetingColors() {
		return greetingColors;
	}

	public void setGreetingColors(List<Color> greetingColors) {
		this.greetingColors = (Set<Color>) greetingColors;
	}

}
