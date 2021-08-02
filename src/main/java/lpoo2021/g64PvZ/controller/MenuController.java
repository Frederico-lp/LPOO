package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.garden.Garden;

import java.io.IOException;


public class MenuController extends Controller<Garden> {
    private long lastIncrement;
    public MenuController(Garden garden) {
        super(garden);
        lastIncrement = 0;
    }

    @Override
    public void step(Game game, Gui.ACTION action, long time) throws IOException {
        switch (action) {
            case CHAR1:
                this.buyPlant(20, 10, 1);
                break;
            case CHAR2:
                this.buyPlant(20, 25, 3);
                break;
            case CHAR3:
                this.buyPlant(30, 5, 0);
                break;
            default:
                break;
        }
        if(time - lastIncrement > 5000) {
            incrementBudget();
            lastIncrement = time;
        }
    }

    public void buyPlant(int energy, int cost, int damage) {
        if(this.getModel().isPositionFree(this.getModel().getPlayer().getPosition()))
            this.getModel().addPlant(energy, cost, damage);
    }

    public void incrementBudget(){
        this.getModel().getMenu().setBudget(this.getModel().getMenu().getBudget() + 1);
    }

}
