package ma.ac.emi.jt4nk.JenkinsSample;

import java.util.Arrays;


public class Adder {
    public static int add(int a, int ...b){
        return a + Arrays.stream(b).sum();
    }
}
