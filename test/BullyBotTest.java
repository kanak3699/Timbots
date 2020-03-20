import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullyBotTest {
    /* Need to test :
     *  1. The BullyBot does not fire if it does not have enough energy
     *  2. The BullyBot does not fire if there is nothing to fire at
     *  3. The BullyBot only fires at nonempty districts
     *  4. The BullyBot does not fire more Jolts than allowed
     */

    /*  Common Case: BullyBot does not fire if there is not enough energy
     *  Blackbox
     */
    @Test
    void fireCannonNotEnoughEnergy() {
        TimBot t = new BullyBot(42, 3);
        t.startRound();
        int [] spressoSensed = {0, 10, 10, 10, 10};
        boolean [] botsSensed = {false, true, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertNull(t.fireCannon(), "Should not fire cannon");
        assertEquals(2, t.energyLevel, "Energy level should be 2");
    }

    /*  Common Case: BullyBot does not fire if there is nothing to fire at
     *  Blackbox
     */
    @Test
    void fireCannonNoTargets() {
        TimBot t = new BullyBot(42, 4);
        t.startRound();
        int [] spressoSensed = {0, 10, 10, 10, 10};
        boolean [] botsSensed = {false, false, false, false, false};
        t.senseDistricts(spressoSensed, botsSensed);
        assertNull(t.fireCannon(), "Should not fire cannon");
        assertEquals(3, t.energyLevel, "Energy level should be 3");
    }

    /*  Common Case: BullyBot does not use more jolts than allowed.  Should fire once
     *  Blackbox
     */
    @Test
    void fireCannonMoreTargetThanEnergy() {
        TimBot t = new BullyBot(42, 4);
        t.startRound();
        int [] spressoSensed = {0, 10, 10, 10, 10};
        boolean [] botsSensed = {false, true, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        int [] fire = t.fireCannon();
        assertNotNull(fire, "Should fire cannon");
        assertEquals(1, fire.length, "One shot should be fired");
        assertEquals(District.NORTH, fire[0], "Only NORTH should be attacked");
        assertEquals(2, t.energyLevel, "Energy level should be 2");
    }

    /*  Common Case: BullyBot only shoots at real targets.  Should fire twice
     *  Blackbox
     */
    @Test
    void fireCannonLessTargetThanEnergy() {
        TimBot t = new BullyBot(42, 10);
        t.startRound();
        int [] spressoSensed = {0, 10, 10, 10, 10};
        boolean [] botsSensed = {false, true, false, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        int [] fire = t.fireCannon();
        assertNotNull(fire, "Shouldfire cannon");
        assertEquals(3, fire.length, "One shot should be fired");
        assertEquals(District.NORTH, fire[0], "First, NORTH should be attacked");
        assertEquals(District.SOUTH, fire[1], "Second, SOUTH should be attacked");
        assertEquals(District.WEST, fire[2], "Third, WEST should be attacked");
        assertEquals(6, t.energyLevel, "Energy level should be 6");
    }
}