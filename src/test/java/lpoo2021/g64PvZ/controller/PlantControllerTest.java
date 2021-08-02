package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;
import lpoo2021.g64PvZ.model.garden.Garden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlantControllerTest {
    private PlantController controller;
    private Garden garden;
    private Plant plant;
    private Game game;

    @BeforeEach
    void setUp(){
        garden = new Garden(10,10);
        plant = new Plant(2 ,2,4,5,20);

        garden.setZombies(Arrays.asList());
        garden.setFences(Arrays.asList());
        garden.setPlants(Arrays.asList(plant));
        controller = new PlantController(garden);

        game = Mockito.mock(Game.class);
    }

    @Test
    void shoot(){
        garden.setZombies(Arrays.asList(new Zombie(1, 2,1,false)));
        assertEquals(Arrays.asList(),this.plant.getPlantShots());
        controller.shoot();
        assertNotEquals(Arrays.asList(),this.plant.getPlantShots());
    }

    @Test
    void notShoot(){
        garden.setZombies(Arrays.asList(new Zombie(1 , 3,1,false)));
        assertEquals(Arrays.asList(),this.plant.getPlantShots());
        controller.shoot();
        assertEquals(Arrays.asList(),this.plant.getPlantShots());
    }
}
