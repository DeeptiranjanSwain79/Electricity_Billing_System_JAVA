package Electricity;

import java.util.Random;

public class x {
    public static void main(String[] args) {
        Random r = new Random();
        long m1 = Math.abs(r.nextLong() % 10000000000L);
        System.out.println(m1);

    }
}
