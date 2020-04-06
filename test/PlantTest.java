import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantTest {

    @Test
    void setVal() {
        Plant p1 = new Plant();
        p1.setVal(1,10);
        assertEquals(1, p1.getJolts(), "The value of jolts is " + p1.getJolts());
        assertEquals(10, p1.getGrowth(), "The value of jolts is " + p1.getGrowth());
    }

    @Test
    void isNotHarvested() {
        Plant p1 = new Plant();
        p1.isNotHarvested();
        assertTrue(p1.isNotHarvested(), "It is not harvested! ");
    }

    @Test
    void setHarvested() {
        Plant p1 = new Plant();
        p1.setHarvested();
        assertFalse(p1.isNotHarvested(), "It has harvested");
    }

    @Test
    void resetCount() {
        Plant p1 = new Plant();
        p1.count = 10;
        assertEquals(10, p1.getCounter(), "Before the counter is reset");
        p1.resetCount();
        assertEquals(0, p1.getCounter(), "After the counter is reset");
    }

    @Test
    void setX_coord() {
        Plant p1 = new Plant();
        p1.setX_coord(5);
        assertEquals(5, p1.getX_coord(), "X co-ordinate is " + p1.getX_coord());
    }

    @Test
    void setY_coord() {
        Plant p1 = new Plant();
        p1.setY_coord(5);
        assertEquals(5, p1.getY_coord(), "X co-ordinate is " + p1.getY_coord());
    }
}