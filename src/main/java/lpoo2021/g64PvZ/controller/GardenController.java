package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.garden.Garden;

import java.io.IOException;

public class GardenController extends Controller<Garden> {
    private final PlantController plantController;
    private final ProjectileController projectileController;
    private final ZombieController zombieController;
    private final MenuController menuController;
    private final CursorController playerController;
    private long endingTime = 0;

    public GardenController(Garden garden) {
        super(garden);
        this.plantController = new PlantController(garden);
        this.zombieController = new ZombieController(garden);
        this.menuController = new MenuController(garden);
        this.playerController = new CursorController(garden);
        this.projectileController = new ProjectileController(garden);
    }

    @Override
    public void step(Game game, Gui.ACTION action, long time) throws IOException {
        if(endingTime == 0)
            endingTime = time + 60000;

        if(getModel().zombieInvade())
            game.lose();
        else if(isQuit(action))
            game.loadMainMenu();
        else if(getModel().getZombies().isEmpty() && time > endingTime) {
            game.incrementLevel();
            if(!game.won())
                game.loadNextLevel();
        }
        else
            processControllers(game, action,time);
    }

    private boolean isQuit(Gui.ACTION action){
        return action==Gui.ACTION.QUIT;
    }

    private void processControllers(Game game, Gui.ACTION action, long time) throws IOException {
        plantController.step(game, action, time);
        zombieController.step(game, action, time);
        menuController.step(game, action, time);
        playerController.step(game, action, time);
        projectileController.step(game, action, time);
    }


}
