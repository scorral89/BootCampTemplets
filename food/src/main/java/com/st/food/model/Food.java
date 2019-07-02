package com.st.food.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;
	private String color;
	
	public Food() {};
	
	public Food(String name, String color)
	{
		this.name = name;
		this.color = color;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	public Long getId() {
		return id;
	}
	
}
