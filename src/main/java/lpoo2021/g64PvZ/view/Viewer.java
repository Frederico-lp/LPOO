package lpoo2021.g64PvZ.view;

import lpoo2021.g64PvZ.gui.Gui;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(Gui gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }


    protected abstract void drawElements(Gui gui);
}