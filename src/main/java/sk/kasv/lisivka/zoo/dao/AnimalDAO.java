package sk.kasv.lisivka.zoo.dao;

import sk.kasv.lisivka.zoo.entity.Animal;

import java.util.List;

public interface AnimalDAO {
    List<Animal> findAll();

    Animal findById(Long id);

    Animal save(Animal animal); // pre insert a update

    void delete(Animal animal);
}
