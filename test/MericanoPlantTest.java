import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MericanoPlantTest {

    @Test
    void setName() {
        MericanoPlant mp = new MericanoPlant();
        mp.setName("Mericano Plant");
        assertEquals("Mericano Plant", mp.getName(), "Set name is " + mp.getName());
    }

    @Test
    void setPlantGrowth() {
        MericanoPlant mp = new MericanoPlant();
        mp.setPlantGrowth(10);
        assertEquals(10,mp.getPlantGrowth(), "The growth value is" + mp.getPlantGrowth());
    }

    @Test
    void setPlantJolts() {
        MericanoPlant mp = new MericanoPlant();
        mp.setPlantJolts(3);
        assertEquals(3, mp.getPlantJolts(), "The plant jolts is" + mp.getPlantJolts());
    }

}