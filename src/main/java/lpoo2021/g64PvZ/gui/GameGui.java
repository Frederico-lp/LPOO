package lpoo2021.g64PvZ.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import lpoo2021.g64PvZ.model.Position;

import java.io.IOException;

public class GameGui implements Gui{
    private Screen screen;

    public GameGui(Screen screen){
        this.screen = screen;
    }
    public  GameGui(int width, int height) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        this.createScreen(terminal);
    }

    private void createScreen(Terminal terminal) throws IOException{
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();

        if(keyStroke == null) return ACTION.NONE;
        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter()=='w')) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter()=='s')) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowRight || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter()=='d')) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft || (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter()=='a')) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter()=='1') return ACTION.CHAR1;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter()=='2') return ACTION.CHAR2;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter()=='3') return ACTION.CHAR3;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawPlant(Position position, int plantType) {
        if (plantType == 1) drawCharacter(position.getX(), position.getY(), 'P', "#7FFF00");
        if (plantType == 2) drawCharacter(position.getX(), position.getY(), 'P', "#1E90FF");
        if (plantType == 3) drawCharacter(position.getX(), position.getY(), 'P', "#FFC0CB");
    }

    public void drawCursor(Position position){
        drawCharacter(position.getX(), position.getY(), ' ', "#FFFF00");
    }

    @Override
    public void drawZombie(Position position, boolean superZombie) {
        if(superZombie)
            drawCharacter(position.getX(), position.getY(), 'Z', "#7F0000");
        else drawCharacter(position.getX(), position.getY(), 'Z', "#FF4C4C");
    }

    @Override
    public void drawFence(Position position) {
        drawCharacter(position.getX(), position.getY(), '=', "#FFFFFF");
    }

    @Override
    public void drawMenu(Position position, int budget, int level) {
        drawString(position.getX(), position.getY(), "LEVEL " + Integer.toString(level) , "#FFFFFF");
        drawString(position.getX(), position.getY()+1, "Current Budget: " + Integer.toString(budget) , "#FFFFFF");
        drawString(position.getX(), position.getY()+3, "Plants available: ", "#FFFFFF");
        drawString(position.getX(), position.getY()+4, "1 - Normal Plant (HEALTH: 20, COST: 10, DAMAGE: 1)", "#7FFF00");
        drawString(position.getX(), position.getY()+5, "2 - Super Plant (HEALTH: 20, COST: 25, DAMAGE: 3)", "#1E90FF");
        drawString(position.getX(), position.getY()+6, "3 - Plant with No Attack (HEALTH: 30, COST: 5, DAMAGE: 0)", "#FFC0CB");
        drawString(position.getX(), position.getY()+8, "Press q to quit to Main Menu", "#FFFFFF");
    }

    @Override
    public void drawFinalScreen(boolean winner) {
        if (winner) {
            drawString(0, 0, "CONGRATULATIONS,", "#FFFFFF");
            drawString(0, 1, "YOU WON!", "#FFFFFF");
        }
        else {
            drawString(0, 0, "GAME OVER,", "#FFFFFF");
            drawString(0, 1, "YOU LOST!", "#FFFFFF");
        }
    }

    public void drawProjectile(Position position){
        drawCharacter(position.getX(), position.getY(), '-',"#FFFFFF");
    }

    public void drawBackground(){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#013220"));
        graphics.fillRectangle(new TerminalPosition(0,0),screen.getTerminalSize(),' ');
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        if(c==' ')
            tg.setBackgroundColor(TextColor.Factory.fromString(color));
        else {
            tg.setBackgroundColor(TextColor.Factory.fromString("#013220"));
            tg.setForegroundColor(TextColor.Factory.fromString(color));
        }

        tg.putString(x, y + 1, "" + c);
    }

    public void drawString(int x, int y, String c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
