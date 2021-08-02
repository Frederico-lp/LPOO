package lpoo2021.g64PvZ.states;

import lpoo2021.g64PvZ.controller.Controller;
import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, Gui gui, long time) throws IOException {
        Gui.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }


}