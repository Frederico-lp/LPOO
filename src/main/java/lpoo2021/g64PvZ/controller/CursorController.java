package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.garden.Garden;

import java.io.IOException;

public class CursorController extends Controller<Garden> {
    public CursorController(Garden garden) {
        super(garden);
    }


    public void moveCursorLeft() {
        moveCursor(getModel().getPlayer().getPosition().cursorGetLeft());
    }

    public void moveCursorRight() {
        moveCursor(this.getModel().getPlayer().getPosition().cursorGetRight());
    }

    public void moveCursorUp() {
        moveCursor(this.getModel().getPlayer().getPosition().cursorGetUp());
    }

    public void moveCursorDown() {
        moveCursor(this.getModel().getPlayer().getPosition().cursorGetDown());
    }

    private void moveCursor(Position position) {
        if(getModel().isFence(position) == null)
            this.getModel().getPlayer().setPosition(position);
    }

    @Override
    public void step(Game game, Gui.ACTION action, long time) throws IOException {
        if (action == Gui.ACTION.UP) moveCursorUp();
        if (action == Gui.ACTION.RIGHT) moveCursorRight();
        if (action == Gui.ACTION.DOWN) moveCursorDown();
        if (action == Gui.ACTION.LEFT) moveCursorLeft();
    }
}
