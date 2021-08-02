package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Home;

import java.io.IOException;

public class HomeController extends Controller<Home>{

    public HomeController(Home home){
        super(home);
    }

    @Override
    public void step(Game game, Gui.ACTION action, long time) throws IOException {
        switch (action){
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if(getModel().isStart()) {
                    game.reset();
                    game.loadNextLevel();
                }
                else game.exitGame();
                break;
            default:
                break;
        }
    }
}

