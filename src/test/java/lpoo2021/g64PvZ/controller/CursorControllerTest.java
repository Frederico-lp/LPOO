package lpoo2021.g64PvZ.controller;

import lpoo2021.g64PvZ.model.Position;
import lpoo2021.g64PvZ.model.elements.Cursor;
import lpoo2021.g64PvZ.model.elements.Fence;
import lpoo2021.g64PvZ.model.garden.Garden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CursorControllerTest {
    private CursorController controller;
    private Garden garden;
    private Cursor cursor;

    @BeforeEach
    void setUp(){
        garden = new Garden(10,10);
        cursor = new Cursor(1,1);

        garden.setFences(Collections.emptyList());
        garden.setPlayer(cursor);
        controller = new CursorController(garden);
    }

    @Test
    void moveCursorDown(){
        controller.moveCursorDown();
        assertEquals(new Position(1,2),cursor.getPosition());
    }

    @Test
    void dontMoveCursorDown(){
        garden.setFences(Collections.singletonList(new Fence(1, 2)));

        controller.moveCursorDown();
        assertEquals(new Position(1,1),cursor.getPosition());
    }
}
