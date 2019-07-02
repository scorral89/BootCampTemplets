package com.st.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.food.model.Food;
import com.st.food.repository.FoodRepo;

@Service
public class FoodService 
{

	@Autowired
	private FoodRepo foodRepo;
	
	public List<Food> getAllFood()
	{
		return foodRepo.findAll();
	}
	public Food getFoodById(Long id)
	{
		return foodRepo.findFoodById(id);
	}
}
