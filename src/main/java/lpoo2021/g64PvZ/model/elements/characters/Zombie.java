package lpoo2021.g64PvZ.model.elements.characters;

public class Zombie extends Character {
    private boolean superZombie;

    public Zombie(int x, int y, int difficulty, boolean superZombie){
        super(x, y,8*difficulty,2*difficulty);
        this.superZombie = superZombie;
    }

    public boolean isSuperZombie() {
        return superZombie;
    }

    public void move() {
        setPosition(getPosition().getLeft());
    }

    public boolean invadedHouse(){   return this.getPosition().getX()==0;    }
}
