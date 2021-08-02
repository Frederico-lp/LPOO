package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.Element;

public interface ElementViewer<T extends Element>  {
    void drawElement(T element, Gui gui);
}
