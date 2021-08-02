package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlantViewerTest {
    private Plant plant;
    private PlantViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp() {
        plant = new Plant(10, 10, 3, 20, 25);
        viewer = new PlantViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawElement() {
        viewer.drawElement(plant, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlant(plant.getPosition(), 2);
    }
}