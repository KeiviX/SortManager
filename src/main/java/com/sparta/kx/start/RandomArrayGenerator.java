package com.sparta.kx.start;

import java.util.Random;

public class RandomArrayGenerator {

    public static int[] createArray(int requiredLength) {
        Random rand = new Random();
        int[] randomArray = new int[requiredLength];
        for (int i = 0; i < requiredLength; i++) {
            randomArray[i] = rand.nextInt(100);
        }
        return randomArray;
    }
}
