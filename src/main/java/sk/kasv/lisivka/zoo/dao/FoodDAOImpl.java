package sk.kasv.lisivka.zoo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.kasv.lisivka.zoo.entity.Food;

import java.util.List;

@Repository
public class FoodDAOImpl implements FoodDAO {

    private EntityManager entityManager;

    @Autowired
    public FoodDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Food> findAll() {
        TypedQuery<Food> query = entityManager.createQuery("from Food", Food.class);
        return query.getResultList();
    }

    @Override
    public Food findById(Long id) {
        return entityManager.find(Food.class, id);
    }

    @Override
    @Transactional
    public Food save(Food food) {
        if (food.getId() == null) {
            entityManager.persist(food);
            return food;
        } else {
            return entityManager.merge(food);
        }
    }

    @Override
    @Transactional
    public void delete(Food food) {
        if (!entityManager.contains(food)) {
            food = entityManager.merge(food);
        }
        entityManager.remove(food);
    }
}
