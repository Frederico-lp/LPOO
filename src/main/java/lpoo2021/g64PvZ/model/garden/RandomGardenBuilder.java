package lpoo2021.g64PvZ.model.garden;

import lpoo2021.g64PvZ.model.elements.Cursor;
import lpoo2021.g64PvZ.model.elements.Fence;
import lpoo2021.g64PvZ.model.elements.Menu;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;

import java.util.ArrayList;
import java.util.List;

public class RandomGardenBuilder extends GardenBuilder {
    private final int width;
    private final int height;
    int level;

    public RandomGardenBuilder(int width, int height, int level) {
        this.width = width;
        this.height = height;
        this.level = level;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected List<Fence> createFences() {
        List<Fence> fences = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            fences.add(new Fence(x, 0));
            fences.add(new Fence(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            fences.add(new Fence(0, y));
            fences.add(new Fence(width - 1, y));
        }

        return fences;
    }

    @Override
    public Cursor createPlayer() {
        return new Cursor(1,1);
    }

    @Override
    protected List<Zombie> createZombies() {
        return new ArrayList<>();
    }

    @Override
    protected List<Plant> createPlants() {
        return new ArrayList<>();
    }

    @Override
    protected Menu createMenu() {
        return new Menu(0, this.height, level);
    }
}
