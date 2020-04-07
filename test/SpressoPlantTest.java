import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpressoPlantTest {

    @Test
    void setName() {
        SpressoPlant sp = new SpressoPlant();
        sp.setName("Mericano Plant");
        assertEquals("Mericano Plant", sp.getName(), "Set name is " + sp.getName());
    }

    @Test
    void setPlantGrowth() {
        SpressoPlant sp = new SpressoPlant();
        sp.setPlantGrowth(20);
        assertEquals(20,sp.getPlantGrowth(), "The growth value is" + sp.getPlantGrowth());
    }

    @Test
    void setPlantJolts() {
        SpressoPlant sp = new SpressoPlant();
        sp.setPlantJolts(2);
        assertEquals(2, sp.getPlantJolts(), "The plant jolts is" + sp.getPlantJolts());
    }


}