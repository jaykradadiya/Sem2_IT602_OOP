package assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsAndCowsTest {

    @Test
    void getBullsAndCows() {
        BullsAndCows bullsAndCows= new BullsAndCows();
        bullsAndCows.setGuess("1807");
        bullsAndCows.setSecret("7810");

        assertEquals("1A3B",bullsAndCows.generateHint());


        bullsAndCows.setSecret("2037");
        bullsAndCows.setGuess("2345");
        assertEquals("1A1B",bullsAndCows.generateHint());

        bullsAndCows.setSecret("43018");
        bullsAndCows.setGuess("01234");
        assertEquals("0A4B",bullsAndCows.generateHint());

        bullsAndCows.setGuess("14789");
        assertEquals("0A3B",bullsAndCows.generateHint());

        bullsAndCows.setSecret("43018349032743483054");
        bullsAndCows.setGuess( "01234545465465667679");
        assertEquals("1A10B",bullsAndCows.generateHint());
    }
}