package assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class magicTest {

    @Test
    void findOccurance() {
        magic magic= new magic();

        magic.setStr("abcabdca");

        assertEquals(2,magic.findOccurance(1,8,'c'));
        assertEquals(4,magic.findOccurance(1,15,'b'));
        assertEquals(3,magic.findOccurance(4,9,'a'));
        assertEquals(3,magic.findOccurance(5,25,'d'));
        assertEquals(2,magic.findOccurance(2,7,'c'));
        assertEquals(2,magic.findOccurance(3,8,'c'));


        magic.setStr("abc");

        assertEquals(2,magic.findOccurance(1,8,'c'));
        assertEquals(5,magic.findOccurance(1,15,'b'));
        assertEquals(2,magic.findOccurance(4,9,'a'));
        assertEquals(7,magic.findOccurance(5,25,'a'));
        assertEquals(2,magic.findOccurance(2,7,'c'));
        assertEquals(2,magic.findOccurance(2,8,'c'));
    }
}