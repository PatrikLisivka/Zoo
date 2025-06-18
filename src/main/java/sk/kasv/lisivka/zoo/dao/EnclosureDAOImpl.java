package sk.kasv.lisivka.zoo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.kasv.lisivka.zoo.entity.Enclosure;

import java.util.List;

@Repository
public class EnclosureDAOImpl implements EnclosureDAO {

    private EntityManager entityManager;

    @Autowired
    public EnclosureDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Enclosure> findAll() {
        TypedQuery<Enclosure> query = entityManager.createQuery("from Enclosure", Enclosure.class);
        return query.getResultList();
    }

    @Override
    public Enclosure findById(Long id) {
        return entityManager.find(Enclosure.class, id);
    }

    @Override
    @Transactional
    public Enclosure save(Enclosure enclosure) {
        if (enclosure.getId() == null) {
            entityManager.persist(enclosure);
            return enclosure;
        } else {
            return entityManager.merge(enclosure);
        }
    }

    @Override
    @Transactional
    public void delete(Enclosure enclosure) {
        if (!entityManager.contains(enclosure)) {
            enclosure = entityManager.merge(enclosure);
        }
        entityManager.remove(enclosure);
    }
}
