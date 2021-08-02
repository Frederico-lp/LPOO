package lpoo2021.g64PvZ.view.game;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.elements.Cursor;

public class CursorViewer implements ElementViewer<Cursor> {
    public void drawElement(Cursor cursor, Gui gui) {
        gui.drawCursor(cursor.getPosition());
    }
}