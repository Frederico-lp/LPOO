package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ZombieViewerTest {
    private Zombie zombie;
    private ZombieViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp() {
        zombie = new Zombie(10, 10, 1, true);
        viewer = new ZombieViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElement() {
        viewer.drawElement(zombie, gui);
        Mockito.verify(gui, Mockito.times(1)).drawZombie(zombie.getPosition(), zombie.isSuperZombie());
    }
}