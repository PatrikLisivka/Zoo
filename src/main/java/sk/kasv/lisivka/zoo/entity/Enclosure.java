package sk.kasv.lisivka.zoo.entity;

import jakarta.persistence.*;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Enclosure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double size;
    private String climate;

    @OneToMany(mappedBy = "enclosure")
    private List<Animal> animals;
}
