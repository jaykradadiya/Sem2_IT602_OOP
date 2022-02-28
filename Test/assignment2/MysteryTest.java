package assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MysteryTest {

    @Test
    void solveMystery() {
        Mystery mystery = new Mystery();
        mystery.setMystry("app");
        assertEquals("YES p",mystery.SolveMystery());
        mystery.setMystry("madam");
        assertEquals("YES d",mystery.SolveMystery());
    }
}