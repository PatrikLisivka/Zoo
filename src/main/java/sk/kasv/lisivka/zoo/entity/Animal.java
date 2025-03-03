package sk.kasv.lisivka.zoo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;
    private int age;
    private String healthStatus;

    @ManyToOne
    @JoinColumn(name = "enclosure_id")
    private Enclosure enclosure;
}