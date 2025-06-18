package sk.kasv.lisivka.zoo.dao;

import sk.kasv.lisivka.zoo.entity.AnimalFood;

import java.util.List;

public interface AnimalFoodDAO {
    List<AnimalFood> findAll();
    AnimalFood findById(Long id);
    AnimalFood save(AnimalFood animalFood);
    void delete(AnimalFood animalFood);
}
