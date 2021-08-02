package lpoo2021.g64PvZ.model;

import lpoo2021.g64PvZ.model.elements.characters.Zombie;

import java.util.Random;

public class ZombieGenerator {
    private final int gardenWidth,gardenHeight;

    public ZombieGenerator(int width,int height){
        this.gardenHeight = height;
        this.gardenWidth = width;
    }

    public Zombie generateZombie(double difficulty){
        Random r = new Random();
        boolean superZombie = isSuperZombie(r.nextInt(30/(int)difficulty));
        if(superZombie)
            difficulty += 2;
        return new Zombie(gardenWidth, r.nextInt(gardenHeight-2) + 1, (int)difficulty, superZombie);
    }

    private boolean isSuperZombie(int number){  return number==0; }
}
