package com.example.foodapp.service;

import com.example.foodapp.entity.Food;
import com.example.foodapp.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food updateFood(Long id, Food foodDetails) {
        Food food = foodRepository.findById(id).orElseThrow();
        food.setFoodName(foodDetails.getFoodName());
        food.setDescription(foodDetails.getDescription());
        food.setPrice(foodDetails.getPrice());
        return foodRepository.save(food);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
