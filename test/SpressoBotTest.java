import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpressoBotTest {

    /* Need to test ordering of cases:
     *  1. The least number of rounds before Spresso plants are ready for harvest.
     *  2. There are no other TimBots in the district.
     *  3. There are no TimBots in the adjacent districts.
     *  4. The order the districts as listed above.
     *  Also test whether energy level is properly being adjusted
     * Case 1: bot stays in CURRENT => Energy level unchanged
     * Case 2: bot moves => Energy level degremented
     * Case 3: bot follows spresso above all else
     * Case 4: spresso being equal, bot prefers to avoid other bots
     * Case 5: spress and bots being equal, bot prefers to avoid adjacent bots
     * Case 6: everything is equal so that bot prefers in order of districts
     */

    /* Case 1: Bot stays in CURRENT => energy level does not change
     * Blackbox
     */
    @Test
    void getNextMoveCase1() {
        TimBot t = new SpressoBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 10, 10, 10, 10};
        boolean [] botsSensed = {false, true, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.CURRENT, t.getNextMove(), "Should not move");
        assertTrue(t.useShield(), "Energy level should be at 1");
        assertFalse(t.useShield(), "Energy level should be at 0");
    }

    /* Case 2: Bot moves out of CURRENT => energy level drops
     * Blackbox
     */
    @Test
    void getNextMoveCase2() {
        TimBot t = new SpressoBot(42, 2);
        t.startRound();
        int [] spressoSensed = {10, 0, 10, 10, 10};
        boolean [] botsSensed = {false, false, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.NORTH, t.getNextMove(), "Should not move");
        assertFalse(t.useShield(), "Energy level should be at 0");
    }

    /* Case 3: Bot should go to spresso most ready to be harvested
     * Blackbox
     */
    @Test
    void getNextMoveCase3() {
        TimBot t = new SpressoBot(42, 2);
        t.startRound();
        int [] spressoSensed = {10, 10, 0, 10, 10};
        boolean [] botsSensed = {false, false, true, false, false};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.EAST, t.getNextMove(), "Should follow spresso");
    }

    /* Case 4: Bot should avoid other bots if spresso is equal
     * Blackbox
     */
    @Test
    void getNextMoveCase4() {
        TimBot t = new SpressoBot(42, 2);
        t.startRound();
        int [] spressoSensed = {10, 0, 0, 0, 0};
        boolean [] botsSensed = {false, true, true, false, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.SOUTH, t.getNextMove(), "Should avoid others");
    }

    /* Case 5: Bot should avoid adjacent bots if possible
     * Blackbox
     */
    @Test
    void getNextMoveCase5() {
        TimBot t = new SpressoBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 0, 0, 0, 0};
        boolean [] botsSensed = {false, true, true, true, false};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.WEST, t.getNextMove(), "Should avoid adjacent bots");
    }

    /* Case 5: Bot should avoid adjacent bots if possible
     * Blackbox
     */
    @Test
    void getNextMoveCase6() {
        TimBot t = new SpressoBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 0, 0, 0, 0};
        boolean [] botsSensed = {false, false, false, false, false};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.CURRENT, t.getNextMove(), "Should avoid adjacent bots");
    }
}
