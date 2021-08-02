package lpoo2021.g64PvZ.gui;

import lpoo2021.g64PvZ.model.Position;

import java.io.IOException;

public interface Gui {
    enum ACTION {SELECT, UP, DOWN, RIGHT, LEFT, NONE, QUIT, CHAR1, CHAR2, CHAR3}

    ACTION getNextAction() throws IOException;

    void drawProjectile(Position position);

    void drawPlant(Position position, int plantType);

    void drawZombie(Position position, boolean superZombie);

    void drawFence(Position position);

    void drawMenu(Position position, int budget, int level);

    void drawFinalScreen(boolean winner);

    void drawCursor(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws  IOException;

    void drawBackground();

    public void drawString(int x, int y, String c, String color);
}
