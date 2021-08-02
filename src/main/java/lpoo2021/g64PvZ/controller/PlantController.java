package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.Projectile;
import lpoo2021.g64PvZ.model.garden.Garden;

import java.io.IOException;

public class PlantController extends Controller<Garden> {
    private long lastShot;

    public PlantController(Garden garden) {
        super(garden);
        lastShot = 0;
    }

    @Override
    public void step(Game game, Gui.ACTION action, long time) throws IOException {
        checkPlants();
        if(time - lastShot > 1000) {
            shoot();
            lastShot = time;
        }
    }

    public void checkPlants(){
        this.getModel().checkPlants();
    }

    public void shoot(){
        for(Plant plant:this.getModel().getPlants())
            if ( (plant.getDamage() != 0) && getModel().checkZombieHeight(plant.getPosition().getY())) {
               plant.addShot(new Projectile(plant.getPosition().cursorGetRight(),plant.getDamage()));
            }
    }
}
