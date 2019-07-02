package com.st.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.food.model.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {
	public List<Food> findAll();
	public Food findFoodById(Long id);
}
