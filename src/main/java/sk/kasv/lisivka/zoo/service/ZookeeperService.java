package sk.kasv.lisivka.zoo.service;

import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.entity.Zookeeper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZookeeperService {

    private List<Zookeeper> zookeepers = new ArrayList<>();

    public List<Zookeeper> getAllZookeepers() {
        return zookeepers;
    }

    public Zookeeper createZookeeper(Zookeeper zookeeper) {
        zookeepers.add(zookeeper);
        return zookeeper;
    }

    public Zookeeper updateZookeeper(Long id, Zookeeper zookeeper) {
        for (Zookeeper existingZookeeper : zookeepers) {
            if (existingZookeeper.getId().equals(id)) {
                existingZookeeper.setName(zookeeper.getName());
                existingZookeeper.setExperience(zookeeper.getExperience());
                existingZookeeper.setSpecialization(zookeeper.getSpecialization());
                return existingZookeeper;
            }
        }
        return null;
    }
}