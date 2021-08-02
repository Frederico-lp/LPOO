package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.Projectile;

public class ProjectileViewer implements ElementViewer<Projectile> {
    @Override
    public void drawElement(Projectile element, Gui gui) {
        gui.drawProjectile(element.getPosition());
    }
}
