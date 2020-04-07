import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpressoPlantTest {


    /* Need to test ordering of cases:
     *  1. If the string denoting name of plant is correct. e.g., spresso
     *  2. If the number of rounds needed for the plant to grow is correct.
     *  3. If the number of Jolts the plant harvest yields is correct.
     */

    /* Common case: name should be properly set at construction and return
     *              it correctly. Also checking getName() method.
     * Black-box
     */
    @Test
    void setName() {
        SpressoPlant sp = new SpressoPlant();
        sp.setName("Mericano Plant");
        assertEquals("Mericano Plant", sp.getName(), "Set name is " + sp.getName());
    }


    /* Common case: The growth of plant is set at construction and return
                    it correctly. Also checking getPlantGrowth() method.
     * White-box
     */

    @Test
    void setPlantGrowth() {
        SpressoPlant sp = new SpressoPlant();
        sp.setPlantGrowth(20);
        assertEquals(20,sp.getPlantGrowth(), "The growth value is" + sp.getPlantGrowth());
    }

    /* Common case: The jolts of plant is set at construction and return
                it correctly. Also checking getPlantJolts() method.
    * White-box
     */
    @Test
    void setPlantJolts() {
        SpressoPlant sp = new SpressoPlant();
        sp.setPlantJolts(2);
        assertEquals(2, sp.getPlantJolts(), "The plant jolts is" + sp.getPlantJolts());
    }


}