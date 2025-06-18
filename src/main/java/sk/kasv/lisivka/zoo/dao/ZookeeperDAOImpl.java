package sk.kasv.lisivka.zoo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.kasv.lisivka.zoo.entity.Zookeeper;

import java.util.List;

@Repository
public class ZookeeperDAOImpl implements ZookeeperDAO {

    private EntityManager entityManager;

    @Autowired
    public ZookeeperDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Zookeeper> findAll() {
        TypedQuery<Zookeeper> query = entityManager.createQuery("from Zookeeper", Zookeeper.class);
        return query.getResultList();
    }

    @Override
    public Zookeeper findById(Long id) {
        return entityManager.find(Zookeeper.class, id);
    }

    @Override
    @Transactional
    public Zookeeper save(Zookeeper zookeeper) {
        if (zookeeper.getId() == null) {
            entityManager.persist(zookeeper);
            return zookeeper;
        } else {
            return entityManager.merge(zookeeper);
        }
    }

    @Override
    @Transactional
    public void delete(Zookeeper zookeeper) {
        if (!entityManager.contains(zookeeper)) {
            zookeeper = entityManager.merge(zookeeper);
        }
        entityManager.remove(zookeeper);
    }
}
