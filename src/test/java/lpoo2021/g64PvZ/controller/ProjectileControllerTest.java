package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.Projectile;
import lpoo2021.g64PvZ.model.garden.Garden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProjectileControllerTest {
    private ProjectileController controller;
    private Garden garden;
    private Plant plant;
    private Game game;

    @BeforeEach
    void setUp() {
        garden = new Garden(10, 10);

        plant = new Plant(5, 5, 1, 10, 20);
        garden.setPlants(Arrays.asList(plant));
        garden.setZombies(Arrays.asList());
        garden.setFences(Arrays.asList());

        controller = new ProjectileController(garden);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveProjectile() throws IOException {
        Projectile projectile = new Projectile(4, 4, 1);
        plant.addShot(projectile);

        controller.step(game, Gui.ACTION.NONE, 1000);

        assertNotEquals(new Position(4, 4), projectile.getPosition());
    }
}