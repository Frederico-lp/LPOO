package lpoo2021.g64PvZ.model.elements;

import lpoo2021.g64PvZ.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp(){
        menu = new Menu(0,0,1);
    }

    @Test
    void buyPlant(){
        assertNotEquals(null,menu.buyPlant(new Position(1,1),1,50,10));
        assertNull(menu.buyPlant(new Position(2,2),1,1,10));

        menu.setBudget(20);

        assertNotEquals(null,menu.buyPlant(new Position(1,1),1,10,10));
        assertNull(menu.buyPlant(new Position(1,1),1,11,10));

        menu.setBudget(60);
        assertNull(menu.buyPlant(new Position(1,1),1,61,10));
    }
}
