package sk.kasv.lisivka.zoo.dao;

import sk.kasv.lisivka.zoo.entity.Enclosure;

import java.util.List;

public interface EnclosureDAO {
    List<Enclosure> findAll();
    Enclosure findById(Long id);
    Enclosure save(Enclosure enclosure);
    void delete(Enclosure enclosure);
}
