package lpoo2021.g64PvZ.model.garden;


public class LevelCreator {
    private Garden garden;

    public LevelCreator(int level){
        if (level == 1)
            this.garden = new RandomGardenBuilder(60, 10, level).createGarden();
        else if (level == 2)
            this.garden = new RandomGardenBuilder(55, 15, level).createGarden();
        else if (level == 3)
            this.garden = new RandomGardenBuilder(55, 20, level).createGarden();
    }

    public Garden getGarden() {
        return garden;
    }



}
