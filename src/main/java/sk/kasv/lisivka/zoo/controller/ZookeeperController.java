package sk.kasv.lisivka.zoo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.kasv.lisivka.zoo.entity.Zookeeper;
import sk.kasv.lisivka.zoo.service.ZookeeperService;

import java.util.List;

@RestController
@RequestMapping("/api/zookeepers")
public class ZookeeperController {

    @Autowired
    private ZookeeperService zookeeperService;

    @GetMapping
    public List<Zookeeper> getAllZookeepers() {
        return zookeeperService.getAllZookeepers();
    }

    @PostMapping
    public Zookeeper createZookeeper(@RequestBody Zookeeper zookeeper) {
        return zookeeperService.createZookeeper(zookeeper);
    }

    @PutMapping("/{id}")
    public Zookeeper updateZookeeper(@PathVariable Long id, @RequestBody Zookeeper zookeeper) {
        return zookeeperService.updateZookeeper(id, zookeeper);
    }
}