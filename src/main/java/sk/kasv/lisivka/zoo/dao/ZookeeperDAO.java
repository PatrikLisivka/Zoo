package sk.kasv.lisivka.zoo.dao;

import sk.kasv.lisivka.zoo.entity.Zookeeper;

import java.util.List;

public interface ZookeeperDAO {
    List<Zookeeper> findAll();
    Zookeeper findById(Long id);
    Zookeeper save(Zookeeper zookeeper);
    void delete(Zookeeper zookeeper);
}
