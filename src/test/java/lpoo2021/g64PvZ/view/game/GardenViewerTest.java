package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.elements.*;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;
import lpoo2021.g64PvZ.model.garden.Garden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;


class GardenViewerTest {
    private Gui gui;
    private GardenViewer viewer;
    private Garden garden;

    @BeforeEach
    void setUp() {
        garden = new Garden(10, 10);
        gui = Mockito.mock(Gui.class);
        viewer = new GardenViewer(garden);

        garden.setFences(Arrays.asList(new Fence(1, 2), new Fence(2, 3), new Fence(3, 4)));
        garden.setZombies(Arrays.asList(new Zombie(4, 5, 1, false), new Zombie(5, 6, 1, true)));
        garden.setPlants(Arrays.asList(new Plant(1, 2, 3, 20, 25), new Plant(3, 4, 3, 20, 25)));
        garden.setMenu(new Menu(11, 0, 1));
        garden.setPlayer(new Cursor(0, 0));
    }

    @Test
    void drawFences() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawFence(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawFence(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawFence(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawFence(Mockito.any(Position.class));
    }

    @Test
    void drawZombies() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawZombie(new Position(4, 5), false);
        Mockito.verify(gui, Mockito.times(1)).drawZombie(new Position(5, 6), true);
        Mockito.verify(gui, Mockito.times(2)).drawZombie(Mockito.any(Position.class), Mockito.any(boolean.class));
    }

    @Test
    void drawPlants() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlant(new Position(1, 2), 2);
        Mockito.verify(gui, Mockito.times(1)).drawPlant(new Position(3, 4), 2);
        Mockito.verify(gui, Mockito.times(2)).drawPlant(Mockito.any(Position.class), Mockito.any(Integer.class));
    }

    @Test
    void drawMenu() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawMenu(new Position(11, 0), 50, 1);
        Mockito.verify(gui, Mockito.times(1)).drawMenu(Mockito.any(Position.class), Mockito.any(Integer.class), Mockito.any(Integer.class));
    }

    @Test
    void drawCursor() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCursor(new Position(0, 0));
        Mockito.verify(gui, Mockito.times(1)).drawCursor(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
