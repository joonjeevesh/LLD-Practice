package org.example.snakesAndLadders.utility;

public class Random4DigitNumber {
    public static int get() {
        int min = 1000;
        int max = 9999;
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
