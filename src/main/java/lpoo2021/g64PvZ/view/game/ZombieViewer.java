package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;

public class ZombieViewer implements ElementViewer<Zombie> {
    public void drawElement(Zombie zombie, Gui gui) {
        gui.drawZombie(zombie.getPosition(), zombie.isSuperZombie());
    }
}
