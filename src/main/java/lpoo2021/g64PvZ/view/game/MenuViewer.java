package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.Menu;

public class MenuViewer implements ElementViewer<Menu> {
    public void drawElement(Menu menu, Gui gui) { gui.drawMenu(menu.getPosition(), menu.getBudget(), menu.getLevel()); }
}
