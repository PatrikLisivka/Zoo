package sk.kasv.lisivka.zoo.dao;

import sk.kasv.lisivka.zoo.entity.Food;

import java.util.List;

public interface FoodDAO {
    List<Food> findAll();
    Food findById(Long id);
    Food save(Food food);
    void delete(Food food);
}
