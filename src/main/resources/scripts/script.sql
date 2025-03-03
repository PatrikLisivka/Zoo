DROP TABLE IF EXISTS animal_food;
DROP TABLE IF EXISTS animal;
DROP TABLE IF EXISTS enclosure;
DROP TABLE IF EXISTS zookeeper;
DROP TABLE IF EXISTS food;

CREATE TABLE enclosure (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           size DOUBLE NOT NULL,
                           climate VARCHAR(255) NOT NULL
);

CREATE TABLE animal (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        species VARCHAR(255) NOT NULL,
                        age INT NOT NULL,
                        health_status VARCHAR(255) NOT NULL,
                        enclosure_id BIGINT,
                        FOREIGN KEY (enclosure_id) REFERENCES enclosure(id) ON DELETE SET NULL
);

CREATE TABLE zookeeper (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           experience INT NOT NULL,
                           specialization VARCHAR(255) NOT NULL
);

CREATE TABLE food (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      type VARCHAR(255) NOT NULL,
                      stock INT NOT NULL
);

CREATE TABLE animal_food (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             animal_id BIGINT NOT NULL,
                             food_id BIGINT NOT NULL,
                             amount_per_day INT NOT NULL,
                             FOREIGN KEY (animal_id) REFERENCES animal(id) ON DELETE CASCADE,
                             FOREIGN KEY (food_id) REFERENCES food(id) ON DELETE CASCADE
);

INSERT INTO enclosure (name, size, climate) VALUES
                                                ('Savanna Zone', 500.0, 'Warm'),
                                                ('Rainforest Area', 300.0, 'Humid'),
                                                ('Arctic Habitat', 400.0, 'Cold');

INSERT INTO animal (name, species, age, health_status, enclosure_id) VALUES
                                                                         ('Lev', 'Lev', 5, 'Zdravý', 1),
                                                                         ('Slon', 'Slon africký', 12, 'Zdravý', 1),
                                                                         ('Opica', 'Opica kapucínka', 7, 'Zranená', 2),
                                                                         ('Tučniak', 'Tučniak cisársky', 4, 'Zdravý', 3);

INSERT INTO zookeeper (name, experience, specialization) VALUES
                                                             ('Ján Novák', 10, 'Veľké mačky'),
                                                             ('Anna Kováčová', 8, 'Primáty'),
                                                             ('Mikuláš Horváth', 5, 'Arktické zvieratá');

INSERT INTO food (name, type, stock) VALUES
                                         ('Mäso', 'Mäsové', 50),
                                         ('Banány', 'Ovocie', 100),
                                         ('Ryby', 'Morská strava', 75);

INSERT INTO animal_food (animal_id, food_id, amount_per_day) VALUES
                                                                 (1, 1, 5),
                                                                 (2, 1, 10),
                                                                 (3, 2, 7),
                                                                 (4, 3, 3);
