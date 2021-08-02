package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.characters.Plant;

public class PlantViewer implements ElementViewer<Plant> {
    public void drawElement(Plant plant, Gui gui) {
        if (plant.getCost() == 10) gui.drawPlant(plant.getPosition(), 1);
        if (plant.getCost() == 25) gui.drawPlant(plant.getPosition(), 2);
        if (plant.getCost() == 5) gui.drawPlant(plant.getPosition(), 3);
    }
}