package lpoo2021.g64PvZ.model.elements;

import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;
import lpoo2021.g64PvZ.model.garden.Garden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GardenTest {
    private Garden garden;

    @BeforeEach
    void setUp(){
        garden = new Garden(10,10);
        garden.setPlants(Collections.emptyList());
        garden.setZombies(Collections.emptyList());
        garden.setFences(Collections.emptyList());
    }

    @Test
    void collidesNot(){
        Position position = new Position(0,0);
        assertNull(garden.isFence(position));
        assertNull(garden.isPlant(position));
        assertNull(garden.isZombie(position));
    }

    @Test
    void collides(){
        Position position = new Position(0,0);
        garden.setPlants(Collections.singletonList(new Plant(0,0,1,1,1)));
        garden.setZombies(Collections.singletonList(new Zombie(0,0,1,false)));
        assertNotEquals(null,garden.isZombie(position));
        assertNotEquals(null,garden.isPlant(position));
        assertNull(garden.isFence(position));
    }
}
