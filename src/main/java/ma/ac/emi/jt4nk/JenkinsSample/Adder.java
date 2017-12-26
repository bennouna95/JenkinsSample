package ma.ac.emi.jt4nk.JenkinsSample;

import java.util.Arrays;

/**
 * Helper for addition
 */
public class Adder {
    /**
     * Add integers
     * @param a base integer
     * @param b list of integer to add
     * @return sum of theses integers
     */
    public static int add(int a, int ...b){
        return a + Arrays.stream(b).sum();
    }
}
