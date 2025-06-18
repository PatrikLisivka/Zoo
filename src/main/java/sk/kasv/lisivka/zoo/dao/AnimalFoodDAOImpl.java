package sk.kasv.lisivka.zoo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.kasv.lisivka.zoo.entity.AnimalFood;

import java.util.List;

@Repository
public class AnimalFoodDAOImpl implements AnimalFoodDAO {

    private final EntityManager entityManager;

    @Autowired
    public AnimalFoodDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<AnimalFood> findAll() {
        TypedQuery<AnimalFood> query = entityManager.createQuery("from AnimalFood", AnimalFood.class);
        return query.getResultList();
    }

    @Override
    public AnimalFood findById(Long id) {
        return entityManager.find(AnimalFood.class, id);
    }

    @Override
    @Transactional
    public AnimalFood save(AnimalFood animalFood) {
        if (animalFood.getId() == null) {
            entityManager.persist(animalFood);
            return animalFood;
        } else {
            return entityManager.merge(animalFood);
        }
    }

    @Override
    @Transactional
    public void delete(AnimalFood animalFood) {
        if (!entityManager.contains(animalFood)) {
            animalFood = entityManager.merge(animalFood);
        }
        entityManager.remove(animalFood);
    }
}
