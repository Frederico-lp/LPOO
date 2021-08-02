package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;
import lpoo2021.g64PvZ.model.garden.Garden;

import java.io.IOException;

public class ZombieController extends Controller<Garden> {
    private long lastSpawn;
    private long endOfSpawn;
    private long lastMovement;
    private double difficulty;
    private boolean firstIteration;

    public ZombieController(Garden garden) {
        super(garden);
        this.lastSpawn = 0;
        this.lastMovement = 0;
        this.difficulty = 1;
    }

    @Override
    public void step(Game game, Gui.ACTION action, long time) throws IOException {
        if(endOfSpawn == 0) {
            endOfSpawn = time + 60000;
        }
        if(time < endOfSpawn) {
            if ( (time - lastSpawn) >= 15000 / difficulty) {
                difficulty += game.getLevel() * 0.15;
                createZombie(difficulty);
                lastSpawn = time;
            }
        }
        if(time - lastMovement > 500) {
            moveZombies();
            lastMovement = time;
        }
        checkZombies();

    }

    public void moveZombies() {
        Plant plant;
        for (Zombie zombie : this.getModel().getZombies()) {
            if ((plant = getModel().isPlant(zombie.getPosition().cursorGetLeft())) != null) {
                plant.decreaseEnergy(zombie.getDamage());
                continue;
            }

            zombie.move();
        }
    }

    public void createZombie(double difficulty){
        this.getModel().addZombie(difficulty);
    }

    public void checkZombies(){
        this.getModel().checkZombies();
    }



}
