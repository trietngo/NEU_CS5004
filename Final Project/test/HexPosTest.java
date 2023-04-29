/**
 * Import JUnit Testing Suite
 */

import Model.World.HexPos;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HexPosTest {
    private HexPos testPosDefault;
    private HexPos testPos;

    /**
     * Set up a hex pos object
     */
    @Before
    public void setup() {
        testPosDefault = new HexPos();
        testPos = new HexPos(5, 6);
    }

    /**
     * Test whether all methods work as intended
     */
    @Test
    public void testMethods() {
        // Default pos
        assertEquals(0, testPosDefault.getX());
        assertEquals(0, testPosDefault.getY());

        // Custom pos
        assertEquals(5, testPos.getX());
        assertEquals(6, testPos.getY());

        // Set new pos
        testPos.setX(12);
        testPos.setY(395);

        // Check new pos values
        assertEquals(12, testPos.getX());
        assertEquals(395, testPos.getY());
    }
}
