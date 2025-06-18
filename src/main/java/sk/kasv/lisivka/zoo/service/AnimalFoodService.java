package sk.kasv.lisivka.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.dao.AnimalFoodDAO;
import sk.kasv.lisivka.zoo.entity.AnimalFood;

import java.util.List;

@Service
public class AnimalFoodService {

    private final AnimalFoodDAO animalFoodDAO;

    @Autowired
    public AnimalFoodService(AnimalFoodDAO animalFoodDAO) {
        this.animalFoodDAO = animalFoodDAO;
    }

    public List<AnimalFood> getAllAnimalFoods() {
        return animalFoodDAO.findAll();
    }

    public AnimalFood getAnimalFoodById(Long id) {
        return animalFoodDAO.findById(id);
    }

    public AnimalFood createAnimalFood(AnimalFood animalFood) {
        return animalFoodDAO.save(animalFood);
    }

    public AnimalFood updateAnimalFood(Long id, AnimalFood animalFood) {
        AnimalFood existing = animalFoodDAO.findById(id);
        if (existing != null) {
            existing.setAnimal(animalFood.getAnimal());
            existing.setFood(animalFood.getFood());
            existing.setAmountPerDay(animalFood.getAmountPerDay());
            return animalFoodDAO.save(existing);
        }
        return null;
    }

    public void deleteAnimalFood(Long id) {
        AnimalFood existing = animalFoodDAO.findById(id);
        if (existing != null) {
            animalFoodDAO.delete(existing);
        }
    }
}
