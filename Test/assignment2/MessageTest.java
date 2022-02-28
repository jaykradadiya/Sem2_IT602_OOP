package assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void getDamegedCharecter() {
        Message msg = new Message();
        msg.setMessage("MAYDXYMAYDAY");
        assertEquals(1,msg.getDamegedCharecter());

        msg.setMessage("MAYDXYMA4DAY");
        assertEquals(2,msg.getDamegedCharecter());

        msg.setMessage("MAYDAYMAYDAY");
        assertEquals(0,msg.getDamegedCharecter());
    }
}