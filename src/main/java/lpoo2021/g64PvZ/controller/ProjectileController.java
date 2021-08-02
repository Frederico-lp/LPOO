package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.game.Game;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.Projectile;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;
import lpoo2021.g64PvZ.model.garden.Garden;

import java.io.IOException;
import java.util.Iterator;

public class ProjectileController extends Controller<Garden> {

    public ProjectileController(Garden garden){
        super(garden);
    }

    @Override
    public void step(Game game, Gui.ACTION action, long time) throws IOException {
        moveShots();
    }

    public void moveShots(){
        for(Plant plant: getModel().getPlants()) {
            Iterator<Projectile> iterator = plant.getPlantShots().iterator();
            processPlantProjectiles(iterator);
        }
    }

    private void processPlantProjectiles(Iterator<Projectile> iterator){
        while (iterator.hasNext()) {
            if(processPlantProjectile(iterator.next()) )
                iterator.remove();
        }
    }

    private boolean processPlantProjectile(Projectile plantShot){
        Zombie zombie;
        if(( zombie = this.hitsZombie( plantShot.getPosition() ) ) != null) {
            zombie.decreaseEnergy(plantShot.getDamage());
            return true;
        }
        if (isOutOfBounds(plantShot)) {
            return true;
        }
        plantShot.setPosition(plantShot.getPosition().cursorGetRight());
        return false;
    }

    private boolean isOutOfBounds(Projectile projectile){
        return projectile.getPosition().getX() + 3 > getModel().getWidth();
    }

    private Zombie hitsZombie(Position projectilePosition){
        Zombie zombie;
        if((zombie = getModel().isZombie(projectilePosition)) != null)
            return zombie;
        else
            return getModel().isZombie(projectilePosition.cursorGetRight());
    }
}
