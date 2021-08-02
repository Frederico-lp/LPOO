package lpoo2021.g64PvZ.game;

import lpoo2021.g64PvZ.gui.GameGui;
import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Home;
import lpoo2021.g64PvZ.model.garden.LevelCreator;
import lpoo2021.g64PvZ.states.GameState;
import lpoo2021.g64PvZ.states.HomeState;
import lpoo2021.g64PvZ.states.State;

import java.io.IOException;

public class Game {
    private final GameGui gui;
    private State state;
    private int level;

    public Game(Gui gui) throws IOException {
        this.state = new HomeState(new Home());
        this.gui = (GameGui) gui;
        this.level = 1;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Game(new GameGui(120, 120)).start();
    }

    private void createArena(){
            this.setState(new GameState(new LevelCreator(this.level).getGarden()));
    }

    public void incrementLevel(){
        this.setLevel(getLevel()+1);
    }

    public boolean won(){
        return this.level >=4;
    }

    public void loadNextLevel(){
        this.createArena();
    }

    private void setState(State state) {
        this.state = state;
    }

    public int getLevel() {
        return level;
    }

    public void reset(){
        this.setLevel(1);
    }

    public void loadMainMenu(){
        this.reset();
        this.setState(new HomeState(new Home()));
    }

    public void exitGame(){
        this.setState(null);
    }

    public void lose(){
        try {
            this.endGame(false);
        }catch (Exception exception) {

        }
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void start() throws IOException, InterruptedException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long sleepTime = calculateSleepTime(frameTime,getElapsedTime(startTime));

            if (sleepTime > 0) Thread.sleep(sleepTime);
            if(this.won())
                endGame(true);
        }
        gui.close();
    }

    private long getElapsedTime(long startTime){
        return System.currentTimeMillis() - startTime;
    }

    private long calculateSleepTime(int frameTime,long elapsedTime){
        return frameTime - elapsedTime;
    }

    private void displayFinalScreen(boolean victorious) throws IOException {
        gui.clear();
        gui.drawBackground();
        gui.drawFinalScreen(victorious);
        gui.refresh();
    }

    private void endGame(boolean victorious) throws IOException, InterruptedException {
        displayFinalScreen(victorious);
        Thread.sleep(3000);
        this.loadMainMenu();
    }


}
