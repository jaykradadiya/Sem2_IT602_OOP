package assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class royelCircusTest {

    @Test
    void findRodeWithallColoredRing() {
        royelCircus rs = new royelCircus();
        assertEquals(1,rs.findRodeWithallColoredRing("R3G2B1G3B3"));
        assertEquals(0,rs.findRodeWithallColoredRing("R3G2B1G3"));
        assertEquals(2,rs.findRodeWithallColoredRing("R3G2B1G3B3R2B2"));
    }
}