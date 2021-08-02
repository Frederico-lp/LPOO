package lpoo2021.g64PvZ.model.elements.characters;

import lpoo2021.g64PvZ.model.elements.Element;

public abstract class Character extends Element {
    private int energy;
    private final int damage;

    public Character(int x,int y,int hp,int damage){
        super(x,y);
        this.energy = hp;
        this.damage = damage;
    }

    public int getEnergy() {
        return energy;
    }

    public int getDamage() {
        return damage;
    }

    public void decreaseEnergy(int attack) {
        this.energy-=attack;
    }

    public boolean isEnergyDepleted(){    return getEnergy()<=0;   }
}
