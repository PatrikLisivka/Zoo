package sk.kasv.lisivka.zoo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.kasv.lisivka.zoo.entity.Animal;

import java.util.List;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

    private EntityManager entityManager;

    @Autowired
    public AnimalDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Animal> findAll() {
        TypedQuery<Animal> query = entityManager.createQuery("from Animal", Animal.class);
        return query.getResultList();
    }

    @Override
    public Animal findById(Long id) {
        return entityManager.find(Animal.class, id);
    }

    @Override
    @Transactional
    public Animal save(Animal animal) {
        if (animal.getId() == null) {
            entityManager.persist(animal);
            return animal;
        } else {
            return entityManager.merge(animal);
        }
    }

    @Override
    @Transactional
    public void delete(Animal animal) {
        if (!entityManager.contains(animal)) {
            animal = entityManager.merge(animal);
        }
        entityManager.remove(animal);
    }
}
