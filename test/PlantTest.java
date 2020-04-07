import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantTest {

    /* Need to test ordering of cases:
     *  1. The values that the plant is returning.
     *  2. If the plant is being harvested or not.
     *  3. If it keeps track of the counter.
     *  4. If the x coordinate of the district containing the plant, where 0 ≤ X < C
     *  5. If the y coordinate of the district containing the plant, where 0 ≤ Y < C
     */

    /* Boundary case: setVal() should return the values of jolts and growth.
     * White-box Testing
     */
    @Test
    void setVal() {
        Plant p1 = new Plant();
        p1.setVal(1,10);
        assertEquals(1, p1.getJolts(), "The value of jolts is " + p1.getJolts());
        assertEquals(10, p1.getGrowth(), "The value of jolts is " + p1.getGrowth());
    }

    /* Boundary case: isNotHarvested() should return true if plant is not harvested.
     * Black-box Testing
     */
    @Test
    void isNotHarvested() {
        Plant p1 = new Plant();
        p1.isNotHarvested();
        assertTrue(p1.isNotHarvested(), "It is not harvested! ");
    }


    /* Boundary case: setHarvested() should return false if plant is harvested.
     * Black-box Testing
     */
    @Test
    void setHarvested() {
        Plant p1 = new Plant();
        p1.setHarvested();
        assertFalse(p1.isNotHarvested(), "It has harvested");
    }

    /* Common case: Check if count data is being stored and if the reset counter works perfectly.
     * White-box:  We are checking before and after the resetCount() method is called
     *             and check if it works and set the counter back to 0 or not.
     */
    @Test
    void resetCount() {
        Plant p1 = new Plant();
        p1.count = 10;
        assertEquals(10, p1.getCounter(), "Before the counter is reset");
        p1.resetCount();
        assertEquals(0, p1.getCounter(), "After the counter is reset");
    }

    /* Common case: setX_coord() should return the values of x - coordinates of the district containing the plant.
     * Black-box
     */
    @Test
    void setX_coord() {
        Plant p1 = new Plant();
        p1.setX_coord(5);
        assertEquals(5, p1.getX_coord(), "X co-ordinate is " + p1.getX_coord());
    }

    /* Common case: setX_coord() should return the values of y - coordinates of the district containing the plant.
     * Black-box
     */
    @Test
    void setY_coord() {
        Plant p1 = new Plant();
        p1.setY_coord(5);
        assertEquals(5, p1.getY_coord(), "Y co-ordinate is " + p1.getY_coord());
    }
}