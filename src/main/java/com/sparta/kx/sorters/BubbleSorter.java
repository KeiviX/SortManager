package com.sparta.kx.sorters;

import java.util.Arrays;
import java.util.Random;

public class BubbleSorter {
    public static void main( String[] args ) {
        int requiredLength = 20;
        int[] numbers = getRandomArray(requiredLength);
        System.out.println("Before sort:" + Arrays.toString(numbers));
        System.out.println("After sort: " + Arrays.toString(sortArray(numbers)));
    }

    //static int[] getRandomArray(int requiredLength) {
    static int[] getRandomArray(int requiredLength) {
        Random rand = new Random();

        int[] randomArray = new int[requiredLength];
        for (int i = 0; i < requiredLength; i++) {
            randomArray[i] = rand.nextInt(100);
            //System.out.println(randomArray[i]);
        }
        return randomArray;
    }

    static int[] sortArray(int [] arrayToSearch) {
        int count = arrayToSearch.length;
        for(int i = 0; i < count -1; i++) {
            for (int j = 0; j < count - 1; j ++) {
                if (arrayToSearch[j] > arrayToSearch[j+1]) {
                    swapTriangle(arrayToSearch, j);
                }
            }
        }
        return arrayToSearch;
    }

    public static void swapTriangle(int[] arrayToSearch, int j) {
        int temp;
        temp = arrayToSearch[j];
        arrayToSearch[j] = arrayToSearch[j+1];
        arrayToSearch[j+1] = temp;
    }
}
