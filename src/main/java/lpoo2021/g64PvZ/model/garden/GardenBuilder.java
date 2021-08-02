package lpoo2021.g64PvZ.model.garden;

import lpoo2021.g64PvZ.model.elements.*;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;

import java.util.List;

public abstract class GardenBuilder {

    public Garden createGarden() {
        Garden garden = new Garden(getWidth(), getHeight());

        garden.setPlants(createPlants());
        garden.setZombies(createZombies());
        garden.setFences(createFences());
        garden.setPlayer(createPlayer());
        garden.setMenu(createMenu());

        return garden;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Zombie> createZombies();

    protected abstract List<Plant> createPlants();

    protected abstract List<Fence> createFences();

    public abstract Cursor createPlayer();

    protected abstract Menu createMenu();
}
