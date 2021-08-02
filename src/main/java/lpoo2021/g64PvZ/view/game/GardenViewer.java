package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.Element;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.garden.Garden;
import lpoo2021.g64PvZ.view.Viewer;

import java.util.List;

public class GardenViewer extends Viewer<Garden> {

    public GardenViewer(Garden garden){
        super(garden);
    }


    @Override
    protected void drawElements(Gui gui) {
        gui.drawBackground();
        drawElements(gui, getModel().getFences(),new FenceViewer());
        drawElements(gui, getModel().getZombies(),new ZombieViewer());
        drawElements(gui, getModel().getPlants(),new PlantViewer());
        drawElement(gui, getModel().getMenu(),new MenuViewer());
        drawElement(gui, getModel().getPlayer(),new CursorViewer());

        for(Plant plant: getModel().getPlants())
            drawElements(gui, plant.getPlantShots(), new ProjectileViewer());
    }


    private <T extends Element> void drawElements(Gui gui, List<T> elements,ElementViewer<T> viewer){
        for(T auto: elements)
            drawElement(gui,auto,viewer);
    }

    private <T extends Element> void drawElement(Gui gui, T element,ElementViewer<T> viewer){
        viewer.drawElement(element, gui);
    }

}
