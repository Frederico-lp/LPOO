package lpoo2021.g64PvZ.model.elements.characters;

import lpoo2021.g64PvZ.model.elements.Projectile;

import java.util.ArrayList;
import java.util.List;

public class Plant extends Character {
    private final int cost;
    private List<Projectile> plantShots;

    public Plant(int x, int y,int damage, int energy, int cost) {
        super(x, y,energy,damage);
        this.cost = cost;
        this.plantShots = new ArrayList<>();
    }

    public int getCost() {
        return cost;
    }

    public List<Projectile> getPlantShots() {
        return plantShots;
    }

    public void addShot(Projectile projectile){
        this.plantShots.add(projectile);
    }
}
