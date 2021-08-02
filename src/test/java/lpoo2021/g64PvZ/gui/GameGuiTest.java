package lpoo2021.g64PvZ.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo2021.g64PvZ.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameGuiTest {
    private Screen screen;
    private GameGui gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp(){
        this.screen = Mockito.mock(Screen.class);
        this.tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        this.gui = new GameGui(this.screen);
    }

    @Test
    void drawProjectile(){
        gui.drawProjectile(new Position(1,1));
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#013220"));
        Mockito.verify(tg,Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
    }

    @Test
    void drawCursor(){
        gui.drawCursor(new Position(1,1));
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        Mockito.verify(tg,Mockito.times(0)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
    }

    @Test
    void drawGreenPlant(){
        gui.drawPlant(new Position(1,1),1);
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#013220"));
        Mockito.verify(tg,Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#7FFF00"));
    }

    @Test
    void drawBluePlant(){
        gui.drawPlant(new Position(1,1),2);
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#013220"));
        Mockito.verify(tg,Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#1E90FF"));
    }

    @Test
    void drawRosePlant(){
        gui.drawPlant(new Position(1,1),3);
        Mockito.verify(tg,Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#013220"));
        Mockito.verify(tg,Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFC0CB"));
    }

    @Test
    void drawPlantNoDefinedType(){
        gui.drawPlant(new Position(1,1),0);
        Mockito.verify(tg,Mockito.times(0)).setBackgroundColor(TextColor.Factory.fromString("#7FFF00"));
        Mockito.verify(tg,Mockito.times(0)).setBackgroundColor(TextColor.Factory.fromString("#1E90FF"));
        Mockito.verify(tg,Mockito.times(0)).setBackgroundColor(TextColor.Factory.fromString("#FFC0CB"));
    }

    @Test
    void drawString(){
        gui.drawString(0,0,"Testing","#FFFFFF");
        Mockito.verify(tg,Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
    }
}
