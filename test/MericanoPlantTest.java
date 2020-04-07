import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MericanoPlantTest {
    /* Need to test ordering of cases:
     *  1. If the string denoting name of plant is correct. e.g., mericano
     *  2. If the number of rounds needed for the plant to grow is correct.
     *  3. If the number of Jolts the plant harvest yields is correct.
     */

    /* Common case: name should be properly set at construction and return
     *              it correctly. Also checking getName() method.
     * Black-box
     */
    @Test
    void setName() {
        MericanoPlant mp = new MericanoPlant();
        mp.setName("Mericano Plant");
        assertEquals("Mericano Plant", mp.getName(), "Set name is " + mp.getName());
    }

    /* Common case: The growth of plant is set at construction and return
                it correctly. Also checking getPlantGrowth() method.
    * White-box
    */
    @Test
    void setPlantGrowth() {
        MericanoPlant mp = new MericanoPlant();
        mp.setPlantGrowth(10);
        assertEquals(10,mp.getPlantGrowth(), "The growth value is" + mp.getPlantGrowth());
    }

    /* Common case: The jolts of plant is set at construction and return
            it correctly. Also checking getPlantJolts() method.
    * White-box
    */
    @Test
    void setPlantJolts() {
        MericanoPlant mp = new MericanoPlant();
        mp.setPlantJolts(3);
        assertEquals(3, mp.getPlantJolts(), "The plant jolts is" + mp.getPlantJolts());
    }

}