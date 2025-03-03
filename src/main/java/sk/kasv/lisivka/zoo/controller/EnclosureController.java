package sk.kasv.lisivka.zoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.kasv.lisivka.zoo.entity.Enclosure;
import sk.kasv.lisivka.zoo.service.EnclosureService;

import java.util.List;

@RestController
@RequestMapping("/api/enclosures")
public class EnclosureController {

    @Autowired
    private EnclosureService enclosureService;

    @GetMapping
    public List<Enclosure> getAllEnclosures() {
        return enclosureService.getAllEnclosures();
    }

    @PostMapping
    public Enclosure createEnclosure(@RequestBody Enclosure enclosure) {
        return enclosureService.createEnclosure(enclosure);
    }

    @PutMapping("/{id}")
    public Enclosure updateEnclosure(@PathVariable Long id, @RequestBody Enclosure enclosure) {
        return enclosureService.updateEnclosure(id, enclosure);
    }
}