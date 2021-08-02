package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;
import lpoo2021.g64PvZ.model.garden.Garden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ZombieControllerTest {
    private ZombieController controller;
    private Garden garden;
    private Game game;

    @BeforeEach
    void setUp() {
        garden = new Garden(10, 10);

        garden.setPlants(Arrays.asList());
        garden.setFences(Arrays.asList());

        controller = new ZombieController(garden);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveZombie() throws IOException {
        Zombie zombie = new Zombie(5, 5, 1, false);
        garden.setZombies(Arrays.asList(zombie));

        controller.step(game, Gui.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), zombie.getPosition());
    }
}