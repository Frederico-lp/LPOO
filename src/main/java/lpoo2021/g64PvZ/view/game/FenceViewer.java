package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.Fence;

public class FenceViewer implements ElementViewer<Fence>{

    @Override
    public void drawElement(Fence element, Gui gui) {
        gui.drawFence(element.getPosition());
    }
}
