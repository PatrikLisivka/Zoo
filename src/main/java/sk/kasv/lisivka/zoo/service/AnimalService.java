package sk.kasv.lisivka.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.dao.AnimalDAO;
import sk.kasv.lisivka.zoo.entity.Animal;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalDAO animalDAO;

    @Autowired
    public AnimalService(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }

    public List<Animal> getAllAnimals() {
        return animalDAO.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalDAO.findById(id);
    }

    public Animal createAnimal(Animal animal) {
        return animalDAO.save(animal);
    }

    public Animal updateAnimal(Long id, Animal animal) {
        Animal existingAnimal = animalDAO.findById(id);
        if (existingAnimal != null) {
            existingAnimal.setName(animal.getName());
            existingAnimal.setSpecies(animal.getSpecies());
            return animalDAO.save(existingAnimal);
        }
        return null;
    }

    public void deleteAnimal(Long id) {
        Animal existingAnimal = animalDAO.findById(id);
        if (existingAnimal != null) {
            animalDAO.delete(existingAnimal);
        }
    }
}
