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
        mp.setPlantGrowth(20);
        assertEquals(20,mp.getGrowth(), "The growth value is" + mp.getGrowth());
    }

    @Test
    void setPlantJolts() {
        MericanoPlant mp = new MericanoPlant();
        mp.setPlantJolts(2);
        assertEquals(2, mp.getPlantJolts(), "The plant jolts is" + mp.getPlantJolts());
    }

}