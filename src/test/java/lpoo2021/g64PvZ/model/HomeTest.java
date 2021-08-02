package lpoo2021.g64PvZ.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeTest {
    private Home home;

    @BeforeEach
    void setUp(){
        home = new Home();
    }

    @Test
    void nextOption(){
        home.nextOption();
        Assertions.assertEquals(1,home.getCurrentOption());
        home.nextOption();
        Assertions.assertEquals(1,home.getCurrentOption());
    }

    @Test
    void previousOption(){
        Assertions.assertEquals(0,home.getCurrentOption());
        home.previousOption();
        Assertions.assertEquals(0,home.getCurrentOption());
    }

    @Test
    void isStart(){
        Assertions.assertTrue(home.isStart());
        home.nextOption();
        Assertions.assertFalse(home.isStart());
        home.previousOption();
        Assertions.assertTrue(home.isStart());
    }
}
