package com.uniksoft.epicerie.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "greetings")
public class Greeting {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "Please enter a greeting text.")
	@Column(name = "GREETING_TEXT")
	private String greetingText;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "GREETING_DATE")
	private Date greetingDate;

	public Greeting() {}
	
	public Greeting(String greetingText) {
		this.greetingText = greetingText;
	}
	
	/*
	 * This is a unidirectional association. Color has no
	 * knowledge of the existence of Greeting.
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="GREETINGS_COLORS",
	joinColumns={@JoinColumn(name="GREETING_ID")},
	inverseJoinColumns={@JoinColumn(name="COLOR_ID")})
	private Set<Color> colors = new HashSet<Color>(0);
	
	public Set<Color> getColors() {
		return colors;
	}

	public void setColors(Set<Color> colors) {
		this.colors = colors;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getGreetingText() {
		return greetingText;
	}

	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}
	
	public Date getGreetingDate() {
		return greetingDate;
	}
	
	public void setGreetingDate(Date greetingDate) {
		this.greetingDate = greetingDate;
	}
}
