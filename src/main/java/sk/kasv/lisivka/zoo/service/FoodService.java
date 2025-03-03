package sk.kasv.lisivka.zoo.service;

import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.entity.Food;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    private List<Food> foods = new ArrayList<>();

    public List<Food> getAllFoods() {
        return foods;
    }

    public Food createFood(Food food) {
        foods.add(food);
        return food;
    }

    public Food updateFood(Long id, Food food) {
        for (Food existingFood : foods) {
            if (existingFood.getId().equals(id)) {
                existingFood.setName(food.getName());
                existingFood.setType(food.getType());
                existingFood.setStock(food.getStock());
                return existingFood;
            }
        }
        return null;
    }
}