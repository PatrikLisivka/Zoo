package sk.kasv.lisivka.zoo.service;

import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.entity.Animal;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public Animal createAnimal(Animal animal) {
        animals.add(animal);
        return animal;
    }

    public Animal updateAnimal(Long id, Animal animal) {
        for (Animal existingAnimal : animals) {
            if (existingAnimal.getId().equals(id)) {
                existingAnimal.setName(animal.getName());
                existingAnimal.setSpecies(animal.getSpecies());
                existingAnimal.setAge(animal.getAge());
                existingAnimal.setHealthStatus(animal.getHealthStatus());
                return existingAnimal;
            }
        }
        return null;
    }
}