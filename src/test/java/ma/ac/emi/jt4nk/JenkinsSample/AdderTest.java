package ma.ac.emi.jt4nk.JenkinsSample;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test helpers for addition
 */
public class AdderTest {

    /**
     * Test addition method
     */
    @Test
    public void add() {
        assertEquals("Basic addition", 2, Adder.add(1, 1));
        assertEquals("Multiple additions", 5, Adder.add(1, 1, 1, 1, 1));
        assertEquals("No second term", 1, Adder.add(1));
        assertEquals("Negative values", -2, Adder.add(-1,-1));
    }
}
