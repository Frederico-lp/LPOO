package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, Gui.ACTION action, long time) throws IOException;
}