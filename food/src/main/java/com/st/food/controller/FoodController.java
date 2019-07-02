package com.st.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.food.model.Food;
import com.st.food.service.FoodService;

@Controller
public class FoodController 
{
	@Autowired
	FoodService foodService;
	
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/Foods")
	
	public String allFoods(Model model)
	{
		List<Food> food = foodService.getAllFood();
		 model.addAttribute("food", food);
		 return "foods";
	}
	
	@GetMapping("/food/{id}")
	
	public Food findById(@PathVariable Long id)
	{
		return foodService.getFoodById(id);
	}
	
	
}
