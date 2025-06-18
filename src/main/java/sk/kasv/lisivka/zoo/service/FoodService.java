package sk.kasv.lisivka.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.dao.FoodDAO;
import sk.kasv.lisivka.zoo.entity.Food;

import java.util.List;

@Service
public class FoodService {

    private final FoodDAO foodDAO;

    @Autowired
    public FoodService(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    public List<Food> getAllFoods() {
        return foodDAO.findAll();
    }

    public Food getFoodById(Long id) {
        return foodDAO.findById(id);
    }

    public Food createFood(Food food) {
        return foodDAO.save(food);
    }

    public Food updateFood(Long id, Food food) {
        Food existing = foodDAO.findById(id);
        if (existing != null) {
            existing.setName(food.getName());
            existing.setType(food.getType());
            existing.setStock(food.getStock());
            return foodDAO.save(existing);
        }
        return null;
    }

    public void deleteFood(Long id) {
        Food existing = foodDAO.findById(id);
        if (existing != null) {
            foodDAO.delete(existing);
        }
    }
}
