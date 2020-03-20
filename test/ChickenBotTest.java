import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChickenBotTest {
    /* Need to test ordering of cases:
     *  1. There are no other TimBots in the district.
     *  2. There are no TimBots in the adjacent districts.
     *  3. The least number of rounds before Spresso plants are ready for harvest.
     *  4. The order the districts as listed above.
     *  Also test whether energy level is properly being adjusted
     * Case 0: Energy level to low to move
     * Case 1: bot stays in CURRENT => Energy level unchanged
     * Case 2: bot moves => Energy level decremented
     * Case 3: bot avoids other bots and adjacent bots even though xpresso is
     *         greatest in district with bot
     * Case 4: bot avoids adjacent bots, even though espresso is best in CURRENT
     * Case 5: bot follows spresso everything else being equal
     * Case 6: bot follows order everything being equal
     */

    /* Case 0: Energy level too low to move
     * Blackbox
     */
    @Test
    void getNextMoveCase0() {
        TimBot t = new ChickenBot(42, 1);
        t.startRound();
        int [] spressoSensed = {10, 0, 10, 10, 10};
        boolean [] botsSensed = {false, false, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.CURRENT, t.getNextMove(), "Should not move");
        assertTrue(t.isFunctional(), "Energy level should be at 0, but functiona;");
    }

    /* Case 1: Bot stays in CURRENT => energy level does not change
     * Blackbox
     */
    @Test
    void getNextMoveCase1() {
        TimBot t = new ChickenBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 10, 10, 10, 10};
        boolean [] botsSensed = {false, true, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.CURRENT, t.getNextMove(), "Should not move");
        assertTrue(t.useShield(), "Energy level should be at 1");
        assertFalse(t.useShield(), "Energy level should be at 0");
    }

    /* Case 2: Bot moves out of CURRENT => energy level does changes
     * Blackbox
     */
    @Test
    void getNextMoveCase2() {
        TimBot t = new ChickenBot(42, 2);
        t.startRound();
        int [] spressoSensed = {10, 0, 10, 10, 10};
        boolean [] botsSensed = {false, false, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.NORTH, t.getNextMove(), "Should not move");
        assertFalse(t.useShield(), "Energy level should be at 0");
    }

    /* Case 3: Bot avoids other bots at all costs
     * Blackbox
     */
    @Test
    void getNextMoveCase3() {
        TimBot t = new ChickenBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 10, 0, 0, 0};
        boolean [] botsSensed = {false, true, true, true, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.CURRENT, t.getNextMove(), "Should avoid all bots");
    }

    /* Case 4: Bot should avoid adjacnet bots even if spresso is better to stay
     * Blackbox
     */
    @Test
    void getNextMoveCase4() {
        TimBot t = new ChickenBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 00, 0, 10, 0};
        boolean [] botsSensed = {false, true, true, false, true};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.SOUTH, t.getNextMove(), "Should avoid others");
    }

    /* Case 5: Bot follows spresso everything else being equale
     * Blackbox
     */
    @Test
    void getNextMoveCase5() {
        TimBot t = new ChickenBot(42, 2);
        t.startRound();
        int [] spressoSensed = {10, 10, 10, 10, 0};
        boolean [] botsSensed = {false, false, false, false, false};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.WEST, t.getNextMove(), "Should follow spresso");
    }

    /* Case 5: Bot should follow order of districts
     * Blackbox
     */
    @Test
    void getNextMoveCase6() {
        TimBot t = new ChickenBot(42, 2);
        t.startRound();
        int [] spressoSensed = {0, 0, 0, 0, 0};
        boolean [] botsSensed = {false, false, false, false, false};
        t.senseDistricts(spressoSensed, botsSensed);
        assertEquals(District.CURRENT, t.getNextMove(), "Should avoid adjacent bots");
    }
}