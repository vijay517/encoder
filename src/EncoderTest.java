package src;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EncoderTest {
    @Test
    public void testEncodewithOffsetB() {
        // Test code goes here
        Encoder encoder = new Encoder('B');
        String actualEncoded = encoder.encode("HELLO WORLD");
        String expectedEncoded = "GDKKN VNQKC";

        assertEquals(expectedEncoded, actualEncoded);
    }

    @Test
    public void testEncodewithOffsetF() {
        // Test code goes here
        Encoder encoder = new Encoder('F');
        String actualEncoded = encoder.encode("HELLO WORLD");
        String expectedEncoded = "C/GGJ RJMG.";

        assertEquals(expectedEncoded, actualEncoded);
    }

    @Test
    public void testDecodewithOffsetB() {
        // Test code goes here
        Encoder encoder = new Encoder('B');
        String actualDecoded = encoder.decode("GDKKN VNQKC");
        String expectedDecoded = "HELLO WORLD";

        assertEquals(expectedDecoded, actualDecoded);
    }

    @Test
    public void testDecodewithOffsetF(){
        // Test code goes here
        Encoder encoder = new Encoder('F');
        String actualDecoded = encoder.decode("C/GGJ RJMG.");
        String expectedDecoded = "HELLO WORLD";

        assertEquals(expectedDecoded, actualDecoded);
    }
}