package lpoo2021.g64PvZ.game;

import lpoo2021.g64PvZ.gui.GameGui;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private GameGui gui;
    @BeforeEach
    void setUp() throws IOException {
        gui= Mockito.mock(GameGui.class);
        this.game = new Game(gui);
    }

    @Test
    void won(){
        assertFalse( game.won());
        game.incrementLevel();
        assertFalse( game.won());
        game.incrementLevel();
        assertFalse( game.won());
        game.incrementLevel();
        assertTrue(game.won());
    }

    @Test
    void incrementLevel(){
        assertEquals(1,this.game.getLevel());
        game.incrementLevel();
        assertEquals(2,this.game.getLevel());
    }

    @Test
    void reset(){
        assertEquals(1,this.game.getLevel());
        game.incrementLevel();
        assertNotEquals(1,this.game.getLevel());
        game.reset();
        assertEquals(1,this.game.getLevel());
    }

}
