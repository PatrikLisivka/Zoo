package sk.kasv.lisivka.zoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.kasv.lisivka.zoo.dao.EnclosureDAO;
import sk.kasv.lisivka.zoo.entity.Enclosure;

import java.util.List;

@Service
public class EnclosureService {

    private final EnclosureDAO enclosureDAO;

    @Autowired
    public EnclosureService(EnclosureDAO enclosureDAO) {
        this.enclosureDAO = enclosureDAO;
    }

    public List<Enclosure> getAllEnclosures() {
        return enclosureDAO.findAll();
    }

    public Enclosure getEnclosureById(Long id) {
        return enclosureDAO.findById(id);
    }

    public Enclosure createEnclosure(Enclosure enclosure) {
        return enclosureDAO.save(enclosure);
    }

    public Enclosure updateEnclosure(Long id, Enclosure enclosure) {
        Enclosure existing = enclosureDAO.findById(id);
        if (existing != null) {
            existing.setName(enclosure.getName());
            existing.setSize(enclosure.getSize());
            existing.setClimate(enclosure.getClimate());
            // Pozor: animals sa tu neaktualizujú, sprav to podľa potreby
            return enclosureDAO.save(existing);
        }
        return null;
    }

    public void deleteEnclosure(Long id) {
        Enclosure existing = enclosureDAO.findById(id);
        if (existing != null) {
            enclosureDAO.delete(existing);
        }
    }
}
