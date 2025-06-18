package sk.kasv.lisivka.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.dao.ZookeeperDAO;
import sk.kasv.lisivka.zoo.entity.Zookeeper;

import java.util.List;

@Service
public class ZookeeperService {

    private final ZookeeperDAO zookeeperDAO;

    @Autowired
    public ZookeeperService(ZookeeperDAO zookeeperDAO) {
        this.zookeeperDAO = zookeeperDAO;
    }

    public List<Zookeeper> getAllZookeepers() {
        return zookeeperDAO.findAll();
    }

    public Zookeeper getZookeeperById(Long id) {
        return zookeeperDAO.findById(id);
    }

    public Zookeeper createZookeeper(Zookeeper zookeeper) {
        return zookeeperDAO.save(zookeeper);
    }

    public Zookeeper updateZookeeper(Long id, Zookeeper zookeeper) {
        Zookeeper existing = zookeeperDAO.findById(id);
        if (existing != null) {
            existing.setName(zookeeper.getName());
            existing.setExperience(zookeeper.getExperience());
            existing.setSpecialization(zookeeper.getSpecialization());
            return zookeeperDAO.save(existing);
        }
        return null;
    }

    public void deleteZookeeper(Long id) {
        Zookeeper existing = zookeeperDAO.findById(id);
        if (existing != null) {
            zookeeperDAO.delete(existing);
        }
    }
}
