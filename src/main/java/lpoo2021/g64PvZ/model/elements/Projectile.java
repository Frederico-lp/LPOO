package lpoo2021.g64PvZ.model.elements;

import lpoo2021.g64PvZ.model.Position;

public class Projectile extends Element{
    private final int damage;

    public Projectile(int x, int y,int damage){
        super(x,y);
        this.damage = damage;
    }

    public Projectile(Position position,int damage){
        this(position.getX(), position.getY(),damage );
    }

    public int getDamage() {
        return damage;
    }
}
