package com.sparta.kx.sorters;

import java.util.Random;

public class RandomArrayGenerator {
    public static int[] getRandomArray(int requiredLength) {
        Random rand = new Random();

        int[] randomArray = new int[requiredLength];
        for (int i = 0; i < requiredLength; i++) {
            randomArray[i] = rand.nextInt(100);
            //System.out.println(randomArray[i]);
        }
        return randomArray;
    }
}
