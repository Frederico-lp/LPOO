package lpoo2021.g64PvZ.states;

import lpoo2021.g64PvZ.controller.Controller;
import lpoo2021.g64PvZ.controller.GardenController;
import lpoo2021.g64PvZ.model.garden.Garden;
import lpoo2021.g64PvZ.view.game.GardenViewer;
import lpoo2021.g64PvZ.view.Viewer;

public class GameState extends State<Garden> {
    public GameState(Garden garden) {
        super(garden);
    }

    @Override
    protected Viewer<Garden> getViewer() {
        return new GardenViewer(getModel());
    }

    @Override
    protected Controller<Garden> getController() {
        return new GardenController(getModel());
    }
}