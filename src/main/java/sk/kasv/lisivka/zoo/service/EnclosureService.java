package sk.kasv.lisivka.zoo.service;

import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.entity.Enclosure;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnclosureService {

    private List<Enclosure> enclosures = new ArrayList<>();

    public List<Enclosure> getAllEnclosures() {
        return enclosures;
    }

    public Enclosure createEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
        return enclosure;
    }

    public Enclosure updateEnclosure(Long id, Enclosure enclosure) {
        for (Enclosure existingEnclosure : enclosures) {
            if (existingEnclosure.getId().equals(id)) {
                existingEnclosure.setName(enclosure.getName());
                existingEnclosure.setSize(enclosure.getSize());
                existingEnclosure.setClimate(enclosure.getClimate());
                return existingEnclosure;
            }
        }
        return null;
    }
}