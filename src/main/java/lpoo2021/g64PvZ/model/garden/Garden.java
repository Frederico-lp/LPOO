package lpoo2021.g64PvZ.model.garden;

import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.ZombieGenerator;
import lpoo2021.g64PvZ.model.elements.Cursor;
import lpoo2021.g64PvZ.model.elements.Element;
import lpoo2021.g64PvZ.model.elements.Fence;
import lpoo2021.g64PvZ.model.elements.Menu;
import lpoo2021.g64PvZ.model.elements.characters.Plant;
import lpoo2021.g64PvZ.model.elements.characters.Zombie;

import java.util.List;

public class Garden {
    private final int width;
    private final int height;

    private List<Plant> plants;
    private List<Zombie> zombies;
    private List<Fence> fences;
    private Menu menu;
    private Cursor player;
    private final ZombieGenerator zombieGenerator;

    public Garden(int width, int height) {
        this.width = width;
        this.height = height;
        this.zombieGenerator = new ZombieGenerator(width,height);
    }
    public int getWidth() {
        return width;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public void addPlant(int energy, int cost, int damage) {
        Plant aux = this.menu.buyPlant(player.getPosition(), energy, cost, damage);
        if(aux != null)
            this.plants.add(aux);
    }

    public List<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(List<Zombie> zombies) {
        this.zombies = zombies;
    }

    public void addZombie(double difficulty) {
        this.zombies.add(this.zombieGenerator.generateZombie(difficulty));
    }

    public List<Fence> getFences() {
        return fences;
    }

    public void setFences(List<Fence> fences) {
        this.fences = fences;
    }

    public Cursor getPlayer() {
        return player;
    }

    public void setPlayer(Cursor cursor){ this.player = cursor; }

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }

    public Plant isPlant(Position position){
        return this.collides(this.plants,position);
    }

    public Zombie isZombie(Position position){
        return this.collides(this.zombies,position);
    }

    public Fence isFence(Position position){
        return this.collides(this.fences,position);
    }

    private <T extends Element> T collides(List<T> elements, Position position){
        for(T element: elements)
            if(element.getPosition().equals(position))
                return element;
        return null;
    }

    public void checkPlants(){
        plants.removeIf(Plant::isEnergyDepleted);
    }

    public void checkZombies() {
        if(zombies.removeIf(Zombie::isEnergyDepleted))
            menu.setBudget(menu.getBudget() + 20);
    }

    public boolean isPositionFree(Position position){
        return collides(plants,position) == null && this.collides(this.zombies, position) == null;
    }

    public boolean checkZombieHeight(int height){
        for(Zombie zombie: getZombies()){
            if(zombie.getPosition().getY() == height)
                return true;
        }
        return false;
    }
    public boolean zombieInvade() {
        if(!getZombies().isEmpty())
            for(Zombie zombie: getZombies()){
                if(zombie.invadedHouse())
                    return true;
            }
        return false;
    }

}
