package lpoo2021.g64PvZ.model.elements;

import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.elements.characters.Plant;

public class Menu extends Element {
    int budget;
    int level;

    public Menu(int x, int y, int level) {
        super(x, y);
        budget = 50;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public Plant buyPlant(Position position, int energy, int cost, int damage) {
        if (this.canBuy(cost)) {
            budget -= cost;
            return new Plant(position.getX(), position.getY(),damage, energy, cost);
        }
        // impossible position
        else return null;
    }

    private boolean canBuy(int cost){
        return this.budget >= cost;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
