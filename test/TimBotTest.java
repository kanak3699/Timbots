import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class TimBotTest {
    private static final boolean [] botsSensed = {true, false, true, false, true};
    private static final int [] spressoSensed = {0, 1, 2, 3, 4};

    /* Common case: ID should be properly set at construction and returned by
     * getId()
     * Black-box
     */
    @Test
    void getID() {
        TimBot t = new TimBot(42, 1);
        assertEquals(42, t.getID(), "IDs do not match");
    }

    /* Common case: startRound() should return false is TimBot does not have at
     * least 1 jolt
     * Black-box
     */
    @Test
    void startRoundNoJolts() {
        TimBot t = new TimBot(42, 0);
        assertFalse(t.startRound(), "Timbot should be nonfunctional");
    }

    /* Boundary case: startRound() should return true if TimBot has 1 jolt
     * Black-box
     */
    @Test
    void startRoundOneJolts() {
        TimBot t = new TimBot(42, 1);
        assertTrue(t.startRound(), "Timbot should be functional");
    }

    /* Common case: startRound() should return true if TimBot has at least 1 jolt
     * Black-box
     */
    @Test
    void startRoundLotsOfJolts() {
        TimBot t = new TimBot(42, 2);
        assertTrue(t.startRound(), "Timbot should be functional");
    }

    /* Common case: check if sensor data is being stored.
     * White-box: We are checking internal data structures, the code just
     *            copies the arrays
     */
    @Test
    void senseDistricts() {
        TimBot t = new TimBot(42, 2);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        assertTrue(Arrays.equals(botsSensed, t.botsSensed),
                "botSensed not copied properly");
        assertTrue(Arrays.equals(spressoSensed, t.spressoSensed),
                "spressoSensed not copied properly");
    }

    /* Common case: Base-class behaviour is not to move
     * White-box: Default is not to move, but the spec is silent on the default
     */
    @Test
    void getNextMove() {
        TimBot t = new TimBot(42, 2);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.CURRENT, t.getNextMove(),
                "Default behaviour should be no move");
    }

    /* Common case: Should return false if energy level is below 0
     * Black-box
     */
    @Test
    void isFunctionalNonFunctional() {
        TimBot t = new TimBot(42, -1);
        assertFalse(t.isFunctional(), "Timbot should be nonfunctional");
    }

    /* Boundary case: Should return true if energy level is 0
     * Black-box
     */
    @Test
    void isFunctionalFunctional() {
        TimBot t = new TimBot(42, 0);
        assertTrue(t.isFunctional(), "Timbot should be functional");
    }

    /* Common case: Should return true if energy level is above 0
     * Black-box
     */
    @Test
    void isFunctionalFunctional2() {
        TimBot t = new TimBot(42, 1);
        assertTrue(t.isFunctional(), "Timbot should be functional");
    }

    /* Common case: No energy means shield fails
     * Black-box
     */
    @Test
    void useShieldFails() {
        TimBot t = new TimBot(42, 1);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        t.getNextMove();
        t.fireCannon();
        assertFalse(t.useShield(),
                "Not enough jolts to use shield");
    }

    /* Boundary case: 1 jolt means shield only works once
     * Black-box
     */
    @Test
    void useShieldSucceedsOnce() {
        TimBot t = new TimBot(42, 2);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        t.getNextMove();
        t.fireCannon();
        assertTrue(t.useShield(),
                "Sufficient jolts to use shield");
        assertFalse(t.useShield(),
                "Not enough jolts to use shield");
    }

    /* Common case: >1 jolts means shield only works multiple times
     * Black-box
     */
    @Test
    void useShieldSucceedsTwice() {
        TimBot t = new TimBot(42, 3);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        t.getNextMove();
        t.fireCannon();
        assertTrue(t.useShield(), "Sufficient jolts to use shield");
        assertTrue(t.useShield(), "Sufficient jolts to use shield again");
    }

    /* Common case: Check to ensure that energyLevel gets updated when the result
     *              is under 100
     * Grey-box.  We are accessing energyLevel directly because there is no getter
     */
    @Test
    void harvestSpressoUnder99() {
        TimBot t = new TimBot(42, 1);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        t.getNextMove();
        t.fireCannon();
        t.harvestSpresso(1);
        assertEquals(1, t.energyLevel, "Energy level not properly updated");
    }

    /* Common case: Check to ensure that energyLevel never exceeds 99
     * Grey-box.  We are accessing energyLevel directly because there is no getter
     */
    @Test
    void harvestSpressoOver99() {
        TimBot t = new TimBot(42, 1);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        t.getNextMove();
        t.fireCannon();
        t.harvestSpresso(100);
        assertEquals(99, t.energyLevel, "Energy level is not truncated");
    }

    /* Common case: Base-class behaviour is not to fire
     * White-box: Default is not to fire, but the spec is silent on the default
     */
    @Test
    void fireCannon() {
        TimBot t = new TimBot(42, 3);
        t.startRound();
        t.senseDistricts(spressoSensed, botsSensed);
        t.getNextMove();
        assertNull(t.fireCannon(), "Default behaviour is not to fire.");
    }

    /* Common case: Ensure information is printed out according to spec
     * Black-box
     */
    @Test
    void testToString() {
        TimBot t = new TimBot(42, 3);
        String s = String.format( "(%c %2d %2d)", t.personality, t.getID(),
                t.energyLevel );
        assertEquals(s, t.toString(), "toString results not as expected");
    }
}